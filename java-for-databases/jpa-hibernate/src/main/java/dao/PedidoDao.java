package dao;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import models.Pedido;
import vo.RelatorioDeVendasVo;

public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public Pedido buscaPorId(long id) {
		return em.find(Pedido.class, id);
	}

	public Pedido buscaPorIdComCliente(long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}

	public List<Pedido> buscaTodos() {
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public void cadastra(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal getValorTotalVendido() {
		// o nome dos atributos buscados deve estar igual na entidade
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	// maneira mais "feia" de realizar uma consulta que retorna objetos diferentes:
//	public List<Object[]> getRelatorioDeVendas() {
//		String jpql = """
//				SELECT
//					produto.nome, SUM(item.quantidade), MAX(pedido.data)
//				FROM Pedido pedido
//					JOIN pedido.itens item
//					JOIN item.produto produto
//				GROUP BY produto
//				ORDER BY item.quantidade DESC
//			""";
//		return em.createQuery(jpql, Object[].class).getResultList();
//	}

	public List<RelatorioDeVendasVo> getRelatorioDeVendas() {
		// devemos passar o nome completo da classe no select new para evitar problemas,
		// além disso a classe VO deve conter um construtor compatível com a consulta JPQL!
		String jpql = """
				SELECT NEW vo.RelatorioDeVendasVo(
					produto.nome AS nome,
					SUM(item.quantidade) AS quantidade,
					MAX(pedido.data) AS ultimaVenda
				) FROM Pedido pedido
					INNER JOIN pedido.itens item
					INNER JOIN item.produto produto
				GROUP BY nome
				ORDER BY quantidade DESC, ultimaVenda DESC
			""";
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
}
