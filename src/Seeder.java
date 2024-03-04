public class Seeder {
    public void seeder() {
        Date autor1Date = new Date();
        Date author2Date = new Date();
        autor1Date.setBirthDay("22", "Enero", "1995");
        author2Date.setBirthDay("05", "Febrero", "2002");

        Profile profile1 = new Profile("Pan", "Quesadilla", autor1Date);
        Profile profile2 = new Profile("Leonardo", "Manchego", author2Date);

        Author author1 = new Author();
        Author author2 = new Author();
        author1.setProfile(profile1);
        author2.setProfile(profile2);

        Book book1 = new Book("Butterfly war", "isj22", true);
        Book book2 = new Book("Eternal", "arb12c", true);
        Book book3 = new Book("I´m not me", "12c15b", true);

        author1.setAuthorBooks(book1);
        author2.setAuthorBooks(book2);
        author2.setAuthorBooks(book3);

        book1.setAuthor(author1);
        book2.setAuthor(author2);
        book3.setAuthor(author2);

        Date book1Date = new Date();
        Date book2Date = new Date();
        Date book3Date = new Date();

        book1Date.publishYear("22", "Marzo", "1966");
        book2Date.publishYear("01", "Febrero", "2000");
        book3Date.publishYear("6", "July", "1987");

        book1.setPublishDate(book1Date);
        book2.setPublishDate(book2Date);
        book3.setPublishDate(book3Date);

        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();

        authorRepository.setAuthors(author1);
        authorRepository.setAuthors(author2);

        bookRepository.setBooks(book1);
        bookRepository.setBooks(book2);
        bookRepository.setBooks(book3);
        /////////////////////////////////////////////////
        Date client1Date = new Date();
        Date client2Date = new Date();
        client1Date.setBirthDay("22", "Marzo", "2000");
        client2Date.setBirthDay("05", "Junio", "1990");

        Profile client1Profile = new Profile("Leonardo", "Soza", client1Date);
        Profile cliente2Profile = new Profile("Panque", "Azul", client2Date);

        Client client1 = new Client();
        Client client2 = new Client();

        client1.setProfile(client1Profile);
        client2.setProfile(cliente2Profile);

        client1.setBirthDate(client1Date);
        client2.setBirthDate(client2Date);
    }
}
