package com.examportal.backend.models;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
