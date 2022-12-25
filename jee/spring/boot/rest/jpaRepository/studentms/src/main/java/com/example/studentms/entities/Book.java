package com.example.studentms.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private int bookId;
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Book() {
    }
    public Book(String name, double price, Student student) {
        this.name = name;
        this.price = price;
        this.student = student;
    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
