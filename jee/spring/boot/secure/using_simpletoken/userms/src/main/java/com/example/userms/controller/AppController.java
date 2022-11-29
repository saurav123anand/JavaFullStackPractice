package com.example.userms.controller;

import com.example.userms.dto.LoginRequestData;
import com.example.userms.dto.RegisterRequestData;
import com.example.userms.dto.UserDetails;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    private IUserService service;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public UserDetails register(@RequestBody RegisterRequestData requestData){
        UserDetails response=service.register(requestData);
        return response;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestData requestData) throws Exception {
        String response=service.login(requestData);
        return response;
    }
}
