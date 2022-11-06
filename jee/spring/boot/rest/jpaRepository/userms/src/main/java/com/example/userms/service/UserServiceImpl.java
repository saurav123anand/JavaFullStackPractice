package com.example.userms.service;

import com.example.userms.dto.AddUserRequest;
import com.example.userms.dto.ChangeUserAgeRequest;
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
    private UserUtil util;

    @Override
    public UserDetails addUser(AddUserRequest requestData) {
        User user = new User(requestData.getName(), requestData.getAge(), requestData.getCity(), requestData.getState());
        User addedUser = repository.save(user);
        UserDetails userDetails = util.toUserDetails(addedUser);
        return userDetails;

    }

    @Override
    public UserDetails updateAge(int id, ChangeUserAgeRequest requestData) throws UserNotFoundException {
        User user=findById(id);
        user.setAge(requestData.getAge());
        User updatedUser=repository.save(user);
        UserDetails userDetails = util.toUserDetails(updatedUser);
        return userDetails;
    }

    @Override
    public User findById(int id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found for id " + id);
        }
        return user.get();
    }

    @Override
    public UserDetails findUserDetailsById(int id) throws UserNotFoundException {
        User user = findById(id);
        UserDetails userDetails = util.toUserDetails(user);
        return userDetails;

    }

    @Override
    public List<UserDetails> findAll() {
        List<User> users = repository.findAll();
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public String deleteUser(int id) throws UserNotFoundException {
        User user=findById(id);
        if(user==null){
            throw new UserNotFoundException("User not found for id "+id);
        }
        repository.deleteById(id);
        return "User has been deleted for id "+id;
    }

    @Override
    public List<UserDetails> getAll() {
        List<User> users = repository.getAllUsers();
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> getAllUsers() {
        List<User> users = repository.getUsers();
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> findUserByName(String name) {
        List<User> users = repository.findByName(name);
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> findAllUserByName(String name) {
        List<User> users = repository.findAllUsersByName(name);
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> findUserByCity(String city) {
        List<User> users = repository.findByCity(city);
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> findUserByCityAndState(String city, String state) {
        List<User> users = repository.findByCityAndState(city,state);
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }

    @Override
    public List<UserDetails> findUserByCityOrState(String city, String state) {
        List<User> users = repository.findByCityOrState(city,state);
        List<UserDetails> userDetails = util.toUserDetails(users);
        return userDetails;
    }
}
