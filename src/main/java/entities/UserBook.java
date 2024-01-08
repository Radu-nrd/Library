package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserBook {
    @Id
    private Long id;
    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
    @Temporal(TemporalType.DATE)
    private Date borrowedDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    public UserBook(){}

    public UserBook(User user, Book book, Date borrowedDate) {
        this.user = user;
        this.book = book;
        this.borrowedDate = borrowedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
