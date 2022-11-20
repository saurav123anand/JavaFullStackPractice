package com.example.userms.controller;


import com.example.userms.dto.RegisterRequestData;
import com.example.userms.dto.UserDetails;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public UserDetails register(@RequestBody RegisterRequestData requestData){
        UserDetails response=service.register(requestData);
        return response;
    }
    @GetMapping("/byusername/{username}")
    public UserDetails findByUsername(@PathVariable String username) throws Exception{
        UserDetails response=service.findUserDetailsByUsername(username);
        return response;
    }
    @GetMapping("/all")
    public List<UserDetails> getAllUser(){
        List<UserDetails> response=service.findAll();
        return response;
    }
}
