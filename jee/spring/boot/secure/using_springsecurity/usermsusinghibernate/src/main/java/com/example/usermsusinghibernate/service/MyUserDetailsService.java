package com.example.usermsusinghibernate.service;

import com.example.usermsusinghibernate.entity.MyUserDetails;
import com.example.usermsusinghibernate.entity.User;
import com.example.usermsusinghibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=repository.findByUsername(username);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("user not found");
        }
        return new MyUserDetails(user.get());
    }

}

