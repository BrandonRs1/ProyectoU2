import java.util.ArrayList;

public class AuthorRepository {
    private ArrayList<Author> authors = new ArrayList<>();

    public void setAuthors(Author author) {
        authors.add(author);
    }

    public ArrayList getAuthors() {
        return authors;
    }
}