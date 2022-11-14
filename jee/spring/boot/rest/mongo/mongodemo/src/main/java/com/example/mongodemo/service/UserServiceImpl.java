package com.example.mongodemo.service;

import com.example.mongodemo.entity.User;
import com.example.mongodemo.exception.UserNotFoundException;
import com.example.mongodemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository repository;

    private int generatedId;
    private int getGeneratedId(){
        return ++generatedId;
    }

    @Override
    public User addUser(User user) {
        user.setId(getGeneratedId());
        User added=repository.save(user);
        return added;
    }

    @Override
    public User findById(int id) throws UserNotFoundException {
        Optional<User> found=repository.findById(id);
        if(!found.isPresent()){
            throw new UserNotFoundException("user not found for id "+id);
        }
        return found.get();
    }

    @Override
    public User updateAge(int id, int age) throws UserNotFoundException {
        User found=findById(id);
        found.setAge(age);
        User updatedUser=repository.save(found);
        return updatedUser;
    }

    @Override
    public List<User> findAll() {
        List<User> users=repository.findAll();
        return users;
    }


    @Override
    public String deleteUser(int id) throws UserNotFoundException {
        User user=findById(id);
        repository.delete(user);
        return "user deleted for id "+id;
    }
}
