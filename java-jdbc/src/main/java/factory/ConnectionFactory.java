package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
  private String username;
  private String password;

  public ConnectionFactory() {
    this.username = "user01";
    this.password = "admin";
  }

  public Connection getConnection() {
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/bytebank", username, password);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
