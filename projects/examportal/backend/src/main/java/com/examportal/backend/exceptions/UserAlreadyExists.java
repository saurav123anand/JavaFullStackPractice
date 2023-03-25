package com.examportal.backend.exceptions;

public class UserAlreadyExists extends Exception {
    public UserAlreadyExists(String s) {
        super(s);
    }
}
