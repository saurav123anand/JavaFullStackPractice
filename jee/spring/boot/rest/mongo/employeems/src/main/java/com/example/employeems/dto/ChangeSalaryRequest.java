package com.example.employeems.dto;

import javax.validation.constraints.Min;

public class ChangeSalaryRequest {
    @Min(1000)
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
