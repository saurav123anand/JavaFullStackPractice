package com.example.userms.service;

import com.example.userms.dto.LoginRequestData;
import com.example.userms.dto.RegisterRequestData;
import com.example.userms.dto.UserDetails;
import com.example.userms.entity.User;
import com.example.userms.exception.InvalidCredentialException;
import com.example.userms.exception.InvalidTokenException;
import com.example.userms.exception.UserNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
@Validated
public interface IUserService {
    UserDetails register(@Valid RegisterRequestData requestData);
    User findByUsername(@Length(min = 2, max = 15) String username) throws UserNotFoundException;
    UserDetails findUserDetailsByUsername(@Length(min = 2, max = 15) String username) throws UserNotFoundException;
    List<UserDetails> findAll();
    String login(@Valid LoginRequestData requestData) throws InvalidCredentialException;
    UserDetails authenticateByToken(String token) throws InvalidTokenException, UserNotFoundException;
}
