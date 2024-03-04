import java.util.Scanner;

public class AuthorController {
    Scanner leer = new Scanner(System.in);
    static AuthorRepository authorRepository = new AuthorRepository();

    static boolean addBook;
    private String autBook;

    public int authorMenu() {
        int option;
        System.out.printf("---- Author menu ----%n");
        System.out.printf(" --- Select an option ---%n" +
                "1) Add new author%n" +
                "2) Delete author%n" +
                "3) Edit author info%n" +
                "4) Show authors%n" +
                "5) Menu principal%n" +
                ">> Select an option: ");
        option = leer.nextInt();
        return option;
    }

    public void switchAuthors(int option) {
        switch (option) {
            case 1 -> {//Add
                System.out.printf("%n---- Add author----%n");
                System.out.printf("Author name: ");
                String name = leer.next();
                System.out.printf("Author last name: ");
                String lastName = leer.next();
                System.out.printf("Author Birth day%n");
                System.out.printf("Day: ");
                String birthDaY = leer.next();
                System.out.printf("Month: ");
                String birthMonth = leer.next();
                System.out.printf("Year: ");
                String birthyear = leer.next();

                Date birthDate = new Date();
                birthDate.setBirthDay(birthDaY, birthMonth, birthyear);

                Profile profile = new Profile(name, lastName, birthDate);
                Author author = new Author();
                author.setProfile(profile);
                authorRepository.setAuthors(author);

            }
            case 2 -> {//Delete
                if (authorRepository.getAuthors().isEmpty()) {
                    System.out.printf("There are not authors to eliminate% n");
                } else {
                    for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                        Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                        if (authori.getAuthorBooks().isEmpty()) {
                            autBook = "No books registrated yet";

                        } else {
                            autBook = "";
                            Book auth = (Book) authori.getAuthorBooks().get(i);
                            for (Book authorBooks : authori.getAuthorBooks()) {
                                autBook += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }

                        System.out.printf("%n    ---- Authors ----%n");
                        System.out.printf("-----------------------------------------------%n");
                        System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                        System.out.printf("-----------------------------------------------%n");
                        for (int j = 0; j < authorRepository.getAuthors().size(); j++) {
                            Author authors;
                            authors = (Author) authorRepository.getAuthors().get(i);
                            System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                            System.out.printf("-----------------------------------------------%n");
                        }
                    }

                    System.out.printf("Autor to delete (name): ");
                    String nameToDelete = leer.next();
                    for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                        Author authors;
                        authors = (Author) authorRepository.getAuthors().get(i);
                        if (authors.getProfile().getName().equalsIgnoreCase(nameToDelete)) {
                            if (authors.getAuthorBooks().isEmpty()) {
                                if (authors.getAuthorBooks().isEmpty()) {
                                    authorRepository.getAuthors().remove(i);
                                    System.out.printf("Author eliminated succesfully%n");
                                }
                            } else {
                                System.out.printf("Can not eliminate author");
                            }
                        }
                    }

                    for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                        Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                        if (authori.getAuthorBooks().isEmpty()) {
                            autBook = "No books registrated yet";
                        } else {
                            autBook = "";
                            Book auth = (Book) authori.getAuthorBooks().get(i);
                            for (Book authorBooks : authori.getAuthorBooks()) {
                                autBook += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }

                        System.out.printf("%n    ---- Authors ----%n");
                        System.out.printf("-----------------------------------------------%n");
                        System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                        System.out.printf("-----------------------------------------------%n");
                        for (int j = 0; j < authorRepository.getAuthors().size(); j++) {
                            Author authors;
                            authors = (Author) authorRepository.getAuthors().get(i);
                            System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                            System.out.printf("-----------------------------------------------%n");
                        }
                    }
                }
            }
            case 3 -> {//Edit
                if (authorRepository.getAuthors().isEmpty()) {
                    System.out.printf("There are not authores to edit%n");
                } else {
                    System.out.printf("Which author want to edit");
                    for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                        Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                        if (authori.getAuthorBooks().isEmpty()) {
                            autBook = "No books registrated yet";
                        } else {
                            autBook = "";
                            Book auth = (Book) authori.getAuthorBooks().get(i);
                            for (Book authorBooks : authori.getAuthorBooks()) {
                                autBook += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }

                        System.out.printf("%n    ---- Authors ----%n");
                        System.out.printf("-----------------------------------------------%n");
                        System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                        System.out.printf("-----------------------------------------------%n");
                        for (int j = 0; j < authorRepository.getAuthors().size(); j++) {
                            Author authors;
                            authors = (Author) authorRepository.getAuthors().get(i);
                            System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                            System.out.printf("-----------------------------------------------%n");
                        }
                    }
                    System.out.printf("Author to edit (name): ");
                    String authorToEdit = leer.next();

                    System.out.printf("Select what to edit%n" +
                            "1) Name%n" +
                            "2) Last Name%n" +
                            "3) Birth date%n" +
                            "4) Books%n" +
                            ">>Select an option: ");
                    int editOption = leer.nextInt();
                    switch (editOption) {
                        case 1 -> {
                            for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                                Author authorEdit = (Author) authorRepository.getAuthors().get(i);
                                if (authorEdit.getProfile().getName().equalsIgnoreCase(authorToEdit)) {
                                    System.out.printf("Edit name of: %s" + authorEdit.getProfile().getName());
                                    System.out.printf("Name: ");
                                    String newName = leer.next();
                                    authorEdit.getProfile().setName(newName);
                                } else {
                                    System.out.printf("Author did not found%n");
                                }
                            }

                        }
                        case 2 -> {
                            for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                                Author authorEdit = (Author) authorRepository.getAuthors().get(i);
                                if (authorEdit.getProfile().getLastName().equalsIgnoreCase(authorToEdit)) {
                                    System.out.printf("Edit last name of: %s %s" + authorEdit.getProfile().getName(), authorEdit.getProfile().getLastName());
                                    System.out.printf("Last name: ");
                                    String newLastName = leer.next();
                                    authorEdit.getProfile().setLastName(newLastName);
                                } else {
                                    System.out.printf("Author did not found%n");
                                }
                            }
                        }
                        case 3 -> {
                            for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                                Author authorEdit = (Author) authorRepository.getAuthors().get(i);
                                if (authorEdit.getProfile().getName().equalsIgnoreCase(authorToEdit)) {
                                    System.out.printf("Author birth day: %s %n", authorEdit.getProfile().getBirthDate().birthDay());
                                    System.out.printf("New birth day%n");
                                    System.out.printf("Day: ");
                                    String newDay = leer.next();
                                    System.out.printf("Month: ");
                                    String newMonth = leer.next();
                                    System.out.printf("Year: ");
                                    String newYear = leer.next();
                                    authorEdit.getProfile().getBirthDate().setBirthDay(newDay, newMonth, newYear);
                                    System.out.printf("New author birth day: %s", authorEdit.getProfile().getBirthDate().birthDay());
                                }
                            }
                        }
                        case 4 -> {
                            System.out.printf("Sorry, we still working in this funtion \uD83D\uDE23%n" +
                                    "Try again latter, plis \uD83E\uDD7A");
                        }
                    }
                }
            }
            case 4 -> {//Show
                if (authorRepository.getAuthors().isEmpty()) {
                    System.out.printf("There are not authors to show %n");
                } else {
                    System.out.printf("%n    ---- Authors ----%n");
                    System.out.printf("-----------------------------------------------%n");
                    System.out.printf("| %-10s | %-15s | %-12s |%n", "Name", "Last name", "Books");
                    System.out.printf("-----------------------------------------------%n");
                    for (int i = 0; i < authorRepository.getAuthors().size(); i++) {
                        Author authori = (Author) AuthorController.authorRepository.getAuthors().get(i);

                        if (authori.getAuthorBooks().isEmpty()) {
                            autBook = "No books registrated yet";
                        } else {
                            autBook = "";
                            //Book auth = (Book) authori.getAuthorBooks().get(i);
                            for (Book authorBooks : authori.getAuthorBooks()) {
                                autBook += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }
                        Author authors;
                        authors = (Author) authorRepository.getAuthors().get(i);
                        System.out.printf("| %-10s | %-15s | %-12s |%n", authors.getProfile().getName(), authors.getProfile().getLastName(), autBook);
                        System.out.printf("-----------------------------------------------%n");
                    }
                }
            }//case 4
        }//Switch
    }//SwitchAutors //
}