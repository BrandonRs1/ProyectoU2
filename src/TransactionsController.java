import java.util.Scanner;

public class TransactionsController {
    Scanner leer = new Scanner(System.in);
    static ClientRepository clientRepository = new ClientRepository();

    public int transactionController() {
        int transactionControllerOption;
        System.out.printf("Transaction: " +
                "1) Borrow a book%n" +
                "2) Return a book%n" +
                ">>Select an option: ");
        transactionControllerOption = leer.nextInt();
        return transactionControllerOption;
    }

    public void transactionSwitch(int option) {
        BookRepository bookRepository = new BookRepository();
        switch (option) {
            case 1 -> {
                System.out.printf("Borrow a book");
                System.out.printf("  ---- Books ----");
                System.out.printf("| %-15s | %-15s | %-10s | %6s |%n", "Title", "Author", "Isbn", "Avaible");
                for (Book books : bookRepository.getBooks()) {
                    if (books.getAvaible() == true) {
                        System.out.printf("| %-15s | %-15s | %-10s | %6s |%n", books.getTitle(), books.getAuthor().getProfile().getName(), books.getIsbn(), books.getAvaible());
                    }
                }
                System.out.printf("Choose book isbn: ");
                String chooseBook = leer.next();
                for (int i = 0; i < bookRepository.getBooks().size(); i++) {
                    if (bookRepository.getBooks().get(i).getIsbn().equalsIgnoreCase(chooseBook)) {
                        Book borrowedBook = bookRepository.getBooks().get(i);
                        clientRepository.getClients().get(i).setBorrowedBooks(borrowedBook);
                        borrowedBook.setAvaible(false);
                    }
                }
            }
            case 2 -> {
                System.out.printf("-- return book --");
                System.out.printf("Borrow a book");
                System.out.printf("  ---- Books ----");
                System.out.printf("| %-15s | %-15s | %-10s | %6s |%n", "Title", "Author", "Isbn", "Avaible");
                for (Book books : bookRepository.getBooks()) {
                    if (books.getAvaible() == false) {
                        System.out.printf("| %-15s | %-15s | %-10s | %6s |%n", books.getTitle(), books.getAuthor().getProfile().getName(), books.getIsbn(), books.getAvaible());
                    }
                }
                System.out.printf("Book to return isbn: ");
                String isbnReturn = leer.next();
                for (int i = 0; i < bookRepository.getBooks().size(); i++) {
                    if (bookRepository.getBooks().get(i).getIsbn().equalsIgnoreCase(isbnReturn)) {
                        Book returnBook = bookRepository.getBooks().get(i);
                        clientRepository.getClients().get(i).getBorrowedBooks().remove(i);
                        returnBook.setAvaible(true);
                    }
                }
            }
        }
    }
}
