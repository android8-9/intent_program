package com.cheekupeeku.testintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cheekupeeku.testintent.databinding.ShowProductDetailsBinding;

public class ShowProductActivity extends AppCompatActivity {
    ShowProductDetailsBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShowProductDetailsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        Intent in = getIntent();

        Product p = (Product) in.getSerializableExtra("product");

        binding.tvProductName.setText(p.getName());
        binding.tvProductPrice.setText(""+p.getPrice());
        binding.tvBrand.setText(p.getBrand());
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.tvProductName.getText().toString();
                int price = Integer.parseInt(binding.tvProductPrice.getText().toString());
                String brand = binding.tvBrand.getText().toString();

                Intent in = new Intent(ShowProductActivity.this,EditProductActivity.class);
                Product p = new Product(name,price,brand);
                in.putExtra("product",p);
                startActivityForResult(in,111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "onActivityResult()-called", Toast.LENGTH_SHORT).show();
        if(requestCode == 111 && resultCode == 222 && data !=null) {
            Product p = (Product) data.getSerializableExtra("updatedProduct");
            binding.tvProductName.setText(p.getName());
            binding.tvBrand.setText(p.getBrand());
            binding.tvProductPrice.setText(""+p.getPrice());
        }
    }
}








