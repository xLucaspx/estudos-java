package br.com.curso.jdbc.testes;

import java.sql.SQLException;

import br.com.curso.jdbc.factory.ConnectionFactory;

public class TestePoolConexoes {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		for (int i = 1; i <= 20; i++) {
			connectionFactory.recuperaConexao();
			System.out.println("Conexão " + i);
		}
	}
}
