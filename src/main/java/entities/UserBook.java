package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserBook {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    @Temporal(TemporalType.DATE)
    private Date borrowedDate;

    private String status;

    public UserBook(){}

    public UserBook(User user, Book book, Date borrowedDate,String status) {
        this.user = user;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
