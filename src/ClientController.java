import java.util.ArrayList;
import java.util.Scanner;

public class ClientController {
    Scanner leer = new Scanner(System.in);

    static ClientRepository clientRepository = new ClientRepository();

    public int clientMenu() {

        int clientMenuOption;

        System.out.printf("---- Client menu ----%n");
        System.out.printf(" --- Select an option ---%n" +
                "1) Add new client%n" +
                "2) Delete client%n" +
                "3) Edit client%n" +
                "4) Show client%n" +
                "5) Menu principal%n" +
                ">> Select an option: ");
        clientMenuOption = leer.nextInt();
        return clientMenuOption;
    }

    public void switchClient(int option) {
        switch (option) {
            case 1 -> {
                System.out.printf("%n---- Add client----%n");
                System.out.printf("Client name: ");
                String name = leer.next();
                System.out.printf("Client last name: ");
                String lastName = leer.next();
                System.out.printf("Client Birth day%n");
                System.out.printf("Day: ");
                String birthDaY = leer.next();
                System.out.printf("Month: ");
                String birthMonth = leer.next();
                System.out.printf("Year: ");
                String birthyear = leer.next();

                Date birthDate = new Date();
                birthDate.setBirthDay(birthDaY, birthMonth, birthyear);

                Profile profile = new Profile(name, lastName, birthDate);
                Client client = new Client();
                client.setProfile(profile);
                client.setBirthDate(birthDate);
                clientRepository.setClients(client);
            }
            case 2 -> {
                System.out.printf("Sorry, we still working in this funtion \uD83D\uDE23%n" +
                        "Try again latter, plis \uD83E\uDD7A");
            }
            case 3 -> {
                if (clientRepository.getClients().isEmpty()) {
                    System.out.printf("There are not clients to edit");
                } else {
                    System.out.printf("    ---- Clients ----%n");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", "Client name", "Client last name", "Client birth", "Client books");
                    for (int i = 0; i < clientRepository.getClients().size(); i++) {
                        String clientBooks;
                        if (clientRepository.getClients().get(i).getBorrowedBooks().isEmpty()) {
                            clientBooks = "No books borrowed yet";
                        } else {
                            clientBooks = "";
                            ;
                            for (Book authorBooks : clientRepository.getClients().get(i).getBorrowedBooks()) {
                                clientBooks += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }
                        System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", clientRepository.getClients().get(i).getProfile().getName(), clientRepository.getClients().get(i).getProfile().getLastName(), clientRepository.getClients().get(i).getBirthDate().birthDay(), clientBooks);
                    }
                    System.out.printf("Client to edit (name): ");
                    String clientEdit = leer.next();

                    System.out.printf("Select what to edit%n" +
                            "1) Name%n" +
                            "2) Last Name%n" +
                            "3) Birth date%n" +
                            "4) Books%n" +
                            ">>Select an option: ");
                    int editOption = leer.nextInt();
                    switch (editOption) {
                        case 1 -> {
                            for (int i = 0; i < clientRepository.getClients().size(); i++) {
                                if (clientRepository.getClients().get(i).getProfile().getName().equalsIgnoreCase(clientEdit)) {
                                    System.out.printf("Edit name of %s %n", clientRepository.getClients().get(i).getProfile().getName());
                                    System.out.printf("Name: ");
                                    String newName = leer.next();
                                    clientRepository.getClients().get(i).getProfile().setName(newName);
                                } else {
                                    System.out.printf("Client did not found%n");
                                }
                            }
                        }
                        case 2 -> {
                            for (int i = 0; i < clientRepository.getClients().size(); i++) {
                                if (clientRepository.getClients().get(i).getProfile().getName().equalsIgnoreCase(clientEdit)) {
                                    System.out.printf("Edit last name of %s %s %n", clientRepository.getClients().get(i).getProfile().getName(), clientRepository.getClients().get(i).getProfile().getLastName());
                                    System.out.printf("Last name: ");
                                    String newLastName = leer.next();
                                    clientRepository.getClients().get(i).getProfile().setName(newLastName);
                                } else {
                                    System.out.printf("Client did not found%n");
                                }
                            }
                        }
                        case 3 -> {
                            for (int i = 0; i < clientRepository.getClients().size(); i++) {
                                if (clientRepository.getClients().get(i).getProfile().getName().equalsIgnoreCase(clientEdit)) {
                                    System.out.printf("Edit birth date of %s %n", clientRepository.getClients().get(i).getProfile().getName());
                                    System.out.printf("Birth date %s %n", clientRepository.getClients().get(i).getBirthDate().birthDay());
                                    System.out.printf("New birth date %n");
                                    System.out.printf("Day: ");
                                    String newDay = leer.next();
                                    System.out.printf("Month: ");
                                    String newMonth = leer.next();
                                    System.out.printf("Year: ");
                                    String newYear = leer.next();

                                    clientRepository.getClients().get(i).getBirthDate().setBirthDay(newDay, newMonth, newYear);
                                    System.out.printf("New birthday of %s: %s", clientRepository.getClients().get(i).getProfile().getName(), clientRepository.getClients().get(i).getBirthDate().birthDay());
                                } else {
                                    System.out.printf("Client did not found%n");
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
            case 4 -> {
                String clientBooks;
                if (clientRepository.getClients().isEmpty()) {
                    System.out.printf("There are not clients%n");
                } else {
                    System.out.printf("    ---- Clients ----%n");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", "Client name", "Client last name", "Client birth", "Client books");
                    for (int i = 0; i < clientRepository.getClients().size(); i++) {

                        if (clientRepository.getClients().get(i).getBorrowedBooks().isEmpty()) {
                            clientBooks = "No books borrowed yet";
                        } else {
                            clientBooks = "";
                            ;
                            for (Book authorBooks : clientRepository.getClients().get(i).getBorrowedBooks()) {
                                clientBooks += authorBooks.getTitle() + "\n///////////////////////////////";
                            }
                        }
                        System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", clientRepository.getClients().get(i).getProfile().getName(), clientRepository.getClients().get(i).getProfile().getLastName(), clientRepository.getClients().get(i).getBirthDate().birthDay(), clientBooks);
                    }
                }
            }
        }
    }
}