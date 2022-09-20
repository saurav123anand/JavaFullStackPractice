package com.trainingapps.jpaDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "employees")
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
