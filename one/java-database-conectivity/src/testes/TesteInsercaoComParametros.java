package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.ConnectionFactory;

public class TesteInsercaoComParametros {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		String nomeProduto = "Mouse'"; // aspas simples na inserção normal quebraria a aplicação
		String descricaoProduto = "Mouse sem fio); DELETE FROM produtos;"; // inserção maliciosa que poderia causar prejuízos

		// para evitar complicações com inserções de usuários, que podem conter erros ou
		// serem prejudiciais ao programa, utilizamos:
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO produtos (nome, descricao) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);

		// substituindo "?" pelo valor (index SQL começa em 1):
		statement.setString(1, nomeProduto);
		statement.setString(2, descricaoProduto);

		statement.execute();

		ResultSet result = statement.getGeneratedKeys();

		while (result.next()) {
			Integer id = result.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

		connection.close();
	}
}
