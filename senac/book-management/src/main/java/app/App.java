package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import factory.ConnectionFactory;
import models.Author;
import models.Category;
import models.Format;
import models.dto.BookDto;
import services.AuthorServices;
import services.BookServices;

public class App {
  public static void main(String... args) throws SQLException {
    Format papperback = new Format(1, "Papperback");
    Format ebook = new Format(2, "Ebook");

    Category journalism = new Category(1, "Journalism");
    Category brazillian = new Category(2, "Brazillian Literature");
    Category romance = new Category(3, "Romance");
    Category german = new Category(4, "German Literature");

    ConnectionFactory cf = new ConnectionFactory();
    Connection conn = cf.getConection();

    BookServices bookServices = new BookServices(conn);
    AuthorServices authorServices = new AuthorServices(conn);

    // authorServices.create(new AuthorDto("Johann Wolfgang von Goethe", "German"));
    // authorServices.create(new AuthorDto("erivk larssonn", "American"));
    // authorServices.create(new AuthorDto("Euclides da Cunha", "Brazillian"));
    // authorServices.create(new AuthorDto("Stephen King", "American"));

    // authorServices.update(2, new AuthorDto("Erik Larson", "American"));
    // authorServices.delete(4);

    System.out.println(authorServices.filterByName("ha"));
    System.out.println(authorServices.filterByNationality("american"));

    Author goethe = authorServices.getById(1);
    Author euclides = authorServices.getById(3);

    Set<Category> categories1 = new HashSet<>();
    categories1.add(romance);
    categories1.add(german);
    bookServices.create(new BookDto("Os Sofrimentos do Jovem Werther", "1234567890987", 191, goethe, papperback,
        LocalDate.of(2022, 11, 1), 24f), categories1);

    Set<Category> categories2 = new HashSet<>();
    categories2.add(journalism);
    categories2.add(brazillian);
    bookServices.create(
        new BookDto("Os Sertões", "1234567890987", 659, euclides, ebook, LocalDate.of(2023, 1, 15), 24f), categories2);

    bookServices.update(2,
        new BookDto("Os Sertões", "0987654321276", 679, euclides, ebook, LocalDate.of(2023, 2, 15), 12f));

    bookServices.getAll().forEach(System.out::println);
    authorServices.getAll().forEach(System.out::println);

    conn.close();
  }
}
