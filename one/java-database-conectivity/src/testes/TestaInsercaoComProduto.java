package testes;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import models.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {

		Produto televisao = new Produto("Smart TV Samsung", "Smart TV Samsung 55\"");

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.cadastra(televisao);
		}
	}
}
