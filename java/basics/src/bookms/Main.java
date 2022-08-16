package bookms;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        BookStore bookStore = new BookStore();
        Book book1 = new Book("3 mistakes of my life", "chetan bhagat", "fiction", 234.6, 124);
        Book book2 = new Book("catching fire", "jon alberto", "fiction", 224.6, 434);
        Book book3 = new Book("LNL", "barmuda", "naughty", 784.6, 654);
        System.out.println("adding books**************************");
        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        System.out.println("getting all books************************");
        List<Book> allBooks = bookStore.findAll();
        obj.display(allBooks);
        System.out.println("*****************found book by genre*******************");
        try {
            Book[] foundBooks = bookStore.findBookByGenre("naughty");
            for (Book book : foundBooks) {
                if(book!=null){
                    System.out.println("name is " + book.getName());
                    System.out.println("author is " + book.getAuthor());
                    System.out.println("genre is " + book.getGenre());
                    System.out.println("price is " + book.getPrice());
                    System.out.println("pages is " + book.getPages());
                    System.out.println("**************************");
                }
            }
        } catch (InvalidGenreException e) {
            e.getMessage();
        } catch (Exception e) {
            System.out.println("some error occurred");
        }
        System.out.println("**********updating price*************");
        Book foundBook=bookStore.updatePrice("catching fire",456);
        if(foundBook!=null){
            System.out.println("name is " + foundBook.getName());
            System.out.println("author is " + foundBook.getAuthor());
            System.out.println("genre is " + foundBook.getGenre());
            System.out.println("price is " + foundBook.getPrice());
            System.out.println("pages is " + foundBook.getPages());
            System.out.println("**************************");
        }
        System.out.println("getting all books after updating price************************");
        List<Book> allBooksFound = bookStore.findAll();
        obj.display(allBooksFound);

        System.out.println("***************removing book*******");
        String removeBook=bookStore.removeBook(book2);
        System.out.println(removeBook);
        System.out.println("getting all books after removing particular book************************");
        List<Book> allBooksFound2 = bookStore.findAll();
        obj.display(allBooksFound2);
    }

    public void display(Collection<Book> allBooks) {
        for (Book book : allBooks) {
            System.out.println("name is " + book.getName());
            System.out.println("author is " + book.getAuthor());
            System.out.println("genre is " + book.getGenre());
            System.out.println("price is " + book.getPrice());
            System.out.println("pages is " + book.getPages());
            System.out.println("**************************");
        }
    }

}
