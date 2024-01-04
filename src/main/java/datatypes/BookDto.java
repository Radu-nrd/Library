package datatypes;

public class BookDto {

    private String author;
    private String title;
    private String description;
    private String genre;
    private Long bookId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public BookDto(Long bookId,String author, String title, String description, String genre) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.bookId=bookId;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
