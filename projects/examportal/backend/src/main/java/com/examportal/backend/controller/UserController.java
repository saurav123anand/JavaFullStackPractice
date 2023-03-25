package com.examportal.backend.controller;

import com.examportal.backend.models.Role;
import com.examportal.backend.models.User;
import com.examportal.backend.models.UserRole;
import com.examportal.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        //encoding password with BCryptPasswordEncoder
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> userRoles = new HashSet<>();

        Role role1 = new Role();
        role1.setRoleId(45L);
        role1.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role1);

        userRoles.add(userRole);

        User response = userService.createUser(user, userRoles);
        return response;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {
        return userService.getUser(username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
