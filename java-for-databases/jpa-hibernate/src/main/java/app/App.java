package app;

import static utils.JPAUtil.getEntityManager;

import java.math.BigDecimal;

import dao.CategoriaDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import models.Categoria;
import models.Cliente;
import models.Pedido;
import models.Produto;

public class App {
	public static void main(String... args) {
		populaBancoDeDados();

//		testaCadastroDeProdutos();
//		testaCadastroDePedido();

		try (var em = getEntityManager()) {
			var clienteDao = new ClienteDao(em);
			var produtoDao = new ProdutoDao(em);
			var pedidoDao = new PedidoDao(em);

			System.out.println(clienteDao.buscaPorId(1));

			produtoDao.buscarPorParametrosComCriteria("to", BigDecimal.valueOf(979.35f), null).forEach(System.out::println);
			produtoDao.buscarPorParametros("Os Sertões", BigDecimal.valueOf(84.99), null).forEach(System.out::println);

			pedidoDao.getRelatorioDeVendas().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void populaBancoDeDados() {
		var cliente = new Cliente("Lucas", "01928374659");

		var celulares = new Categoria("Celulares");
		var informatica = new Categoria("Informática");
		var livros = new Categoria("Livros");

		var celular1 = new Produto("Moto G31", "4GB RAM, 32GB HD", new BigDecimal("879.35"), celulares);
		var celular2 = new Produto("Moto G33", "16GB RAM, 128GB HD", new BigDecimal("1025.00"), celulares);

		var livro1 = new Produto("Os Sertões", "Capa dura, 687 páginas, editora XPTO", new BigDecimal("84.99"), livros);
		var livro2 = new Produto("Sherlock Holmes: Obra completa", "Box com 4 livros capa dura, 1687 páginas, editora XPTO",
				new BigDecimal("298.76"), livros);
		var livro3 = new Produto("1984", "Capa dura, 684 páginas, editora XPTO", new BigDecimal("89.8"), livros);

		var notebook = new Produto("Dell Inspiron 15", "Intel i7, 16 GB RAM, 500 GB SSD", new BigDecimal("5678.98"),
				informatica);

		var pedido = new Pedido(cliente);

		pedido.adicionaItem(livro1, 1);
		pedido.adicionaItem(livro2, 1);
		pedido.adicionaItem(livro3, 1);
		pedido.adicionaItem(notebook, 1);

		try (var em = getEntityManager()) {
			var produtoDao = new ProdutoDao(em);
			var categoriaDao = new CategoriaDao(em);
			var clienteDao = new ClienteDao(em);
			var pedidoDao = new PedidoDao(em);

			em.getTransaction().begin();

			clienteDao.cadastra(cliente);

			categoriaDao.cadastra(celulares);
			categoriaDao.cadastra(informatica);
			categoriaDao.cadastra(livros);

			produtoDao.cadastra(celular1);
			produtoDao.cadastra(celular2);

			produtoDao.cadastra(livro1);
			produtoDao.cadastra(livro2);
			produtoDao.cadastra(livro3);

			produtoDao.cadastra(notebook);

			pedidoDao.cadastra(pedido);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testaCadastroDeProdutos() {
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

	static void testaCadastroDePedido() {
		try (var em = getEntityManager()) {
			var clienteDao = new ClienteDao(em);
			var produtoDao = new ProdutoDao(em);
			var pedidoDao = new PedidoDao(em);

			var cliente = clienteDao.buscaPorId(1);

			var produto1 = produtoDao.buscaPorId(1);
			var produto2 = produtoDao.buscaPorId(2);

			var pedido = new Pedido(cliente);

			pedido.adicionaItem(produto1, 5);
			pedido.adicionaItem(produto2, 5);

			em.getTransaction().begin();

			pedidoDao.cadastra(pedido);

			em.getTransaction().commit();

			System.out.println("Valor total vendido R$ %.2f".formatted(pedidoDao.getValorTotalVendido()));

			var relatorio = pedidoDao.getRelatorioDeVendas();

			relatorio.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
