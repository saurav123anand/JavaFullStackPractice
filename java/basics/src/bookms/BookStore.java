package bookms;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    List<Book> books=new ArrayList<Book>();
    public void addBook(Book book){
        books.add(book);
    }
    public Book[] findBookByGenre(String genre) throws InvalidGenreException {
        if(genre.isEmpty() || genre.isBlank()){
            throw new InvalidGenreException("genre that you are looking for is invalid");
        }
        Book foundBooks[]=new Book[5];
        int index=0;
        for(Book book:books){
            if(book!=null && book.getGenre().equalsIgnoreCase(genre)){
                if(index<foundBooks.length){
                    foundBooks[index]=book;
                    index++;
                }

            }
        }
        return foundBooks;
    }
    public String removeBook(Book book){
        books.remove(book);
        return book+" has been removed";
    }
    public List<Book> findAll(){
        return books;
    }  
    public Book updatePrice(String name,double price){
        for(Book book:books){
            if(book!=null && book.getName().equalsIgnoreCase(name)){
                book.setPrice(price);
                return book;
            }
        }
        return null;
    }





}
