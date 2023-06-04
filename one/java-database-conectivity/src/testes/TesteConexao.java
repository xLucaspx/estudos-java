package testes;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		long inicio = System.currentTimeMillis();
		System.out.println("Programa iniciado");

		// Connection connection = DriverManager
		// 	.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		System.out.println("Programa rodando");

		connection.close();

		System.out.println("Programa finalizado");
		long fim = System.currentTimeMillis();

		System.out.println("Tempo de execução: " + (fim - inicio));
	}
}
