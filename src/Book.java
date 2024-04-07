public class Book {

    private String title;
    private String author;
    private String ISBN;
    private Boolean isAvailable;

    public Book(String title, String author, String ISBN, Boolean isAvailable)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public Boolean getIsAvailable() { return isAvailable; }
}
