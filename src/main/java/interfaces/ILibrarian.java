package interfaces;
import datatypes.Request;
import entities.Book;

public interface ILibrarian {
    IRequest getRequest();
    void addBook(IBook book);
    void manageRequest(IRequest request);


}
