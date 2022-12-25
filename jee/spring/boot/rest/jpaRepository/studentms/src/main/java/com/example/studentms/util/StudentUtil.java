package com.example.studentms.util;

import com.example.studentms.dto.StudentDetails;
import com.example.studentms.entities.Book;
import com.example.studentms.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentUtil {

    public StudentDetails toStudentDetails(Student student){
        StudentDetails details=new StudentDetails();
        details.setStudentId(student.getStudentId());
        details.setName(student.getName());
        details.setAge(student.getAge());
        details.setAddress(student.getAddress());
        if(student.getBooks()==null){
            List<Book> bookList=new ArrayList<>();
            details.setBooks(bookList);
        }
        else{
            List<Book> bookList=student.getBooks();
            details.setBooks(student.getBooks());
        }
        return details;

    }
}
