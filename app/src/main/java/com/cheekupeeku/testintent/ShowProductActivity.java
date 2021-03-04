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
        String name = in.getStringExtra("name");
        int price = in.getIntExtra("price",0);
        String brand = in.getStringExtra("brand");
        binding.tvProductName.setText(name);
        binding.tvProductPrice.setText(""+price);
        binding.tvBrand.setText(brand);
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.tvProductName.getText().toString();
                int price = Integer.parseInt(binding.tvProductPrice.getText().toString());
                String brand = binding.tvBrand.getText().toString();

                Intent in = new Intent(ShowProductActivity.this,EditProductActivity.class);
                in.putExtra("name",name);
                in.putExtra("price",price);
                in.putExtra("brand",brand);
                startActivityForResult(in,111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "onActivityResult()-called", Toast.LENGTH_SHORT).show();
        if(requestCode == 111 && resultCode == 222 && data !=null) {
            String name = data.getStringExtra("updatedName");
            String price = data.getStringExtra("updatedPrice");
            String brand = data.getStringExtra("updatedBrand");
            binding.tvProductName.setText(name);
            binding.tvBrand.setText(brand);
            binding.tvProductPrice.setText(price);
        }
    }
}








