package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Services {

	protected Connection con;

	public Services(Connection con) {
		this.con = con;
	}

	protected int getGeneratedId(PreparedStatement statement) {

		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
			if (generatedKeys.next()) return generatedKeys.getInt(1);

			throw new SQLException("Failed to create, no ID obtained!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
