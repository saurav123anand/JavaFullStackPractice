package com.example.optimizedproductms.controller;


import com.example.optimizedproductms.exception.InvalidIdException;
import com.example.optimizedproductms.exception.InvalidNameException;
import com.example.optimizedproductms.exception.InvalidPriceException;
import com.example.optimizedproductms.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String ProductNotFoundExceptionHandler(ProductNotFoundException e){
        return e.getMessage();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public String InvalidIdHandler(InvalidIdException e){
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPriceException.class)
    public String InvalidPriceHandler(InvalidPriceException e){
        return e.getMessage();
    }*/

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidIdException.class,
            InvalidNameException.class,
            InvalidPriceException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    public String InvalidHandler(Exception e){
        return e.getMessage();
    }


}
