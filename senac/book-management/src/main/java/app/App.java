package app;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;
import services.AuthorServices;
import services.BookServices;
import services.CategoryServices;
import services.FormatServices;

public class App {
  public static void main(String... args) throws SQLException {
    ConnectionFactory cf = new ConnectionFactory();
    Connection conn = cf.getConection();

    BookServices bookServices = new BookServices(conn);
    AuthorServices authorServices = new AuthorServices(conn);
    CategoryServices categoryServices = new CategoryServices(conn);
    FormatServices formatServices = new FormatServices(conn);

    bookServices.getAll().forEach(System.out::println);
    authorServices.getAll().forEach(System.out::println);
    categoryServices.getAll().forEach(System.out::println);
    formatServices.getAll().forEach(System.out::println);

    conn.close();
  }
}
