package com.example.employeems.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public class AddEmployeeRequest {
    @NotNull
    @Length(min = 2,max = 20,message = "name should be between 2 and 20")
    private String name;
    @Min(20)
    private double salary;
    @NotNull
    @Length(min = 2)
    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
