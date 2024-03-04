import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public void setBooks(Book book) {
        this.books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}