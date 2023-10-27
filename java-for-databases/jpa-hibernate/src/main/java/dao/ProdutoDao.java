package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		// gambiarra para concatenar ANDs:
		String jpql = "SELECT p FROM Produto p WHERE 1=1 ";

		if (nome != null && !nome.trim().isEmpty()) jpql += " AND p.nome = :nome ";

		if (preco != null) jpql += " AND p.preco = :preco ";

		if (dataCadastro != null) jpql += " AND p.dataCadastro = :dataCadastro ";

		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);

		if (nome != null && !nome.trim().isEmpty()) query.setParameter("nome", nome);

		if (preco != null) query.setParameter("preco", preco);

		if (dataCadastro != null) query.setParameter("dataCadastro", dataCadastro);

		return query.getResultList();
	}

	public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal precoMin, LocalDate dataCadastro) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);

		Predicate filtros = builder.and();
		// para adicionar parâmetros, é necessário substituir o Predicate; para isso, chamamos o método do CriteriaBuilder
		// que desejamos utilizar para concatenar os parâmetros e passamos o Predicate antigo e o método de comparação, que
		// recebe o campo/coluna que desejamos usar como parâmetro buscado no Root e o valor passado para ele:
		if (nome != null && !nome.trim().isEmpty())
			filtros = builder.and(filtros, builder.like(from.get("nome"), "%" + nome + "%"));

		if (precoMin != null) filtros = builder.and(filtros, builder.greaterThan(from.get("preco"), precoMin));

		if (dataCadastro != null) filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));

		query.where(filtros);

		return em.createQuery(query).getResultList();
	}
}
