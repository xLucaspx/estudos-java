package app;

import java.time.LocalDate;
import java.util.Arrays;

import models.Author;
import models.Book;
import models.Category;
import models.Format;

public class App {
  public static void main(String... args) {
    // ConnectionFactory cf = new ConnectionFactory();
    // Connection conn = cf.getConection();

    // AuthorServices authorServices = new AuthorServices(conn);

    // authorServices.create(new AuthorDto("Euclides da Cunha", "American"));
    // authorServices.create(new AuthorDto("Stephen King", "American"));
    // authorServices.create(new AuthorDto("erick larssonn", "American"));

    // authorServices.getAll().forEach(System.out::println);

    // authorServices.update(3, new AuthorDto("Erik Larson", "American"));

    // System.out.println(authorServices.filterByName("cunha"));
    // System.out.println(authorServices.filterByNationality("american"));

    // Author euclides = authorServices.getById(1);

    Format papperback = new Format(1, "Papperback");

    Category journalism = new Category(1, "Journalism");
    Category brazillian = new Category(2, "Brazillian Literature");

    Author euclides = new Author(1, "Euclides da Cunha", "Brazillian", 1);

    Book sertoes = new Book(1, "Os Sertões", "1234567890147", 659, true, euclides, papperback,
        Arrays.asList(journalism, brazillian), LocalDate.now(), 29.5f);

    System.out.println("\n" + papperback);
    System.out.println("\n" + journalism);
    System.out.println("\n" + brazillian);
    System.out.println("\n" + euclides);
    System.out.println("\n" + sertoes);
  }
}
