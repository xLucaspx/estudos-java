package controller;

import java.sql.Connection;
import java.util.Set;

import factory.ConnectionFactory;
import models.Book;
import models.Category;
import models.dto.BookDto;
import services.BookServices;

public class BookController {
  private Connection connection;
  private BookServices bookServices;

  public BookController() {
    this.connection = new ConnectionFactory().getConection();
    this.bookServices = new BookServices(connection);
  }

  public Book getById(int id) {
    return bookServices.getById(id);
  }

  public Set<Book> getAll() {
    return bookServices.getAll();
  }

  public void create(BookDto bookData, Set<Category> categories) {
    int bookId = bookServices.create(bookData);
    categories.forEach(c -> bookServices.addCategory(bookId, c.getId()));
  }

  public void update(int id, BookDto bookData) {
    bookServices.update(id, bookData);
  }
}
