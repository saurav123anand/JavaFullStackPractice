package com.example.optimizedproductms.dto;

import javax.validation.constraints.Min;

public class ChangeProductRequest {
    @Min(1)
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
