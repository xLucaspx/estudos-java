package factory;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;

public class ConnectionFactory {
  private final String username = "user01";
  private final String password = "admin";

  public Connection getConection() {
    try {
      return this.createDataSource().getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private HikariDataSource createDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:mysql://localhost:3306/library");
    config.setUsername(username);
    config.setPassword(password);
    config.setMaximumPoolSize(5);

    return new HikariDataSource(config);
  }
}
