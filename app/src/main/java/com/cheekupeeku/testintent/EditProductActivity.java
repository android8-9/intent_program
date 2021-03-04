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
        String name = in.getStringExtra("name");
        int price = in.getIntExtra("price",0);
        String brand = in.getStringExtra("brand");

        binding.etProductName.setText(name);
        binding.etProductPrice.setText(""+price);
        binding.etBrand.setText(brand);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = binding.etProductName.getText().toString();
               String price = binding.etProductPrice.getText().toString();
               String brand = binding.etBrand.getText().toString();
               Intent in = new Intent();

               in.putExtra("updatedName",name);
               in.putExtra("updatedPrice",price);
               in.putExtra("updatedBrand",brand);

               setResult(222,in);
               finish();
            }
        });

    }
}
