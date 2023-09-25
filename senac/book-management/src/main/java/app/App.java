package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.BookController;
import factory.ConnectionFactory;
import models.dto.BookDto;
import services.AuthorServices;
import services.CategoryServices;
import services.FormatServices;

public class App {
  public static void main(String... args) throws SQLException {
    ConnectionFactory cf = new ConnectionFactory();
    Connection conn = cf.getConection();

    // BookServices bookServices = new BookServices(conn);
    AuthorServices authorServices = new AuthorServices(conn);
    CategoryServices categoryServices = new CategoryServices(conn);
    FormatServices formatServices = new FormatServices(conn);

    BookController bookController = new BookController();

    bookController.create(new BookDto("teste criado", "1234567890934", 567, authorServices.getById(1),
        formatServices.getById(1), LocalDate.now(), 24.6f), categoryServices.getAll());

    bookController.update(7, new BookDto("teste atualizado", "0000000765432", 100, authorServices.getById(3),
        formatServices.getById(2), LocalDate.now(), 1.65f));

    bookController.getAll().forEach(System.out::println);
    // authorServices.getAll().forEach(System.out::println);
    // categoryServices.getAll().forEach(System.out::println);
    // formatServices.getAll().forEach(System.out::println);

    conn.close();
  }
}
