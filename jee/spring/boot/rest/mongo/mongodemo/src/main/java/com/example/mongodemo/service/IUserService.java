package com.example.mongodemo.service;

import com.example.mongodemo.entity.User;
import com.example.mongodemo.exception.UserNotFoundException;
import jdk.internal.icu.text.UnicodeSet;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    User findById(int id) throws UserNotFoundException;
    User updateAge(int id,int age) throws UserNotFoundException;
    List<User> findAll();
    String deleteUser(int id) throws UserNotFoundException;
}
