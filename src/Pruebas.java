public class Pruebas {
    /*
    Modelo
    Vista
    Controlador
    */

    /**
     * Metodo para usar printf y como hacer una tabla con el mismo
     */
    public void pruebasPrintf() {
        boolean myBoolean = true;
        char myChar = '@';
        String myString = "Bro";
        int myInt = 50;
        double myDouble = 10000;

        System.out.printf("Boolean: %b\n", myBoolean);
        System.out.printf("Char: %c\n", myChar);
        System.out.printf("String: %s\n", myString);
        System.out.printf("Int: %d\n", myInt);
        System.out.printf("Doube: %f\n", myDouble);

        System.out.printf("\tWidth\n");
        /*
        width
        Es el número de caracteres que se pueden imprimir
        se cuentan espacios y el total de caracteres que tiene el dato que queremos
         */
        System.out.printf("Ejemplo: %5s\n", myString);
        /*
        Después de imprimir "Ejemplo"
        imprimimos lo que tiene myString que es bro
        Por lo que después de Ejemplo se imprimen dos espacios
        Más la palabra "bro" que tiene 3 caráctees
        Sumando así los 5 carácteres que queremos imprimir
         */

        System.out.printf("\tPresicion\n");
        /*
        Presición
        Es para indicar el número de decimales que queremos en un valor tipo float o tipo double
         */
        System.out.printf("Double con todos los décimales: %f\n", myDouble);
        System.out.printf("Double con 2 decimales: %.2f\n\n", myDouble);

        System.out.printf("|------------------------------------------------------|%n");
        System.out.printf("                   Ejemplo de tabla     %n");
        System.out.printf("|------------------------------------------------------|%n");
        System.out.printf("| %-12s | %-14s | %-20s |%n", "tipo de dato", "Identificador", "valor de la variable");
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("| %-12s | %-14s | %-20b |%n", "Boolean", "%b", true);
        System.out.printf("| %-12s | %-14s | %-20c |%n", "Char", "%c", '@');
        System.out.printf("| %-12s | %-14s | %-20s |%n", "String", "%s", "String uwu");
        System.out.printf("| %-12s | %-14s | %-20d |%n", "Int", "%d", 23);
        System.out.printf("| %-12s | %-14s | %,-20f |%n", "Double", "%f", 20000.53);
        System.out.printf("|------------------------------------------------------|%n");
    }
}