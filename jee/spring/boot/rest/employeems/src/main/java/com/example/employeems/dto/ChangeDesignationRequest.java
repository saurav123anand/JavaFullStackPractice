package com.example.employeems.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ChangeDesignationRequest {
    @NotNull
    @Length(min = 2)
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
