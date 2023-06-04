package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TesteListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		// Statement do pacote java.sql
		// Statement statement = connection.createStatement();
		// statement.execute("SELECT id, nome, descricao FROM produtos"); // devolve boolean

		// Utilizando PreparedStatement:
		PreparedStatement statement = connection.prepareStatement("SELECT id, nome, descricao FROM produtos");
		statement.execute();

		ResultSet result = statement.getResultSet();

		while (result.next()) {
			// Integer id = result.getInt(1); // as colunas começam com 1; mesmo resultado que:
			Integer id = result.getInt("id");

			// String nome = result.getString(2);
			String nome = result.getString("nome");

			// String descricao = result.getString(3);
			String descricao = result.getString("descricao");

			System.out.println("ID " + id + " | " + nome);
			System.out.println("Descrição: " + descricao);
		}
		connection.close();
	}
}
