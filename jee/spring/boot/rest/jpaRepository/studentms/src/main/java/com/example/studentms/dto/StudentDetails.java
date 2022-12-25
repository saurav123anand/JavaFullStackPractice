package com.example.studentms.dto;

import com.example.studentms.entities.Address;
import com.example.studentms.entities.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDetails {
    private String studentId;
    private String name;
    private int age;
    private Address address;
    private List<Book> books=new ArrayList<>();

    public StudentDetails() {
    }

    public StudentDetails(String studentId, String name, int age, Address address, List<Book> books) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.books = books;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
