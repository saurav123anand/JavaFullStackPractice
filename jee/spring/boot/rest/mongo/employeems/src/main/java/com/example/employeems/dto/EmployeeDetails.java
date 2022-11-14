package com.example.employeems.dto;

public class EmployeeDetails {
    private String id;
    private String name;
    private double salary;
    private String company;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String id, String name, double salary, String company) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
