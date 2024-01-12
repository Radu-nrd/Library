package entities;

import interfaces.IBook;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;
    private String author;
    private String title;
    private String description;
    private String genre;
    private BookPhoto photo;

    public Book(){

    }


    public Book(Long bookID, String author, String title, String description, String genre) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public BookPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(BookPhoto photo) {
        this.photo = photo;
    }

    public void setBookID(Long id) {
        this.bookID = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getBookID() {
        return bookID;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
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

    @OneToMany(mappedBy = "book")
    private Collection<UserBook> userBooks;

    public void addUserBook(UserBook userBook){
        userBooks.add(userBook);
    }
}
