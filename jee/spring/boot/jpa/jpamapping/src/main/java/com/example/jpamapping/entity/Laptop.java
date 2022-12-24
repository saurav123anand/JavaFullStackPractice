package com.example.jpamapping.entity;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    private int laptopId;
    private String modelName;
    private String brandName;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Laptop() {
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
