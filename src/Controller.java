import java.util.Scanner;

public class Controller {
    Scanner leer = new Scanner(System.in);
    //Objetos
    AuthorController authorController = new AuthorController();
    BookController bookController = new BookController();
    ClientController clientController = new ClientController();

    ///////////////////////////////////////////////////////////////
    public int menuPrincipal() {
        int option;
        System.out.printf("----------------------------------------%n");
        System.out.printf("           Brandon´s library            %n");
        System.out.printf("----------------------------------------%n");
        System.out.printf(" --- Select an option ---%n" +
                "1) Books \uD83D\uDCD6%n" +
                "2) Authors \uD83E\uDDD1\u200D\uD83C\uDFEB\uD83D\uDC69\u200D\uD83C\uDFEB%n" +
                "3) Clients \uD83E\uDD13%n" +
                "4) Transactions \uD83D\uDCCB%n" +
                "5) Exit%n");
        System.out.printf(">>Select an option: ");
        option = leer.nextInt();
        return option;
    }

    public void switchPrincipal(int option) {
        switch (option) {//Book
            case 1 -> {
                System.out.println();
                int bookOption = bookController.bookMenu();
                bookController.switchBook(bookOption);
                System.out.printf("%n%n>>> Returning menu pincipal <<<%n%n");
            }
            case 2 -> {//Author
                System.out.println();
                int authorOption = authorController.authorMenu();
                authorController.switchAuthors(authorOption);
                System.out.printf("%n%n>>> Returning menu pincipal <<<%n%n");
            }
            case 3 -> {//Client
                System.out.println();
                int clientOption = clientController.clientMenu();
                clientController.switchClient(clientOption);
                System.out.printf("%n%n>>> Returning menu pincipal <<<%n%n");
            }
            case 4 -> {//Transaction
                System.out.println();
                System.out.printf("%n%n>>> Returning menu pincipal <<<%n%n");
            }
        }
    }
}