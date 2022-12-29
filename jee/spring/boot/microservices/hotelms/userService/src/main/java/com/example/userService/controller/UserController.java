package com.example.userService.controller;

import com.example.userService.entities.User;
import com.example.userService.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @GetMapping("/findbyuserid/{userid}")
    public User findUserByUserId(@PathVariable("userid") String userId){
        User user= service.findByUserId(userId);
        return user;
    }
    public User ratingHotelFallback(String userId,Exception e){
        User user=new User();
        user.setUsername("dummy username");
        user.setEmail("dummy@gmail.com");
        user.setUserId("1234");
        user.setRatings(new ArrayList<>());
        return user;
    }

    @GetMapping("/findall")
    public List<User> findAllUser(){
        return service.findAllUser();
    }
}
