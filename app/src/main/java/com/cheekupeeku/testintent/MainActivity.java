package com.cheekupeeku.testintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.cheekupeeku.testintent.databinding.AddProductBinding;

public class MainActivity extends AppCompatActivity {
    AddProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddProductBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName= binding.etProductName.getText().toString();
                String price= binding.etProductPrice.getText().toString();
                String brand = binding.etBrand.getText().toString();

                if(TextUtils.isEmpty(productName)){
                    binding.etProductName.setError("please enter product name");
                    return;
                }
                if(TextUtils.isEmpty(price)){
                    binding.etProductPrice.setError("please enter price");
                    return;
                }
                if(TextUtils.isEmpty(brand)){
                    binding.etBrand.setError("please enter brand");
                    return;
                }
                Intent in = new Intent(MainActivity.this,ShowProductActivity.class);
                Product p = new Product(productName,Integer.parseInt(price),brand);
                in.putExtra("product",p);
                startActivity(in);
            }
        });
    }
}