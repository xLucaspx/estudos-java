package factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private final String username = "user01";
	private final String password = "admin";
	private final String database = "book_management";

	public Connection getConection() {
		try {
			return this.createDataSource().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private HikariDataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/" + database);
		config.setUsername(username);
		config.setPassword(password);
		config.setMaximumPoolSize(5);

		return new HikariDataSource(config);
	}
}
