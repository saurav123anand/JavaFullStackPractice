package com.example.userms.exception;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(String invalid_token) {
        super(invalid_token);
    }
}
