import java.util.Scanner;
import java.util.function.DoubleFunction;

public class ProfileController {
    Scanner scanner = new Scanner(System.in);

    /**
     * Create profiles
     *
     * @return Profile is the profile with name, last name and birth date
     */
    public Profile createProfile() {
        System.out.print("Name: ");
        String name = Auxiliar.ReadStringData(scanner);
        System.out.print("Last name: ");
        String lastName = Auxiliar.ReadStringData(scanner);
        System.out.printf("Author birthdate %n");
        Date date = new Date();
        String birthDate = date.birthDate();
        date.setBirthDate(birthDate);
        Profile profile = new Profile(name, lastName, date);
        return profile;
    }

    /**
     * This method is using to edit the info of an author
     *
     * @param option   is the option of what to edit
     * @param position is the position of the author in the array list
     */
    public void editAuthorProfile(int option, int position) {
        switch (option) {
            case 1 -> {
                System.out.print("New name: ");
                String newName = Auxiliar.ReadStringData(scanner);
                AuthorRepository.authors.get(position).getProfile().setName(newName);
            }
            case 2 -> {
                System.out.print("New last name: ");
                String newLastName = Auxiliar.ReadStringData(scanner);
                AuthorRepository.authors.get(position).getProfile().setLastName(newLastName);
            }
            case 3 -> {
                System.out.printf("New birth date%n");
                Date newDate = new Date();
                String date = newDate.birthDate();
                newDate.setBirthDate(date);
                AuthorRepository.authors.get(position).getProfile().setBirthDate(newDate);
            }
        }
    }

    /**
     * This method is using to edit the clients info
     *
     * @param option   is the option of what to edit
     * @param position is the position of the client in the array list
     */
    public void editClientProfile(int option, int position) {
        switch (option) {
            case 1 -> {
                System.out.print("New name: ");
                String newName = Auxiliar.ReadStringData(scanner);
                ClientRepository.clients.get(position).getProfile().setName(newName);
            }
            case 2 -> {
                System.out.print("New last name: ");
                String newLastName = Auxiliar.ReadStringData(scanner);
                ClientRepository.clients.get(position).getProfile().setLastName(newLastName);
            }
            case 3 -> {
                System.out.printf("New birth date%n");
                Date newDate = new Date();
                String date = newDate.birthDate();
                newDate.setBirthDate(date);
                ClientRepository.clients.get(position).getProfile().setBirthDate(newDate);
            }
        }
    }

    public void editAdministratorProfile(int option, int position) {
        switch (option) {
            case 1 -> {
                System.out.print("New name: ");
                String newName = Auxiliar.ReadStringData(scanner);
                AdministratorRepository.administrators.get(position).getProfile().setName(newName);
            }
            case 2 -> {
                System.out.print("New last name: ");
                String newLastName = Auxiliar.ReadStringData(scanner);
                AdministratorRepository.administrators.get(position).getProfile().setLastName(newLastName);
            }
            case 3 -> {
                System.out.printf("New birth date%n");
                Date newDate = new Date();
                String date = newDate.birthDate();
                newDate.setBirthDate(date);
                AdministratorRepository.administrators.get(position).getProfile().setBirthDate(newDate);
            }
        }
    }
}
