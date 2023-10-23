package dao;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import models.Categoria;
import models.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public Produto buscaPorId(long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscaTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> filtraPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome LIKE :nome"; // os dois pontos são apenas na JPQL!
		return em.createQuery(jpql, Produto.class).setParameter("nome", "%" + nome + "%").getResultList();
	}

	public List<Produto> filtraPorNomeDaCategoria(String nomeDaCategoria) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome LIKE :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", "%" + nomeDaCategoria + "%").getResultList();
	}

	public BigDecimal buscaPrecoDoProduto(long id) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.id = :id";
		return em.createQuery(jpql, BigDecimal.class).setParameter("id", id).getSingleResult();
	}

	public List<Produto> filtraPorCategoriaEPreco(Categoria categoria, BigDecimal precoMinimo, BigDecimal precoMaximo) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria = :categoria AND p.preco BETWEEN :precoMin AND :precoMax";
		// podemos passar vários filtros, assim como no SQL:
		return em.createQuery(jpql, Produto.class)
				.setParameter("categoria", categoria)
				.setParameter("precoMin", precoMinimo)
				.setParameter("precoMax", precoMaximo)
				.getResultList();
	}

	public void cadastra(Produto produto) {
		this.em.persist(produto);
	}

	public void atualiza(Produto produto) {
		this.em.merge(produto);
	}

	public void remove(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
}
