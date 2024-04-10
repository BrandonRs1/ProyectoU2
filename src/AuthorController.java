import java.util.Scanner;

public class AuthorController {
    Scanner leer = new Scanner(System.in);
    ProfileController profileController = new ProfileController();

    /**
     * Main menu of authors
     *
     * @return the option that the user chosen
     */
    public String AuthorMenu(Administrator administrator) {
        String authorMenuOption;
        System.out.printf("%n >>>> Authors menu <<<<%n");
        Auxiliar.createMenu(administrator);
        /*System.out.printf("Select an option%n" +
                "1) Add an author%n" +
                "2) See authors%n" +
                "3) Edit author info%n" +
                "4) Delete author%n" +
                "Option: ");

         */
        System.out.print("Option: ");
        authorMenuOption = Auxiliar.ReadStringData(leer);
        for (Permission permis : administrator.getPermissions()) {
            if (!authorMenuOption.equalsIgnoreCase(String.valueOf(permis))) {
                System.out.print("Invalid option\n");
                authorMenuOption = "a";
            }
        }
        return authorMenuOption;
    }

    /**
     * Is the switch of the main menu of authors
     *
     * @param authorOption is the option that was chosen by the user
     */
    public void authorSwitch(String authorOption) {
        switch (authorOption) {
            case "write" -> //Add
                    this.addAuthor();
            case "read" -> //See
                    showAuthorArrayList();
            case "edit" -> {//Edit
                this.editAuthorInfo();
                showAuthorArrayList();
            }
            case "deete" -> {//Delete
                this.deleteAuthor();
                showAuthorArrayList();
            }
        }
    }

    /**
     * Add a new author to the arrayLis
     */
    private void addAuthor() {
        Profile profile;
        System.out.printf(" >>> Add a new author <<<%n");
        System.out.printf("Author info %n");
        profile = profileController.createProfile();
        System.out.print("Profile created\n");
        Author author = new Author();
        author.setProfile(profile);
        AuthorRepository.authors.add(author); //Add author
        System.out.print("Actual authors list\n");
        showAuthorArrayList();
    }

    /**
     * Method using to edit the info of an author
     */
    private void editAuthorInfo() {
        if (AuthorRepository.authors.isEmpty()) {
            System.out.print("There are not author registered\n");
        } else {
            showAuthorArrayList();
            System.out.printf(" >>> Edit author info <<<%n");
            System.out.print("Author name: ");
            String nameEdit = Auxiliar.ReadStringData(leer);
            System.out.print("Author last name: ");
            String lastNameEdit = Auxiliar.ReadStringData(leer);
            int position = getAuthor(nameEdit, lastNameEdit);
            if (position != -1) {
                System.out.printf("What would you like to edit of %s%n", AuthorRepository.authors.get(position).getProfile().getName());
                System.out.printf("1) Name%n" +
                        "2) Last name%n" +
                        "3) Birth date%n" +
                        "4) Books%n%n" +
                        "Option: ");
                int editOption = Auxiliar.ReadIntData(leer);
                if (editOption == 4) {
                    this.editBooks(position);
                } else if (editOption > 0 && editOption <= 3) {
                    profileController.editAuthorProfile(editOption, position);
                } else {
                    System.out.print("Invalid option\n");
                }
            } else {
                System.out.print("Author did not find\n");
            }
        }
    }

    /**
     * Method using to show the authors and the books that they have
     */
    public static void showAuthorArrayList() {
        if (AuthorRepository.authors.isEmpty()) {
            System.out.printf("No registered authors%n");
        } else {
            System.out.print("\n\n---- Authors ----");
            System.out.printf("-----------------------%n");
            System.out.printf("|%-15s|%-20s|%-20s|%-20s|%n", "Author name", "Author last name", "Author birth", "Books");
            System.out.printf("-----------------------%n");
            for (Author authorArray : AuthorRepository.authors) {
                String authorBooks = getStringAuthorBooks(authorArray);
                System.out.printf("|%-15s|%-20s|%-20s|%-20s|%n", authorArray.getProfile().getName(), authorArray.getProfile().getLastName(), authorArray.getProfile().getBirthDate().getStringBirthDate(), authorBooks);
                System.out.printf("-----------------------%n");
            }
        }
    }

