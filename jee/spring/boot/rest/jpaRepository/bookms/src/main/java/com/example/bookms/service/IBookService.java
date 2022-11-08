package com.example.bookms.service;

import com.example.bookms.dto.AddBookRequest;
import com.example.bookms.dto.BookDetails;
import com.example.bookms.entity.Book;
import com.example.bookms.exception.BookNotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface IBookService {
    BookDetails addBook(@Valid AddBookRequest requestData);
    Book findById(int id) throws BookNotFoundException;
    BookDetails findBookById(int id) throws BookNotFoundException;
    List<BookDetails> findAll() throws BookNotFoundException;
    void deleteBook(int id) throws BookNotFoundException;
}
