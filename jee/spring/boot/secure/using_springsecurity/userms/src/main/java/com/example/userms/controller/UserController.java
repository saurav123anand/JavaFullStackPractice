package com.example.userms.controller;

import com.example.userms.entity.User;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService service;


    public User add(@RequestBody User user) {
      User added= service.add(user);
      return user;
    }

    @GetMapping("/findbyusername/{username}")
    public User findById(@PathVariable String username){
        User user=service.findByUsername(username);
        return user;
    }
    @GetMapping("/findall")
    public List<User> findAll(){
        List<User> users=service.findAll();
        return users;
    }



}
