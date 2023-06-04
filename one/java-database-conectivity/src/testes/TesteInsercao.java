package testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.ConnectionFactory;

public class TesteInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		Statement statement = connection.createStatement();

		statement.execute(
				"INSERT INTO produtos (nome, descricao) VALUES ('PlayStation 4 Pro', 'Console PlayStation 4 Pro com 1TB de memória');",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet results = statement.getGeneratedKeys();

		while (results.next()) {
			Integer id = results.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		connection.close();
	}
}