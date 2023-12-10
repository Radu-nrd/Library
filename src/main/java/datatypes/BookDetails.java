package datatypes;

import interfaces.IBook;

public class BookDetails  implements IBook {

    private String author;
    private String title;
    private String description;
    private String publisher;
    private int price;
    public BookDetails(String author, String title, String description, String publisher,int price) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getPublisher() {
        return this.publisher;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
