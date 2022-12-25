package com.example.userService.service;

import com.example.userService.entities.User;
import com.example.userService.exception.UserNotFoundException;
import com.example.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository repository;
    @Override
    public User saveUser(User user) {
        String randomId= UUID.randomUUID().toString();
        user.setUserId(randomId);
        user=repository.save(user);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return repository.findAll();
    }

    @Override
    public User findByUserId(String userId) {
        return repository.findById(userId).orElseThrow(()->new UserNotFoundException("user not found for userId "+userId));
    }
}
