public class Seeder {
    public void initialize() {
        //Authors
        /// Author 1
        Author author1 = new Author();
        Date date1 = new Date();
        date1.setBirthDate("23/December/1998");
        Profile profile1 = new Profile("Pancho", "Soza", date1);
        author1.setProfile(profile1);
        date1.setPublishDate("05/March/2015");
        Book book1 = new Book("Alive", "2312a", author1, date1, true);
        author1.setBooks(book1);
        AuthorRepository.authors.add(author1);
        BookRepository.books.add(book1);

        /// Author 2
        Author author2 = new Author();
        Date date2 = new Date();
        date2.setBirthDate("05/February/1985");
        Profile profile2 = new Profile("Leonardo", "Peña", date2);
        author2.setProfile(profile2);
        date2.setPublishDate("03/November/2005");
        Book book2 = new Book("Happiness", "8571n", author2, date2, true);
        author2.setBooks(book2);
        AuthorRepository.authors.add(author2);
        BookRepository.books.add(book2);

        /////////////////////////////////////////////////////////////////////////

        //Clients
        /// Client 1

        Date date3 = new Date();
        date3.setBirthDate("07/May/2014");
        Profile profile3 = new Profile("Juan", "Ramirez", date3);
        Client client1 = new Client(profile3, "juan45", "j239as");
        ClientRepository.clients.add(client1);

        /// Client 2
        Date date4 = new Date();
        date4.setBirthDate("28/December/2012");
        Profile profile4 = new Profile("Luis", "Garcia", date4);
        Client client2 = new Client(profile4, "luis32", "k2307b");
        ClientRepository.clients.add(client2);

        //Admins
        // super Admin hacer el constructor
        Date date5 = new Date();
        date5.setBirthDate("22/March/1985");
        Profile profile5 = new Profile("Panfilo", "Ramirez", date5);
        Administrator superAdministrator = new Administrator(profile5, "panfilo45", "K27052", true);
        superAdministrator.setRead();
        superAdministrator.setDelete();
        superAdministrator.setWrite();
        AdministratorRepository.administrators.add(superAdministrator);

        // admin1
        Date date6 = new Date();
        date6.setBirthDate("25/July/1990");
        Profile profile6 = new Profile("Pedro", "Sanchez", date6);
        Administrator administrator = new Administrator(profile6, "pedro52", "K27053", false);
        administrator.setWrite();
        administrator.setRead();
        AdministratorRepository.administrators.add(administrator);
    }
}
