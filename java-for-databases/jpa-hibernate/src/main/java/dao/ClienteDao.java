package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import models.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscaPorId(long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> buscaTodos() {
		String jpql = "SELECT c FROM Cliente c";

		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public List<Cliente> filtraPorNome(String nome) {
		String jpql = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome";
		return em.createQuery(jpql, Cliente.class).setParameter("nome", "%" + nome + "%").getResultList();
	}

	public void cadastra(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualiza(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remove(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}
}
