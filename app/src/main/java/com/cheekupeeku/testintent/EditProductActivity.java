package com.cheekupeeku.testintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditProductActivity extends AppCompatActivity {
    com.cheekupeeku.testintent.databinding.AddProductBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.cheekupeeku.testintent.databinding.AddProductBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.btnAdd.setText("Update product");

        Intent in = getIntent();
        Product p = (Product) in.getSerializableExtra("product");

        binding.etProductName.setText(p.getName());
        binding.etProductPrice.setText(""+p.getPrice());
        binding.etBrand.setText(p.getBrand());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = binding.etProductName.getText().toString();
               String price = binding.etProductPrice.getText().toString();
               String brand = binding.etBrand.getText().toString();
               Intent in = new Intent();

               Product p = new Product(name,Integer.parseInt(price),brand);
               in.putExtra("updatedProduct",p);
               setResult(222,in);
               finish();
            }
        });

    }
}
