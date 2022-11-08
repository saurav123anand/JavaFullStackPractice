package com.example.bookms.controller;

import com.example.bookms.dto.AddBookRequest;
import com.example.bookms.dto.BookDetails;
import com.example.bookms.exception.BookNotFoundException;
import com.example.bookms.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {
    @Autowired
    private IBookService service;

    @PostMapping("/add")
    public ResponseEntity<BookDetails> addBook(@RequestBody AddBookRequest requestData){
      BookDetails response=service.addBook(requestData);
      return new ResponseEntity<BookDetails>(response,HttpStatus.CREATED);
    }

    //if you want to show exception message then use in this way
    @GetMapping("/findbyid/{id}")
    public ResponseEntity findBookById(@PathVariable int id){
        try{
           BookDetails response= service.findBookById(id);
           return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (BookNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //if you don't want to show exception message then use in this way
    @GetMapping("/findall")
    public ResponseEntity<List<BookDetails>> findAllBook(){
        try{
            List<BookDetails> response= service.findAll();
            return new ResponseEntity<List<BookDetails>>(response,HttpStatus.OK);
        }
        catch (BookNotFoundException e){
            return new ResponseEntity<List<BookDetails>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable int id){
        try{
            service.deleteBook(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (BookNotFoundException e){
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
    }




}
