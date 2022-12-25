package com.example.studentms.service;


import com.example.studentms.dto.BookAddRequest;
import com.example.studentms.dto.StudentAddRequest;
import com.example.studentms.dto.StudentDetails;
import com.example.studentms.entities.Student;

public interface IStudentService {
    StudentDetails addStudent(StudentAddRequest requestData);
    Student findById(String studentId);
    StudentDetails findDetailsById(String studentId);
    StudentDetails addBook(BookAddRequest requestData);
    void deleteStudent(String studentId);
}
