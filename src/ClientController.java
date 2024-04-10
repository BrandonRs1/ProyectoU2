import java.util.Scanner;

public class ClientController {
    Scanner leer = new Scanner(System.in);
    ProfileController profileController = new ProfileController();
    Auxiliar auxiliar = new Auxiliar();

    /**
     * This method is the main menu of clients
     *
     * @return the option that the user chosen
     */
    public String clientMenu(Administrator administrator) {
        String clientMenuOption;
        System.out.printf("%n >>>> Clients menu <<<<%n");
        Auxiliar.createMenu(administrator);
        /*System.out.printf("Select an option%n" +
                "1) Add a client%n" +
                "2) See clients%n" +
                "3) Edit client info%n" +
                "4) Delete client%n" +
                "Option: ");
         */
        System.out.print("Option: ");
        clientMenuOption = Auxiliar.ReadStringData(leer);
        for (Permission permission : administrator.getPermissions()) {
            if (clientMenuOption.equalsIgnoreCase(String.valueOf(permission))) {
                System.out.printf("Invalid option\n");
                clientMenuOption = "a"; 
            }
        }
        return clientMenuOption;
    }

    /**
     * Is the main switch of the clients
     *
     * @param clientOption is the option of the switch
     */
    public void clientSwitch(String clientOption) {
        switch (clientOption) {
            case "write" -> //Add
                    this.addClient();
            case "read" -> //See
                    showClientArrayList();
            case "edit" -> {//Edit
                this.editClientInfo();
                showClientArrayList();
            }
            case "delete" -> {//Delete
                this.deleteClient();
                showClientArrayList();
            }
        }
    }

    /**
     * Method to add new clients
     */
    private void addClient() {
        Profile profile;
        System.out.printf(" >>> Add a new client <<<%n");
        System.out.printf("Client info %n");
        profile = profileController.createProfile();
        System.out.print("Profile created\n");

        String userName = auxiliar.createUserName(profile);
        System.out.printf("Client user name %s", userName);

        System.out.print("Set password: ");
        String password = Auxiliar.ReadStringData(leer);

        Client client = new Client(profile, userName, password);
        ClientRepository.clients.add(client);

        System.out.print("Actual client list\n");
        showClientArrayList();
    }

    /**
     * This method is using to show the clients that are registered
     */
    public static void showClientArrayList() {
        if (ClientRepository.clients.isEmpty()) {
            System.out.printf("No registered clients%n");
        } else {
            System.out.print("\n\n---- Client ----");
            System.out.printf("-----------------------%n");
            System.out.printf("|%-15s|%-20s|%-15s|%-20s|%-20s|%n", "Client name", "Client last name", "Username", "Client birth", "Books");
            System.out.printf("-----------------------%n");
            for (Client clientsArray : ClientRepository.clients) {
                String clientBooks = getStringClientBooks(clientsArray);
                System.out.printf("|%-15s|%-20s|%-15s|%-20s|%-20s|%n", clientsArray.getProfile().getName(), clientsArray.getProfile().getLastName(), clientsArray.getUsername(), clientsArray.getProfile().getBirthDate().getStringBirthDate(), clientBooks);
                System.out.printf("-----------------------%n");
            }
        }
    }

    /**
     * This method is using to get the books that the client has
     *
     * @param clientsArray Is the array of clients
     * @return The books that the client has
     */
    private static String getStringClientBooks(Client clientsArray) {
        String books = "";
        if (clientsArray.getBorrowedBooks().isEmpty()) {
            books = "Not books borrowed";
        } else {
            for (Book clientBooks : clientsArray.getBorrowedBooks()) {
                books += clientBooks.getTitle() + "\n//////////////////////////////////////////////////////|";
            }
        }
        return books;
    }

    /**
     * Is using to edit the info of the client
     */
    private void editClientInfo() {
        if (ClientRepository.clients.isEmpty()) {
            System.out.print("There are not clients registered\n");
        } else {
            showClientArrayList();
            System.out.printf(" >>> Edit client info <<<%n");
            System.out.print("Client name: ");
            String nameEdit = Auxiliar.ReadStringData(leer);
            System.out.print("Client last name: ");
            String lastNameEdit = Auxiliar.ReadStringData(leer);
            int position = getClient(nameEdit, lastNameEdit);
            if (position != -1) {
                System.out.printf("What would you like to edit of %s%n", ClientRepository.clients.get(position).getProfile().getName());
                System.out.printf("1) Name%n" +
                        "2) Last name%n" +
                        "3) Birth date%n" +
                        "Option: ");
                int editOption = Auxiliar.ReadIntData(leer);
                if (editOption > 0 && editOption <= 3) {
                    profileController.editClientProfile(editOption, position);
                } else {
                    System.out.print("Invalid option\n");
                }
            } else {
                System.out.print("Author did not find\n");
            }
        }
    }

    /**
     * Is using to get a specific client of the array list
     *
     * @param name is the name of the client that we want to get
     * @return the position of the client in the array list
     */
    public static int getClient(String name, String lastName) {
        int ind = -1;
        for (int i = 0; i < ClientRepository.clients.size(); i++) {
            if (ClientRepository.clients.get(i).getProfile().getName().equalsIgnoreCase(name) && ClientRepository.clients.get(i).getProfile().getLastName().equalsIgnoreCase(lastName)) {
                ind = i;
            }
        }
        return ind;
    }

    /**
     * This method is using to delete clients
     */
    private void deleteClient() {
        if (!ClientRepository.clients.isEmpty()) {
            showClientArrayList();
            System.out.print("Name of client to eliminate: ");
            String nameDelete = Auxiliar.ReadStringData(leer);
            System.out.print("Last name of client to eliminate: ");
            String lastNameDelete = Auxiliar.ReadStringData(leer);
            int clientDelete = getClient(nameDelete, lastNameDelete);
            if (ClientRepository.clients.get(clientDelete).getBorrowedBooks().isEmpty()) {
                ClientRepository.clients.remove(clientDelete);
                System.out.print("Client eliminated\n");
            } else {
                System.out.print("Can not eliminate the client, it has books\n");
            }
        }
        System.out.print("There are not clients to eliminate\n");
    }

    /**
     * This is method is using to see the clients to borrow books
     */
    public static void clientsToBorrowBooks() {
        if (ClientRepository.clients.isEmpty()) {
            System.out.printf("No registered clients%n");
        } else {
            System.out.print("\n\n---- Authors ----");
            System.out.printf("-----------------------%n");
            System.out.printf("|%-15s|%-20s|%-20s|%-20s|%n", "Client name", "Client last name", "Client birth", "Books");
            System.out.printf("-----------------------%n");
            for (Client clientsArray : ClientRepository.clients) {
                if (clientsArray.getBorrowedBooks().size() < 3) {
                    String clientBooks = getStringClientBooks(clientsArray);
                    System.out.printf("|%-15s|%-20s|%-20s|%-20s|%n", clientsArray.getProfile().getName(), clientsArray.getProfile().getLastName(), clientsArray.getProfile().getBirthDate().getStringBirthDate(), clientBooks);
                    System.out.printf("-----------------------%n");
                }
            }
        }
    }
}
