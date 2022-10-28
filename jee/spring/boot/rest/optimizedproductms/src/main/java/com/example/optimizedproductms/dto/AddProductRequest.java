package com.example.optimizedproductms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddProductRequest {
    @NotNull
    @Length(min = 3,max = 15,message = "name length must be between 3 and 15.")
    private String name;
    @Min(1)
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
