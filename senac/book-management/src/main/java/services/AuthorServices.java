package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.NotFoundException;
import models.Author;
import models.dto.AuthorDto;

public class AuthorServices {
  private Connection conn;

  public AuthorServices(Connection conn) {
    this.conn = conn;
  }

  public Author getById(int id) {
    String sql = "SELECT `id`, `name`, `nationality`, `books_owned` FROM `author` WHERE `id` = ?;";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setInt(1, id);
      Set<Author> authors = transformResultSet(statement);

      if (authors.size() == 0)
        throw new NotFoundException("No author was found for the id: " + id);

      return authors.toArray(new Author[1])[0];
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Author> getAll() {
    String sql = "SELECT `id`, `name`, `nationality`, `books_owned` FROM `author`;";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      Set<Author> authors = transformResultSet(statement);
      return authors;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Author> filterByName(String name) {
    name = "%" + name + "%";
    String sql = "SELECT `id`, `name`, `nationality`, `books_owned` FROM `author` WHERE `name` LIKE ?;";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setString(1, name);
      Set<Author> authors = transformResultSet(statement);
      return authors;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Author> filterByNationality(String nationality) {
    nationality = "%" + nationality + "%";
    String sql = "SELECT `id`, `name`, `nationality`, `books_owned` FROM `author` WHERE `nationality` LIKE ?;";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setString(1, nationality);
      Set<Author> authors = transformResultSet(statement);
      return authors;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void create(AuthorDto authorData) {
    String sql = "INSERT INTO `author` (`name`, `nationality`) VALUES (?, ?);";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setString(1, authorData.name());
      statement.setString(2, authorData.nationality());

      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void update(int id, AuthorDto authorData) {
    String sql = "UPDATE `author` SET `name` = ?, `nationality` = ? WHERE `id` = ?;";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setString(1, authorData.name());
      statement.setString(2, authorData.nationality());
      statement.setInt(3, id);

      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void delete(int id) {
    String sql = "DELETE FROM `author` WHERE `id` = ?";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setInt(1, id);
      statement.execute();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Set<Author> transformResultSet(PreparedStatement ps) throws SQLException {
    Set<Author> authors = new HashSet<>();

    try (ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String nationality = rs.getString(3);
        int booksOwned = rs.getInt(4);

        Author author = new Author(id, name, nationality, booksOwned);
        authors.add(author);
      }
      return authors;
    } catch (Exception e) {
      throw e;
    }
  }
}
