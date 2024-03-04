import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    CRUD
    Create
    Read
    Update
    Delete
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Controller principalController = new Controller();
        Seeder seeder = new Seeder();
        seeder.seeder();
        /*
        Fechas dadas por el sistema
        Cumpleaños dados por el usuario
         */
        Date date = new Date();
        System.out.printf(date.currentDate());
        int menuOption;
        do {
            menuOption = principalController.menuPrincipal();
            principalController.switchPrincipal(menuOption);
        } while (menuOption != 5);
    }
}