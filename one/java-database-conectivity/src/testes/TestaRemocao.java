package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		// Statement statement = connection.createStatement();
		// statement.execute("DELETE FROM produtos WHERE id > 3;");

		// Utilizando PreparedStatement:
		PreparedStatement statement = connection.prepareStatement("DELETE FROM produtos WHERE id > ?");

		statement.setInt(1, 92);

		statement.execute();

		Integer linhasModificadas = statement.getUpdateCount();
		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);

		connection.close();
	}
}
