package controller;

import java.sql.Connection;

import factory.ConnectionFactory;

public abstract class Controller {
  protected Connection connection;

  public Controller() {
    this.connection = new ConnectionFactory().getConection();
  }
}