    /**
     * Method using to eliminate an author
     * We can´t eliminate an author if it has books
     */
    private void deleteAuthor() {
        if (!AuthorRepository.authors.isEmpty()) {
            showAuthorArrayList();
            System.out.print("Name of author to eliminate: ");
            String nameDelete = Auxiliar.ReadStringData(leer);
            System.out.print("Last name of author to eliminate: ");
            String lastNameDelete = Auxiliar.ReadStringData(leer);
            int authorDelete = getAuthor(nameDelete, lastNameDelete);
            if (AuthorRepository.authors.get(authorDelete).getBooks().isEmpty()) {
                AuthorRepository.authors.remove(authorDelete);
                System.out.print("Author eliminated\n");
            } else {
                System.out.print("Can not eliminate the author, it has books\n");
            }
        }
    }

    /**
     * Get the books of an author this is using when we show the author array list
     *
     * @param authorArray is the array list of the authors
     * @return the array list with the author name and the books that it has
     */
    private static String getStringAuthorBooks(Author authorArray) {
        String books = "";
        if (authorArray.getBooks().isEmpty()) {
            books = "Not books registered";
        } else {
            for (Book authorBooks : authorArray.getBooks()) {
                books += authorBooks.getTitle() + "\n/////////////////////////////////////////////////////";
            }
        }
        return books;
    }

    /**
     * Method using to find an author in the array list using its name
     *
     * @param name is the name of the author
     * @return the position of the author in the array list
     */
    public static int getAuthor(String name, String lastName) {
        int ind = -1;
        for (int i = 0; i < AuthorRepository.authors.size(); i++) {
            if (AuthorRepository.authors.get(i).getProfile().getName().equalsIgnoreCase(name) && AuthorRepository.authors.get(i).getProfile().getLastName().equalsIgnoreCase(lastName)) {
                ind = i;
            }
        }
        return ind;
    }

    /**
     * Method using or edit books
     *
     * @param authorPosition is the position of the author in the array list
     */
    private void editBooks(int authorPosition) {
        boolean delete = false;
        if (AuthorRepository.authors.get(authorPosition).getBooks().isEmpty()) {
            System.out.print("The author does not have books\n");
        } else {
            showAuthorArrayList();
            System.out.printf("Delete a book: \n" +
                    "1) Si%n" +
                    "2) No%n" +
                    "Option: ");
            int option = Auxiliar.ReadIntData(leer);
            if (option == 1) {
                System.out.print("---- Author books ----");
                System.out.printf("---------------------------------%n");
                for (Book authorBooks : AuthorRepository.authors.get(authorPosition).getBooks()) {
                    System.out.printf("|%-15s|%-15s|%n", "Title", "ISBN");
                    System.out.printf("|%-15s|%-15s|%n", authorBooks.getTitle(), authorBooks.getIsbn());
                    System.out.print("---------------------------------\n");
                }
                System.out.print("Book ISBN: ");
                String bookIsbn = Auxiliar.ReadStringData(leer);
                if (BookController.getBook(bookIsbn) != -1) {
                    for (int i = 0; i <= AuthorRepository.authors.get(authorPosition).getBooks().size(); i++) {
                        if (AuthorRepository.authors.get(authorPosition).getBooks().get(i).getIsbn().equalsIgnoreCase(bookIsbn)) {
                            if (AuthorRepository.authors.get(authorPosition).getBooks().get(i).isAvaible()) {
                                AuthorRepository.authors.get(authorPosition).getBooks().remove(i);
                                delete = true;
                            }
                        }
                    }
                    if (delete) {
                        BookRepository.books.remove(BookController.getBook(bookIsbn));
                        System.out.print("Book deleted\n");
                    } else {
                        System.out.print("Book were borrow, can not eliminate\n");
                    }
                } else {
                    System.out.print("Book did not found\n");
                }
            }
        }
    }
}