package com.example.demo.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
