package com.example.mongodemo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String s) {
        super(s);
    }
}
