package com.example.demo.exception;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String msg) {
        super(msg);
    }
}
