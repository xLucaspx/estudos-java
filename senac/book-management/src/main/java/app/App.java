package app;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Arrays;

import factory.ConnectionFactory;
import models.Author;
import models.Book;
import models.Category;
import models.Format;
import models.dto.AuthorDto;
import services.AuthorServices;

public class App {
  public static void main(String... args) {
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

    ConnectionFactory cf = new ConnectionFactory();
    Connection conn = cf.getConection();

    AuthorServices authorServices = new AuthorServices(conn);

    authorServices.create(new AuthorDto(euclides.getName(), euclides.getNationality()));
    System.out.println(authorServices.getAll());
  }
}
