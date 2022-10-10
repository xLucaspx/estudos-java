package br.com.curso.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.curso.jdbc.dao.ProdutoDAO;
import br.com.curso.jdbc.factory.ConnectionFactory;
import br.com.curso.jdbc.modelos.Produto;

public class TesteListagemComDAO {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			
			List<Produto> produtos = new ProdutoDAO(connection).listaProdutos();
			
			produtos.forEach(produto -> System.out.println(produto));
		}
		
	}
}
