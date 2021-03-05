package com.cheekupeeku.testintent;

import java.io.Serializable;

// POJO Plain Old Java Object
public class Product implements Serializable {
   private String name;
   private int price;
   private String brand;
   public Product(){}
    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
