package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import models.Categoria;
import models.CategoriaId;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(CategoriaId id) {
		return em.find(Categoria.class, id);
	}

	public List<Categoria> buscaTodos() {
		String jpql = "SELECT c FROM Categoria c";

		return em.createQuery(jpql, Categoria.class).getResultList();
	}

	public List<Categoria> filtraPorNome(String nome) {
		String jpql = "SELECT c FROM Categoria c WHERE c.id.nome LIKE ?1"; // também podemos passar parâmetros por número!
		return em.createQuery(jpql, Categoria.class).setParameter(1, "%" + nome + "%").getResultList();
	}

	public void cadastra(Categoria categoria) {
		this.em.persist(categoria);
	}

	public void atualiza(Categoria categoria) {
		this.em.merge(categoria);
	}

	public void remove(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}
