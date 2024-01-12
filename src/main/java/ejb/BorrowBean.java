package ejb;

import entities.Book;
import entities.User;
import entities.UserBook;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;

@Stateless
public class BorrowBean {

    @PersistenceContext
    EntityManager entityManager;
    public void SetEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void borrowBook(User user, Book book, Date date){
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setBorrowedDate(date);
        userBook.setStatus("borrowed");
        user.addUserBook(userBook);
        book.addUserBook(userBook);
        entityManager.persist(userBook);
    }

    public Date getBorrowedDate(){
        long millis=System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        return date;
    }

    public Book findBookById(Long bookId){
        Book book = entityManager.find(Book.class, bookId);
        return book;
    }

    public User findUserByUsername(String username){
        User user = (User) entityManager
                .createQuery("SELECT u from User u where u.userName = :username")
                .setParameter("username",username)
                .getSingleResult();
        return user;
    }


}
