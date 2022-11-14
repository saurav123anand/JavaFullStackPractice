package com.example.employeems.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("employees")
public class Employee {
    private String id;
    private String name;
    private double salary;
    private String company;

    public Employee() {
    }

    public Employee(String name, double salary, String company) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
