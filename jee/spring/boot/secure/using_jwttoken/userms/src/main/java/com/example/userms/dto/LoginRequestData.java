package com.example.userms.dto;

import org.hibernate.validator.constraints.Length;

public class LoginRequestData {
    @Length(min = 2, max = 15)
    private String username;
    @Length(min = 2, max = 15)
    private String password;

    public LoginRequestData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
