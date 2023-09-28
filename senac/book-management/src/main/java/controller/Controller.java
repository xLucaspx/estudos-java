package controller;

import java.sql.Connection;

import factory.ConnectionFactory;
import java.sql.SQLException;

public abstract class Controller {

  protected Connection connection;

  public Controller() {
    this.connection = new ConnectionFactory().getConection();
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
