package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import models.Author;
import models.dto.AuthorDto;

public class AuthorServices {
  private Connection conn;

  public AuthorServices(Connection conn) {
    this.conn = conn;
  }

  public Set<Author> getAll() {
    String sql = "SELECT `id`, `name`, `nationality`, `books_owned` FROM `author`;";
    Set<Author> authors;

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      authors = transformResultSet(statement);
      return authors;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void create(AuthorDto authorDto) {
    String sql = "INSERT INTO `author` (`name`, `nationality`) VALUES (?, ?);";

    try (PreparedStatement statement = conn.prepareStatement(sql)) {
      statement.setString(1, authorDto.name());
      statement.setString(2, authorDto.nationality());

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
