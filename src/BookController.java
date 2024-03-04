import java.util.Scanner;

public class BookController {
    Scanner leer = new Scanner(System.in);
    private BookRepository bookRepository = new BookRepository();

    public int bookMenu() {
        int option;
        System.out.printf("---- Author menu ----%n");
        System.out.printf(" --- Select an option ---%n" +
                "1) Add new book%n" +
                "2) Delete book%n" +
                "3) Edit book info%n" +
                "4) Show ll books%n" +
                "5) Menu principal%n" +
                ">> Select an option: ");
        option = leer.nextInt();
        leer.nextLine();
        return option;
    }

    public void switchBook(int option) {
        String autBook = "";
        switch (option) {
            case 1 -> {//Create
                boolean isbnMark = true;
                String isbn;

                if (AuthorController.authorRepository.getAuthors().isEmpty()) {
                    System.out.printf("%n ---- There are not authores ----");
                } else {
                    System.out.printf("---- Add book ----%n");
                    System.out.printf("Book tittle: ");
                    String title = this.readString(leer);

                    do {
                        System.out.printf("Book isbn: ");
                        isbn = this.readString(leer);
                        for (Book bookIsbn : bookRepository.getBooks()) {
                            if (bookIsbn.getIsbn().equalsIgnoreCase(isbn)) {
                                System.out.printf("Isbn already registrated%n");
                                isbnMark = false;
                            } else {
                                isbnMark = true;
                            }
                        }
                    } while (isbnMark == false);
                    System.out.printf("Book publish year %n");
                    System.out.printf("Day: ");
                    String day = leer.next();
                    System.out.printf("Month: ");
                    String month = leer.next();
                    System.out.printf("Year: ");
                    String year = leer.next();

                    Book book = new Book(title, isbn, true);
                    Date publishDate = new Date();
                    publishDate.publishYear(day, month, year);
                    book.setPublishDate(publishDate);
                    bookRepository.setBooks(book);
                    System.out.printf("Choose the author of the book: %n");

                    System.out.printf("%n    ---- Authors ----%n");
                    System.out.printf("-----------------------------------------------%n");
                    System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                    System.out.printf("-----------------------------------------------%n");

                    for (int i = 0; i < AuthorController.authorRepository.getAuthors().size(); i++) {
                        Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                        if (authori.getAuthorBooks().isEmpty()) {
                            autBook = "No books registrated yet";
                        } else {
                            autBook = "";
                            for (Book authorBooks : authori.getAuthorBooks()) {
                                autBook += authorBooks.getTitle() + "\n//////////////////////////////|";
                            }
                        }

                        Author authors;
                        authors = (Author) AuthorController.authorRepository.getAuthors().get(i);
                        System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                        System.out.printf("-----------------------------------------------%n");

                    }

                    System.out.printf("Author name: ");
                    String author = leer.next();


                    boolean found = false;
                    for (int i = 0; i < AuthorController.authorRepository.getAuthors().size(); i++) {
                        Author authorChoose;
                        authorChoose = (Author) AuthorController.authorRepository.getAuthors().get(i);
                        if (authorChoose.getProfile().getName().equalsIgnoreCase(author)) {
                            Author author1 = (Author) AuthorController.authorRepository.getAuthors().get(i);
                            author1.setAuthorBooks(book);
                            book.setAuthor(author1);
                            found = true;
                        }
                    }

                    if (found == false) {
                        System.out.printf("%nAuthor did not found%n");
                        System.out.printf("%nBook did not save%n");
                    } else {
                        System.out.printf("%n    ---- Authors ----%n");
                        System.out.printf("-----------------------------------------------%n");
                        System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                        System.out.printf("-----------------------------------------------%n");

                        for (int i = 0; i < AuthorController.authorRepository.getAuthors().size(); i++) {
                            Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                            if (authori.getAuthorBooks().isEmpty()) {
                                autBook = "No books registrated yet";

                            } else {
                                autBook = "";
                                for (Book authorBooks : authori.getAuthorBooks()) {
                                    autBook += authorBooks.getTitle() + "\n//////////////////////////////|";
                                }
                            }
                            Author authors;
                            authors = (Author) AuthorController.authorRepository.getAuthors().get(i);
                            System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                            System.out.printf("-----------------------------------------------%n");

                        }
                    }
                }//there´s authores
            }
            case 2 -> {//Delete
                if (bookRepository.getBooks().isEmpty()) {
                    System.out.printf("There are not books to edit");
                } else {
                    System.out.printf("    ---- Books ----%n");
                    System.out.printf("-----------------------------------------------%n");
                    System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", "Book", "ISBN", "Author", "Avaible");
                    System.out.printf("-----------------------------------------------%n");
                    for (Book books : bookRepository.getBooks()) {
                        System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", books.getTitle(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                        System.out.printf("-----------------------------------------------%n");

                    }
                    System.out.printf("Book to eliminate (isbn): ");
                    String bookEliminateIsbn = leer.next();
                    for (int bookEliminate = 0; bookEliminate < bookRepository.getBooks().size(); bookEliminate++) {
                        Book bookEliminatea = bookRepository.getBooks().get(bookEliminate);
                        if (bookEliminatea.getIsbn().equalsIgnoreCase(bookEliminateIsbn)) {
                            boolean elim = bookEliminatea.getAvaible();
                            if (elim == false) {
                                System.out.printf("Could not eliminate this book it is not avaible%n");
                            } else {
                                bookRepository.getBooks().remove(bookEliminate);
                                System.out.printf("Book eliminated");
                            }
                        } else {
                            System.out.printf("Book did not found%n");
                        }
                    }
                }
            }
            case 3 -> {//Edit
                if (bookRepository.getBooks().isEmpty()) {
                    System.out.printf("There are not books to edit%n");
                } else {
                    System.out.printf("    ---- Books ----%n");
                    System.out.printf("-----------------------------------------------%n");
                    System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", "Book", "ISBN", "Author", "Avaible");
                    System.out.printf("-----------------------------------------------%n");
                    for (Book books : bookRepository.getBooks()) {
                        System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", books.getTitle(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                        System.out.printf("-----------------------------------------------%n");
                    }

                    System.out.printf("Intoduce isbn of the book to edite: ");
                    String editBook = leer.next();

                    for (Book bookEdit : bookRepository.getBooks()) {
                        if (bookEdit.getIsbn().equalsIgnoreCase(editBook)) {
                            System.out.printf("  ---- Edit ----%n" +
                                    "1) Title%n" +
                                    "2) Isbn%n" +
                                    "3) Author%n" +
                                    "4) Publish date%n" +
                                    ">> Select an option: ");
                            int optionEdit = leer.nextInt();
                            leer.nextLine();
                            switch (optionEdit) {
                                case 1 -> {
                                    System.out.printf("New title: ");
                                    String newTitle = leer.nextLine();
                                    System.out.printf("Old title %s %n", bookEdit.getTitle());
                                    bookEdit.setTitle(newTitle);
                                    System.out.printf("New book info: %n");
                                    System.out.printf("-----------------------------------------------%n");
                                    System.out.printf("|| %-15s | %-15s |%-10s | %-15s | %-6s |%n", bookEdit.getTitle(), bookEdit.getPublishDate().getPublishDateS(), bookEdit.getIsbn(), bookEdit.getAuthor().getProfile().getName(), bookEdit.getAvaible());
                                    System.out.printf("-----------------------------------------------%n");
                                }
                                case 2 -> {
                                    System.out.printf("New isbn: ");
                                    String newIsbn = leer.nextLine();
                                    System.out.printf("Old isbn %s %n", bookEdit.getTitle());
                                    bookEdit.setIsbn(newIsbn);
                                    System.out.printf("New book info: %n");
                                    System.out.printf("-----------------------------------------------%n");
                                    System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", bookEdit.getTitle(), bookEdit.getPublishDate().getPublishDateS(), bookEdit.getIsbn(), bookEdit.getAuthor().getProfile().getName(), bookEdit.getAvaible());
                                    System.out.printf("-----------------------------------------------%n");
                                }
                                case 3 -> {
                                    System.out.printf("Sorry, we still working in this funtion \uD83D\uDE23%n" +
                                            "Try again latter, plis \uD83E\uDD7A");
                                }
                                case 4 -> {
                                    System.out.printf("    ---- Books ----%n");
                                    System.out.printf("-----------------------------------------------%n");
                                    System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", "Book", "ISBN", "Author", "Avaible");
                                    System.out.printf("-----------------------------------------------%n");
                                    for (Book books : bookRepository.getBooks()) {
                                        System.out.printf("| %-15s | %-10s | %-15s | %-6s |%n", books.getTitle(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                                        System.out.printf("-----------------------------------------------%n");
                                    }

                                    //Book editDate = bookRepository.getBooks().get(bookEdit);
                                    System.out.printf("Old publish date %s %n", bookEdit.getPublishDate().getPublishDateS());
                                    System.out.printf("Inroduce new publish date%n");
                                    System.out.printf("Day: ");
                                    String newDay = leer.next();
                                    System.out.printf("Month: ");
                                    String newMonth = leer.next();
                                    System.out.printf("Year: ");
                                    String newYear = leer.next();
                                    bookEdit.getPublishDate().publishYear(newDay, newMonth, newYear);
                                    System.out.printf("  ---- New book data ----");
                                    System.out.printf("-----------------------------------------------%n");
                                    System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", bookEdit.getTitle(), bookEdit.getPublishDate().getPublishDateS(), bookEdit.getIsbn(), bookEdit.getAuthor().getProfile().getName(), bookEdit.getAvaible());
                                    System.out.printf("-----------------------------------------------%n");
                                }
                            }
                        } else {
                            System.out.printf("Isbn does not exist %n");
                        }
                    }
                }
            }
            case 4 -> {//Show
                if (bookRepository.getBooks().isEmpty()) {
                    System.out.printf("There are not books to show%n");
                } else {
                    System.out.printf("Books too show: %n" +
                            "1) All%n" +
                            "2) Not avaible books%n" +
                            "3) Avaible Books%n" +
                            ">> Select an option: ");
                    int optionToShow = leer.nextInt();
                    switch (optionToShow) {
                        case 1 -> {
                            System.out.printf("    ---- Books ----%n");
                            System.out.printf("-----------------------------------------------%n");
                            System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", "Book", "Publish date", "ISBN", "Author", "Avaible");
                            System.out.printf("-----------------------------------------------%n");
                            for (Book books : bookRepository.getBooks()) {
                                System.out.printf("|| %-15s | %-15s |%-10s | %-15s | %-6s |%n", books.getTitle(), books.getPublishDate().getPublishDateS(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                                System.out.printf("-----------------------------------------------%n");
                            }
                        }
                        case 2 -> {
                            System.out.printf("    ---- Avaible books ----%n");
                            System.out.printf("-----------------------------------------------%n");
                            System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", "Book", "Publish date", "ISBN", "Author", "Avaible");
                            System.out.printf("-----------------------------------------------%n");
                            for (Book books : bookRepository.getBooks()) {
                                if (books.getAvaible() == true) {
                                    System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", books.getTitle(), books.getPublishDate().getPublishDateS(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                                    System.out.printf("-----------------------------------------------%n");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.printf("    ---- Not vaible books ----%n");
                            System.out.printf("-----------------------------------------------%n");
                            System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", "Book", "Publish date", "ISBN", "Author", "Avaible");
                            System.out.printf("-----------------------------------------------%n");
                            for (Book books : bookRepository.getBooks()) {
                                if (books.getAvaible() == false) {
                                    System.out.printf("| %-15s | %-15s |%-10s | %-15s | %-6s |%n", books.getTitle(), books.getPublishDate().getPublishDateS(), books.getIsbn(), books.getAuthor().getProfile().getName(), books.getAvaible());
                                    System.out.printf("-----------------------------------------------%n");
                                }
                            }
                        }
                    }
                }

            }//case 4
        }
    }

    public String readString(Scanner leer) {
        String dato = leer.nextLine();
        return dato;
    }
}