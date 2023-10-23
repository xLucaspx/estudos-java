package app;

import static utils.JPAUtil.getEntityManager;

import java.math.BigDecimal;

import dao.CategoriaDao;
import dao.ProdutoDao;
import models.Categoria;
import models.Produto;

public class App {
	public static void main(String... args) {
		cadastraProdutos();

		try (var em = getEntityManager()) {
			var produtoDao = new ProdutoDao(em);
			var categoriaDao = new CategoriaDao(em);

			var produto = produtoDao.buscaPorId(1l);
			System.out.println(produto);

			var categorias = categoriaDao.buscaTodos();
			categorias.forEach(System.out::println);

			var produtosFiltrados = produtoDao.filtraPorCategoriaEPreco(categoriaDao.buscaPorId(1l), new BigDecimal("900"),
					new BigDecimal("950"));
			produtosFiltrados.forEach(System.out::println);

			var categoriasFiltradas = categoriaDao.filtraPorNome("Livro");
			categoriasFiltradas.forEach(System.out::println);

			var preco = produtoDao.buscaPrecoDoProduto(3);
			System.out.println(String.format("R$ %.2f", preco));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void cadastraProdutos() {
		var celulares = new Categoria("Celulares");
		var informatica = new Categoria("Informática");
		var livros = new Categoria("Livros");

		var celular1 = new Produto("Moto G31", "4GB RAM, 32GB HD", new BigDecimal("879.35"), celulares);
		var celular2 = new Produto("Moto G32", "4GB RAM, 32GB HD", new BigDecimal("900.35"), celulares);
		var celular3 = new Produto("Moto G33", "4GB RAM, 32GB HD", new BigDecimal("975.00"), celulares);

		try (var em = getEntityManager()) {
			var produtoDao = new ProdutoDao(em);
			var categoriaDao = new CategoriaDao(em);

			em.getTransaction().begin();

			categoriaDao.cadastra(celulares);
			categoriaDao.cadastra(informatica);
			categoriaDao.cadastra(livros);

			produtoDao.cadastra(celular1);
			produtoDao.cadastra(celular2);
			produtoDao.cadastra(celular3);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
