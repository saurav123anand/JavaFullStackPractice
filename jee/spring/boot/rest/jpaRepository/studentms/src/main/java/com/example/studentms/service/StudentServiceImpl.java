package com.example.studentms.service;

import com.example.studentms.dto.BookAddRequest;
import com.example.studentms.dto.StudentAddRequest;
import com.example.studentms.dto.StudentDetails;
import com.example.studentms.entities.Book;
import com.example.studentms.entities.Student;
import com.example.studentms.exception.StudentNotFoundException;
import com.example.studentms.repository.StudentRepository;
import com.example.studentms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentUtil util;
    @Override
    public StudentDetails addStudent(StudentAddRequest requestData) {
        String randomId= UUID.randomUUID().toString();
        Student student=new Student(requestData.getName(),requestData.getAge(),requestData.getAddress());
        student.setStudentId(randomId);
        Student added= repository.save(student);
        StudentDetails details=util.toStudentDetails(added);
        return details;
    }

    @Override
    public Student findById(String studentId) {
        Optional<Student> student=repository.findById(studentId);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student not found for id "+studentId);
        }
        return student.get();
    }

    @Override
    public StudentDetails findDetailsById(String studentId) {
       Student student= findById(studentId);
       StudentDetails details=util.toStudentDetails(student);
       return details;
    }

    @Override
    public StudentDetails addBook(BookAddRequest requestData) {
        Student student=findById(requestData.getStudentId());
        List<Book> books=student.getBooks();
        books.add(requestData.getBook());
        student.setBooks(books);
        student=repository.save(student);
        StudentDetails details=util.toStudentDetails(student);
        return details;
    }

    @Override
    public void deleteStudent(String studentId) {
       Student student =findById(studentId);
       repository.delete(student);
    }
    /*public Student findByAddressId(int addressId){
        List<Student> studentList=repository.findAll();
        for(Student student:studentList){
            Address address=student.getAddress();
            if(address.getAddressId()==addressId){
                return student;
            }
        }
        return null;
    }*/

}
