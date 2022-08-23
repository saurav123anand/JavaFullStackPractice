package com.trainingapps.productms.exceptions;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
