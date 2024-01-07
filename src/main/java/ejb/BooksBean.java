package ejb;

import datatypes.BookDto;
import datatypes.BookPhotoDto;
import entities.Book;
import entities.BookPhoto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class BooksBean {
    @PersistenceContext
    EntityManager entityManager;
    public void SetEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public List<BookDto> findAllBooks(){
        try {
            TypedQuery<Book> typedQuerry = entityManager.createQuery("SELECT b FROM Book b",Book.class);
            List<Book> books = typedQuerry.getResultList();
            return copyBooksToDto(books);
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<BookDto> copyBooksToDto(List<Book> books){
        List<BookDto> list = new ArrayList<>();
        for(Book book : books){
            BookDto temp = new BookDto(book.getBookID(),book.getAuthor(),book.getTitle(),book.getDescription(), book.getGenre());
            list.add(temp);
        }
        return list;

    }

    public void createBook(String author,String title,String description,String genre){

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setDescription(description);
        book.setGenre(genre);

        entityManager.persist(book);
    }

    public void updateBook(Long bookId,String author,String title,String description,String genre){

        Book book = entityManager.find(Book.class, bookId);
        book.setAuthor(author);
        book.setTitle(title);
        book.setDescription(description);
        book.setGenre(genre);

    }

    public BookDto findById(Long bookId){

        Book book = entityManager.find(Book.class, bookId);
        return new BookDto(book.getBookID(),book.getAuthor(), book.getTitle(),book.getDescription(),book.getGenre());
    }

    public void deleteBooksByIds(Collection<Long> bookIds){
        for(Long bookId:bookIds){
            Book book = entityManager.find(Book.class,bookId);
            entityManager.remove(book);
        }
    }

    public void addPhotoToBook(Long bookId,String filename,String fileType,byte[] fileContent){
        BookPhoto bookPhoto = new BookPhoto();
        bookPhoto.setFilename(filename);
        bookPhoto.setFileType(fileType);
        bookPhoto.setFileContent(fileContent);

        Book book = entityManager.find(Book.class,bookId);
        if(book.getPhoto()!= null)
            entityManager.remove(book.getPhoto());
        book.setPhoto(bookPhoto);
        entityManager.persist(bookPhoto);

    }

    public Long getBookId(String author,String title,String description,String genre){
        Book book = (Book) entityManager
                .createQuery("SELECT i FROM Book i WHERE i.title = :title and i.author = :author and i.description = :description and i.genre = :genre")
                .setParameter("title",title).setParameter("author",author).setParameter("description", description).setParameter("genre", genre)
                .getSingleResult();
        return book.getBookID();
    }
    public BookPhotoDto findPhotoByBookId(Integer bookId) {
        List<BookPhoto> photos = entityManager
                .createQuery("SELECT p FROM BookPhoto  p where p.book.bookID = :id", BookPhoto.class)
                .setParameter("id", bookId)
                .getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        BookPhoto photo = photos.get(0); // the first element
        return new BookPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(),
                photo.getFileContent());
    }

}
