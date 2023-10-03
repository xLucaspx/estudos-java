package controller;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

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
