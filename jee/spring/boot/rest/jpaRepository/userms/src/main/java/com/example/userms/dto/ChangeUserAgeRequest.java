package com.example.userms.dto;

import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Min;

public class ChangeUserAgeRequest {
    @Min(18)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
