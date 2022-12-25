package com.example.ratingService.exception;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(String s) {
        super(s);
    }
}
