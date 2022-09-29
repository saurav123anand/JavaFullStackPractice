package com.example.demo.exception;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
