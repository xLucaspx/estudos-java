package controller;

import java.util.Set;

import models.Book;
import models.Category;
import models.dto.BookDto;
import services.BookServices;

public class BookController extends Controller {
  private BookServices bookServices;

  public BookController() {
    this.bookServices = new BookServices(connection);
  }

  public Book getById(int id) {
    return bookServices.getById(id);
  }

  public Set<Book> getAll() {
    return bookServices.getAll();
  }

  // returns the created book
  // TODO: check if the range of categories is between 1 and 3.
  public Book create(BookDto bookData, Set<Category> categories) {
    int bookId = bookServices.create(bookData);
    categories.forEach(c -> bookServices.addCategory(bookId, c.getId()));
    return getById(bookId);
  }

  // TODO: implement update method
  // public void update(int id, BookDto bookData) {
  // bookServices.update(id, bookData);
  // }

  public void delete(int id) {
    bookServices.delete(id);
  }
}
