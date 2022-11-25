package com.example.userms.exception;

public class InvalidCredentialException extends Exception {
    public InvalidCredentialException(String invalid_credential) {
        super(invalid_credential);
    }
}
