package factory;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private String username;
	private String password;

	public ConnectionFactory() {
		this.username = "root";
		this.password = "";
	}

	public Connection getConnection() {
		try {
			return createDataSource().getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private HikariDataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_school");
		config.setUsername(username);
		config.setPassword(password);
		config.setMaximumPoolSize(10);

		return new HikariDataSource(config);
	}
}
