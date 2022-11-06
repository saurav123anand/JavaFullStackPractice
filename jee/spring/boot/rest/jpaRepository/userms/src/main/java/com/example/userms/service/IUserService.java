package com.example.userms.service;

import com.example.userms.dto.AddUserRequest;
import com.example.userms.dto.ChangeUserAgeRequest;
import com.example.userms.dto.UserDetails;
import com.example.userms.entity.User;
import com.example.userms.exception.UserNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IUserService {
    UserDetails addUser(@Valid AddUserRequest requestData);

    UserDetails updateAge(@Min(1) int id, @Valid ChangeUserAgeRequest requestData) throws UserNotFoundException;

    User findById(@Min(1) int id) throws UserNotFoundException;

    UserDetails findUserDetailsById(@Min(1) int id) throws UserNotFoundException;

    List<UserDetails> findAll();

    String deleteUser(@Min(1) int id) throws UserNotFoundException;

    List<UserDetails> getAll();

    List<UserDetails> getAllUsers();

    List<UserDetails> findUserByName(@NotNull @Length(min = 3) String name);

    List<UserDetails> findAllUserByName(@NotNull @Length(min = 3) String name);

    List<UserDetails> findUserByCity(@NotNull @Length(min = 3) String city);

    List<UserDetails> findUserByCityAndState(@NotNull @Length(min = 3) String city, @NotNull @Length(min = 3) String state);

    List<UserDetails> findUserByCityOrState(@NotNull @Length(min = 3) String city, @NotNull @Length(min = 3) String state);
}
