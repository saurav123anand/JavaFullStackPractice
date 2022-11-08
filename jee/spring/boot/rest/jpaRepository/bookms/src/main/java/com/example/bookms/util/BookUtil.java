package com.example.bookms.util;

import com.example.bookms.dto.BookDetails;
import com.example.bookms.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookUtil {
    public BookDetails toBookDetails(Book book){
        BookDetails bookDetails=new BookDetails();
        bookDetails.setId(book.getId());
        bookDetails.setName(book.getName());
        bookDetails.setPrice(book.getPrice());
        return bookDetails;
    }
    public List<BookDetails> toBookDetails(List<Book> books){
        List<BookDetails> bookDetailsList=new ArrayList<>();
        for(Book book:books){
            BookDetails bookDetails=toBookDetails(book);
            bookDetailsList.add(bookDetails);
        }

        return bookDetailsList;
    }
}
