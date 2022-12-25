package com.example.userService.service;

import com.example.userService.entities.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    List<User> findAllUser();
    User findByUserId(String userId);
}
