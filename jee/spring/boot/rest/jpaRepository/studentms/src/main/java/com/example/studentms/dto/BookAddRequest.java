package com.example.studentms.dto;

import com.example.studentms.entities.Book;

import java.util.List;

public class BookAddRequest {
    private String studentId;
    private Book book;

    public BookAddRequest() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBooks(Book book) {
        this.book = book;
    }
}
