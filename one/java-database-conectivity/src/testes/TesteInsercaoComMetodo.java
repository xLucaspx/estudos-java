package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.ConnectionFactory;

public class TesteInsercaoComMetodo {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperaConexao()) {

			connection.setAutoCommit(false);
			// dessa forma, nós teremos que definir quando as alterações serão enviadas para
			// a database; pode afetar a performance, pois com AutoCommit podem haver mais
			// transações entre o programa e o banco de dados; também é mais seguro pois
			// cancela todas as operações em caso de erro

			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO produtos (nome, descricao) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)) {

				adicionaProduto("Caneta azul", "Caneta Bic azul", statement);
				adicionaProduto("Caneta preta", "Caneta Bic preta", statement);
				adicionaProduto("Caneta vermelha", "Caneta Bic vermelha", statement);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Rollback executado");
			}
		}
	}

	private static void adicionaProduto(String nomeProduto, String descricaoProduto, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nomeProduto);
		statement.setString(2, descricaoProduto);

		statement.execute();

		try (ResultSet result = statement.getGeneratedKeys()) {
			while (result.next()) {
				Integer id = result.getInt(1);
				System.out.println(nomeProduto + " adicionado com sucesso. ID: " + id);
			}
		}
	}
}
