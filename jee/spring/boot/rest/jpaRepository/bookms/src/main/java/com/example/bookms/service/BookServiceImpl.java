package com.example.bookms.service;

import com.example.bookms.dto.AddBookRequest;
import com.example.bookms.dto.BookDetails;
import com.example.bookms.entity.Book;
import com.example.bookms.exception.BookNotFoundException;
import com.example.bookms.repository.BookRepository;
import com.example.bookms.util.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookUtil util;
    @Override
    public BookDetails addBook(AddBookRequest requestData) {
        Book book=new Book(requestData.getName(),requestData.getPrice());
        Book addedBook=repository.save(book);
        BookDetails response= util.toBookDetails(addedBook);
        return response;

    }

    @Override
    public Book findById(int id) throws BookNotFoundException {
        Optional<Book> book=repository.findById(id);
        if(!book.isPresent()){
            throw new BookNotFoundException("book not found for id "+id);
        }
        return book.get();
    }

    @Override
    public BookDetails findBookById(int id) throws BookNotFoundException {
        Book book=findById(id);
        BookDetails response= util.toBookDetails(book);
        return response;

    }

    @Override
    public List<BookDetails> findAll() throws BookNotFoundException {
        List<Book> books=repository.findAll();
        List<BookDetails> response= util.toBookDetails(books);
        if(response.size()==0){
            throw new BookNotFoundException("no book found");
        }
        return response;
    }

    @Override
    public void deleteBook(int id) throws BookNotFoundException {
        Book book=findById(id);
        repository.delete(book);
    }
}
