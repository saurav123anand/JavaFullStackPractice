package bookms;

public class Book {
    private String name;
    private String Author;
    private String genre;
    private double price;
    private int pages;

    public Book() {
    }

    public Book(String name, String author, String genre, double price, int pages) {
        this.name = name;
        this.Author = author;
        this.genre = genre;
        this.price = price;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }
}
