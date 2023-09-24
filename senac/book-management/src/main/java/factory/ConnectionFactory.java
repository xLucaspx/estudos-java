package factory;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
  private String username = "user01";
  private String password = "admin";

  public Connection getConection() {
    try {
      return this.createDataSource().getConnection();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private HikariDataSource createDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:mysql://localhost:3306/library");
    config.setUsername(username);
    config.setPassword(password);
    config.setMaximumPoolSize(10);

    return new HikariDataSource(config);
  }
}
