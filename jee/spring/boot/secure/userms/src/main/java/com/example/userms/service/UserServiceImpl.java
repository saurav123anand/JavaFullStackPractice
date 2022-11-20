package com.example.userms.service;

import com.example.userms.dto.RegisterRequestData;
import com.example.userms.dto.UserDetails;
import com.example.userms.entity.User;
import com.example.userms.exception.UserNotFoundException;
import com.example.userms.repository.UserRepository;
import com.example.userms.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserUtil userUtil;


    @Override
    public UserDetails register(RegisterRequestData requestData) {
        User user = new User(requestData.getUsername(), requestData.getPassword(), requestData.getEmail());
        user = repository.save(user);
        UserDetails desired = userUtil.toUserDetails(user);
        return desired;

    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        Optional<User> optional=repository.findByUsername(username);
        if(!optional.isPresent()){
            throw new UserNotFoundException("user not found for username "+username);
        }
        User user=optional.get();
        return user;
    }

    @Override
    public UserDetails findUserDetailsByUsername(String username) throws UserNotFoundException {
        User user=findByUsername(username);
        UserDetails desired = userUtil.toUserDetails(user);
        return desired;
    }

    @Override
    public List<UserDetails> findAll() {
        List<User> users=repository.findAll();
        List<UserDetails> desired = userUtil.toUserDetails(users);
        return desired;
    }

}
