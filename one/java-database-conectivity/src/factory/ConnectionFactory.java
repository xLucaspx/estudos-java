package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
	private String user = "user01";
	private String password = "admin";

	private DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		// comboPooledDataSource.setMaxPoolSize(15);
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperaConexao() {
		// return DriverManager.getConnection(url, user, password);

		try {
			return this.dataSource.getConnection(); // utilizando pool de conexões
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
