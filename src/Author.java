import java.util.ArrayList;

public class Author {
    private Profile profile;
    private ArrayList<Book> authorBooks = new ArrayList();

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setAuthorBooks(Book book) {
        authorBooks.add(book);
    }

    public ArrayList<Book> getAuthorBooks() {
        return authorBooks;
    }
}