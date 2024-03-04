public class Book {
    private String title;
    private String isbn;
    private Author author;
    private Boolean isAvaible;
    private Date publishDate;

    public Book(String title, String isbn, boolean isAvaible) {
        this.title = title;
        this.isbn = isbn;
        this.isAvaible = isAvaible;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public Boolean getAvaible() {
        return isAvaible;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAvaible(Boolean avaible) {
        isAvaible = avaible;
    }
}