package entities;

import interfaces.IBook;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Book implements IBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;
    private String author;
    private String title;
    private String description;
    private String publisher;
    private int price;

    public Book(){}

    public Book(Long id, String author, String title, String description, String publisher, int price) {
        this.bookID = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
    }

    public void setBookID(Long id) {
        this.bookID = id;
    }

    public Long getBookID() {
        return bookID;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getPublisher() {
        return this.publisher;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "book")
    private Collection<UserBook> userBooks;
}
