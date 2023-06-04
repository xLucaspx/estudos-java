package testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import models.Produto;

public class TesteListagemComDAO {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperaConexao()) {

			List<Produto> produtos = new ProdutoDAO(connection).listaProdutos();

			produtos.forEach(produto -> System.out.println(produto));
		}
	}
}
