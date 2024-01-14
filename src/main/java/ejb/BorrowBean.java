package ejb;

import datatypes.BookBorrowDto;
import datatypes.BookDto;
import entities.Book;
import entities.User;
import entities.UserBook;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class BorrowBean {

    @PersistenceContext
    EntityManager entityManager;
    public void SetEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void borrowBook(User user, Book book){
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setBorrowedDate(LocalDate.now().toString());
        userBook.setStatus("borrowed");
        entityManager.persist(userBook);
    }

    public void returnBook(Long borrowId){
        try {
            UserBook entry = entityManager.find(UserBook.class,borrowId);
            entry.setStatus("returned");
            entry.setReturnDate(LocalDate.now().toString());
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<BookBorrowDto> findAllBooks(){
        try {
            TypedQuery<UserBook> typedQuery = entityManager.createQuery("SELECT b FROM UserBook b",UserBook.class);
            List<UserBook> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
    public List<BookBorrowDto> findAllBooksByStatusFromUser(String username,String status){
        try {
            TypedQuery<UserBook> typedQuery = entityManager.createQuery("SELECT b FROM UserBook b WHERE b.user.userName=:username AND b.status=:status",UserBook.class)
                    .setParameter("username",username)
                    .setParameter("status",status);
            List<UserBook> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
    private List<BookBorrowDto> copyBooksToDto(List<UserBook> books){
        List<BookBorrowDto> list = new ArrayList<>();
        for(UserBook book : books)
            list.add(new BookBorrowDto(book.getId(),book.getBook().getBookID(),book.getUser().getUserID(),book.getBook().getTitle(),book.getBook().getAuthor(),book.getBorrowedDate(),book.getReturnDate()));
        return list;
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
