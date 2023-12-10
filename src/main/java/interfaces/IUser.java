package interfaces;

public interface IUser {
    IBook getRequestedBook();
    void returnBook(IBook book);
    int getStatusOfBook(IBook book);

}
