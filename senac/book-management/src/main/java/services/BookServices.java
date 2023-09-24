package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exceptions.NotFoundException;
import models.Author;
import models.Book;
import models.Category;
import models.Format;
import models.dto.BookDto;

public class BookServices {
  private Connection con;

  public BookServices(Connection con) {
    this.con = con;
  }

  public Book getById(int id) {
    String sql = """
          SELECT
            b.`id`, b.`title`, b.`isbn`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
            b.`author_id`, a.`name`, a.`nationality`, a.`books_owned`,
            b.`format_id`, f.`format`, c.`id`, c.`category`
          FROM `book` b
            INNER JOIN `author` a ON b.`author_id` = a.`id`
            INNER JOIN `format`f ON b.`format_id` = f.`id`
            INNER JOIN `book_category` bc ON b.`id` = bc.`book_id`
            INNER JOIN `category` c ON bc.`category_id` = c.`id`
           WHERE b.`id` = ?;
        """;

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);
      Set<Book> books = transformResultSet(statement);

      if (books.size() == 0)
        throw new NotFoundException("No book was found for the id: " + id);

      return books.toArray(new Book[1])[0];
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Book> getAll() {
    String sql = """
          SELECT
            b.`id`, b.`title`, b.`isbn`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
            b.`author_id`, a.`name`, a.`nationality`, a.`books_owned`,
            b.`format_id`, f.`format`, c.`id`, c.`category`
          FROM `book` b
            INNER JOIN `author` a ON b.`author_id` = a.`id`
            INNER JOIN `format`f ON b.`format_id` = f.`id`
            INNER JOIN `book_category` bc ON b.`id` = bc.`book_id`
            INNER JOIN `category` c ON bc.`category_id` = c.`id`;
        """;

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      Set<Book> books = transformResultSet(statement);
      return books;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // criar book controller e fazer com que os métodos create retornem o ID, para
  // chamar o metodo add category pela controller
  public void create(BookDto bookData, Set<Category> categories) {
    String bookSql = "INSERT INTO `book` (`title`, `isbn`, `pages`, `author_id`, `format_id`, `purchase_date`, `price`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    String categorySql = "INSERT INTO `book_category` (`book_id`, `category_id`) VALUES (?, ?);";

    try (PreparedStatement bookStatement = con.prepareStatement(bookSql, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement categoryStatement = con.prepareStatement(categorySql)) {
      con.setAutoCommit(false);

      bookStatement.setString(1, bookData.title());
      bookStatement.setString(2, bookData.isbn());
      bookStatement.setInt(3, bookData.pages());
      bookStatement.setInt(4, bookData.author().getId());
      bookStatement.setInt(5, bookData.format().getId());
      bookStatement.setDate(6, Date.valueOf(bookData.purchaseDate()));
      bookStatement.setFloat(7, bookData.price());

      int bookId = 0;
      int rowsAffected = bookStatement.executeUpdate();
      if (rowsAffected == 0)
        throw new SQLException("Failed to create book, no rows affected!");

      try (ResultSet generatedKeys = bookStatement.getGeneratedKeys()) {
        if (generatedKeys.next())
          bookId = generatedKeys.getInt(1);
        else
          throw new SQLException("Failed to create book, no ID obtained!");
      }

      for (Category category : categories) {
        categoryStatement.setInt(1, bookId);
        categoryStatement.setInt(2, category.getId());
        categoryStatement.execute();
      }
      con.commit();
    } catch (Exception e) {
      if (con != null) {
        try {
          System.err.println("Rolling back transition...");
          con.rollback();
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
      }
      throw new RuntimeException(e);
    }
  }

  public void update(int id, BookDto bookData) {
    String sql = "UPDATE `book` SET `title` = ?, `isbn` = ?, `pages` = ?, `author_id` = ?, `format_id` = ?, `purchase_date` = ?, `price` = ? WHERE id = ?;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, bookData.title());
      statement.setString(2, bookData.isbn());
      statement.setInt(3, bookData.pages());
      statement.setInt(4, bookData.author().getId());
      statement.setInt(5, bookData.format().getId());
      statement.setDate(6, Date.valueOf(bookData.purchaseDate()));
      statement.setFloat(7, bookData.price());
      statement.setInt(8, id);

      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void delete(int id) {
    String sql = "DELETE FROM `book` WHERE `id` = ?";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Set<Book> transformResultSet(PreparedStatement ps) throws SQLException {
    Map<Integer, Book> books = new HashMap<>();

    try (ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        int id = rs.getInt(1);
        String title = rs.getString(2);
        String isbn = rs.getString(3);
        int pages = rs.getInt(4);
        boolean read = rs.getBoolean(5);
        LocalDate purchaseDate = rs.getDate(6).toLocalDate();
        float price = rs.getFloat(7);
        int authorId = rs.getInt(8);
        String authorName = rs.getString(9);
        String nationality = rs.getString(10);
        int booksOwned = rs.getInt(11);
        int formatId = rs.getInt(12);
        String formatName = rs.getString(13);
        int categoryid = rs.getInt(14);
        String categoryName = rs.getString(15);

        Author author = new Author(authorId, authorName, nationality, booksOwned);
        Format format = new Format(formatId, formatName);
        Category category = new Category(categoryid, categoryName);
        Book book = new Book(id, title, isbn, pages, read, author, format, purchaseDate, price);

        if (books.containsKey(id)) {
          books.get(id).addCategory(category);
          continue;
        }

        book.addCategory(category);
        books.put(id, book);
      }

      return Collections.unmodifiableSet(new HashSet<Book>(books.values()));
    } catch (Exception e) {
      throw e;
    }
  }
}
