package br.com.curso.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.curso.jdbc.dao.ProdutoDAO;
import br.com.curso.jdbc.factory.ConnectionFactory;
import br.com.curso.jdbc.modelos.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {

		Produto televisao = new Produto("Smart TV Samsung", "Smart TV Samsung 55\"");

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.cadastra(televisao);
		}
	}
}
