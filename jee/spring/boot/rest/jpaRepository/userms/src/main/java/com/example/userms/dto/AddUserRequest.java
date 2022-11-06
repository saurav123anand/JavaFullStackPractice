package com.example.userms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddUserRequest {
    @NotNull
    @Length(min = 3)
    private String name;
    @Min(18)
    private int age;
    @NotNull
    @Length(min = 3)
    private String city;
    @NotNull
    @Length(min = 5)
    private String state;

    public AddUserRequest(String name, int age, String city, String state) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
