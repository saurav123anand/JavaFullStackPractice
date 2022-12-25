package com.example.userService.controller;

import com.example.userService.entities.User;
import com.example.userService.service.IUserService;
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
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @GetMapping("/findbyuserid/{userid}")
    public User findUserByUserId(@PathVariable("userid") String userId){
        return service.findByUserId(userId);
    }
    @GetMapping("/findall")
    public List<User> findAllUser(){
        return service.findAllUser();
    }
}
