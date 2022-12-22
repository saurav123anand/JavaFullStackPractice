package com.example.userms.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/welcome")
    public String welcome() {
      return "<h3>Welcome to our website</h3>";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome to User page";
    }
    @GetMapping("/admin")
    public String  admin(){
       return "Welcome to Admin page";
    }



}
