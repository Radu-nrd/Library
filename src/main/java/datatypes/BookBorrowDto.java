package datatypes;

import java.util.Date;

public class BookBorrowDto {
    private Long id;
    private Long bookId;
    private Long borrowId;
    private String bookTitle;
    private String bookAuthor;
    private String borrowDate;
    private String returnDate;

    public BookBorrowDto(Long id,Long bookId, Long borrowId, String bookTitle, String bookAuthor, String borrowDate, String returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.borrowId = borrowId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Long getId() {
        return id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
}
