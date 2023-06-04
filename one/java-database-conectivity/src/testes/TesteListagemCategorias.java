package testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import models.Categoria;
import models.Produto;

public class TesteListagemCategorias {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			// List<Categoria> categorias = categoriaDao.listaCategorias();
			// categorias.forEach(categoria -> System.out.println(categoria));

			List<Categoria> categorias = categoriaDao.listaComProdutos();

			categorias.forEach(categoria -> {
				System.out.println("Categoria: " + categoria.getNome());
				System.out.println("Produtos:");

				for (Produto produto : categoria.getProdutos()) {
					System.out.println(String.format("ID %3d | %25s", produto.getId(), produto.getNome()));
				}

				System.out.println(String.format("%35s|", " ").replaceAll(" ", "-"));
			});
		}
	}
}
