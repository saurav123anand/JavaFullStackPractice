package com.example.studentms.controller;

import com.example.studentms.dto.BookAddRequest;
import com.example.studentms.dto.StudentAddRequest;
import com.example.studentms.dto.StudentDetails;
import com.example.studentms.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public StudentDetails addStudent(@RequestBody StudentAddRequest requestData){
        StudentDetails response= service.addStudent(requestData);
        return response;
    }
    @PutMapping("/books/addbook")
    public StudentDetails addBook(@RequestBody BookAddRequest requestData){
        StudentDetails response= service.addBook(requestData);
        return response;
    }
    @GetMapping("/findbystudentid/{studentId}")
    public StudentDetails findByStudentId(@PathVariable String studentId){
        StudentDetails response= service.findDetailsById(studentId);
        return response;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable String studentId){
        service.deleteStudent(studentId);
    }
}
