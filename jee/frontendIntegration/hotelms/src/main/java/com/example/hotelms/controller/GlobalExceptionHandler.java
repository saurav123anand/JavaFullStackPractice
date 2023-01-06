package com.example.hotelms.controller;

import com.example.hotelms.entity.Hotel;
import com.example.hotelms.exception.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HotelNotFoundException.class)
    public String hotelNotFoundHandler(HotelNotFoundException e){
        return e.getMessage();
        
    }
}
