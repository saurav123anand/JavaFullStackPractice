package com.example.mongodemo.controller;

import com.example.mongodemo.entity.User;
import com.example.mongodemo.exception.UserNotFoundException;
import com.example.mongodemo.service.IUserService;
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
    @PostMapping("/add")
    public User addUser(@RequestBody User requestData){
        User response=service.addUser(requestData);
        return response;
    }
    @GetMapping("/findbyid/{id}")
    public User findById(@PathVariable int id) throws UserNotFoundException {
        User response=service.findById(id);
        return response;
    }
    @PutMapping("/update/age/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User requestData) throws UserNotFoundException {
        User response=service.updateAge(id, requestData.getAge());
        return response;
    }
    @GetMapping("/findall")
    public List<User> findAll(){
        List<User> response=service.findAll();
        return response;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deletebyid/{id}")
    public String deleteUser(@PathVariable int id) throws UserNotFoundException {
        String msg=service.deleteUser(id);
        return msg;
    }

}
