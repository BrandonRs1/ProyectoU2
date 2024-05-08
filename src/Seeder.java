public class Seeder {
    public void initialize() {
        //Authors
        /// Author 1
        Date date1 = new Date(23,12,1998);
        Profile profile1 = new Profile("Pancho", "Soza", date1);
        Author author1 = new Author(profile1 );
        Date date1a = new Date(25, 10, 1200);
        Book book1 = new Book("Alive", "2312", date1a, author1, true);
        author1.setBooks(book1);
        AuthorRepository.authors.add(author1);
        BookRepository.books.add(book1);

        /// Author 2
        Date date2 = new Date(05, 02, 1923);
        Profile profile2 = new Profile("Leonardo", "Peña", date2);
        Author author2 = new Author(profile2);
        Date date2a = new Date(25, 06,1725);
        Book book2 = new Book("Happiness", "8571", date2a, author2, true);
        author2.setBooks(book2);
        AuthorRepository.authors.add(author2);
        BookRepository.books.add(book2);

        /////////////////////////////////////////////////////////////////////////

        //Clients
        /// Client 1

        Date date3 = new Date(07,01,2014);
        Profile profile3 = new Profile("Juan", "Ramirez", date3);
        Client client1 = new Client(profile3, "juan45", "j239as");
        UserRepository.users.add(client1);

        /// Client 2
        Date date4 = new Date(28, 12, 2012);
        Profile profile4 = new Profile("Luis", "Garcia", date4);
        Client client2 = new Client(profile4, "luis32", "k2307b");
        UserRepository.users.add(client2);

        //Admins
        // super Admin hacer el constructor
        Date date5 = new Date(22,03,1985);
        Profile profile5 = new Profile("Panfilo", "Ramirez", date5);
        Administrator superAdministrator = new Administrator(profile5, "panfilo45", "K27052", true);
        superAdministrator.setRead();
        superAdministrator.setDelete();
        superAdministrator.setWrite();
        UserRepository.users.add(superAdministrator);

        // admin1
        Date date6 = new Date(25, 07, 1990);
        Profile profile6 = new Profile("Pedro", "Sanchez", date6);
        Administrator administrator = new Administrator(profile6, "pedro52", "K27053", false);
        administrator.setWrite();
        administrator.setRead();
        UserRepository.users.add(administrator);
    }
}
