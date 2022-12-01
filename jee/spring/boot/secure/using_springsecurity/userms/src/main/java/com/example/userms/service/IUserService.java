package com.example.userms.service;

import com.example.userms.entity.User;

import java.util.List;

public interface IUserService {
   User add(User user);
   User findByUsername(String username);
   List<User> findAll();
}
