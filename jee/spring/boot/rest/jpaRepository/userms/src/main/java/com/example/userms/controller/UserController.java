package com.example.userms.controller;

import com.example.userms.dto.AddUserRequest;
import com.example.userms.dto.ChangeUserAgeRequest;
import com.example.userms.dto.UserDetails;
import com.example.userms.exception.UserNotFoundException;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private IUserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/adduser")
    public UserDetails addUser(@RequestBody AddUserRequest requestData){
        UserDetails response = service.addUser(requestData);
        return response;
    }

    @GetMapping("/findbyid/{id}")
    public UserDetails findUserDetailsById(@PathVariable int id) throws UserNotFoundException {
        UserDetails response = service.findUserDetailsById(id);
        return response;
    }

    @GetMapping("/findall")
    public List<UserDetails> findAllUser(){
        List<UserDetails> response=service.findAll();
        return response;
    }
    @GetMapping("/getall")
    public List<UserDetails> getAllUsers(){
        List<UserDetails> response=service.getAll();
        return response;
    }
    @GetMapping("/getallusers")
    public List<UserDetails> getUsers(){
        List<UserDetails> response=service.getAllUsers();
        return response;
    }
    @GetMapping("/findbyname/{name}")
    public List<UserDetails> findAllUserByName(@PathVariable String name){
        List<UserDetails> response=service.findUserByName(name);
        return response;
    }
    @GetMapping("/findallbyname/{name}")
    public List<UserDetails> findAllByName(@PathVariable String name){
        List<UserDetails> response=service.findAllUserByName(name);
        return response;
    }
    @GetMapping("/findbycity/{city}")
    public List<UserDetails> findAllUserByCity(@PathVariable String city){
        List<UserDetails> response=service.findUserByCity(city);
        return response;
    }
    @GetMapping("/findbycityandstate/{city}/{state}")
    public List<UserDetails> findAllUserByCityAndState(@PathVariable String city,@PathVariable String state){
        List<UserDetails> response=service.findUserByCityAndState(city,state);
        return response;
    }
    @GetMapping("/findbycityorstate/{city}/{state}")
    public List<UserDetails> findAllUserByCityOrState(@PathVariable String city,@PathVariable String state){
        List<UserDetails> response=service.findUserByCityOrState(city,state);
        return response;
    }

    @PutMapping("/update/age/{id}")
    public UserDetails updateUserAge(@PathVariable int id, @RequestBody ChangeUserAgeRequest requestData) throws UserNotFoundException {
        UserDetails response=service.updateAge(id,requestData);
        return response;
    }
    @DeleteMapping("/deletebyid/{id}")
    public String deleteUser(@PathVariable int id) throws Exception{
        String msg=service.deleteUser(id);
        return msg;
    }


}
