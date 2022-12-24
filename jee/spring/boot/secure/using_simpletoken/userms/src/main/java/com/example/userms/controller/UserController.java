package com.example.userms.controller;


import com.example.userms.dto.LoginRequestData;
import com.example.userms.dto.RegisterRequestData;
import com.example.userms.dto.UserDetails;
import com.example.userms.exception.InvalidCredentialException;
import com.example.userms.exception.InvalidTokenException;
import com.example.userms.exception.UserNotFoundException;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("/byusername/{username}")
    public UserDetails findByUsername(HttpServletRequest request ,@PathVariable String username) throws Exception{
       /* String token=request.getHeader("token");
        //just for our use
        UserDetails details=service.authenticateByToken(token);
        if(!details.getUsername().equals(username)){
            throw new InvalidTokenException("token is invalid");
        }
        //end of our use*/
        UserDetails response=service.findUserDetailsByUsername(username);
        return response;

    }
    @GetMapping("/all")
    public List<UserDetails> getAllUser(HttpServletRequest request) throws Exception{
        /*String token=request.getHeader("token");
        service.authenticateByToken(token);*/
        List<UserDetails> response=service.findAll();
        return response;
    }
}
