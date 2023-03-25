package com.examportal.backend.service.impl;

import com.examportal.backend.exceptions.UserAlreadyExists;
import com.examportal.backend.exceptions.UserNotFoundException;
import com.examportal.backend.models.User;
import com.examportal.backend.models.UserRole;
import com.examportal.backend.repository.RoleRepository;
import com.examportal.backend.repository.UserRepository;
import com.examportal.backend.service.IUserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //Creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws UserAlreadyExists {
        User local=userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there!!");
            throw new UserAlreadyExists("User is already present!");
        }
        else{
            //create user
            for(UserRole userRole:userRoles){
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) throws UserNotFoundException {
        User user= userRepository.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException("User not found for username "+username);
        }
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
