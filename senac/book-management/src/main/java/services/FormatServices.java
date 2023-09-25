package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import exceptions.NotFoundException;
import models.Format;

public class FormatServices extends Services {
  public FormatServices(Connection con) {
    super(con);
  }

  public Format getById(int id) {
    String sql = "SELECT `id`, `format` FROM `format` WHERE `id` = ?;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);
      Set<Format> formats = transformResultSet(statement);

      if (formats.size() == 0)
        throw new NotFoundException("No format was found for the id: " + id);

      return formats.toArray(new Format[1])[0];
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Format> getAll() {
    String sql = "SELECT `id`, `format` FROM `format`;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      Set<Format> formats = transformResultSet(statement);
      return formats;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<Format> filterByName(String name) {
    name = "%" + name + "%";
    String sql = "SELECT `id`, `format` FROM `format` WHERE `format` LIKE ?;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, name);
      Set<Format> formats = transformResultSet(statement);
      return formats;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // returns the generated id
  public int create(String format) {
    String sql = "INSERT INTO `format` (`format`) VALUES (?);";

    try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      statement.setString(1, format);

      int rowsAffected = statement.executeUpdate();
      if (rowsAffected == 0)
        throw new SQLException("Failed to create format, no rows affected!");

      int formatId = getGeneratedId(statement);
      return formatId;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void update(int id, String format) {
    String sql = "UPDATE `format` SET `format` = ? WHERE `id` = ?;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, format);
      statement.setInt(2, id);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void delete(int id) {
    String sql = "DELETE FROM `format` WHERE `id` = ?";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);
      statement.execute();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Set<Format> transformResultSet(PreparedStatement ps) throws SQLException {
    Set<Format> formats = new HashSet<>();

    try (ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);

        Format format = new Format(id, name);
        formats.add(format);
      }
      return Collections.unmodifiableSet(formats);
    } catch (Exception e) {
      throw e;
    }
  }
}
