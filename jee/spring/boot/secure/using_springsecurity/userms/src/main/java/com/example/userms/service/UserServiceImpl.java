package com.example.userms.service;

import com.example.userms.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    List<User> users=new ArrayList<>();

    public UserServiceImpl(){
       users.add(new User("scooby","123"));
       users.add(new User("guchhu","1234"));
    }
    @Override
    public User add(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        for(User user:users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
