package controller;

import java.sql.Connection;
import java.util.List;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import models.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDao;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperaConexao();
		this.produtoDao = new ProdutoDAO(connection);
	}

	public void cadastra(Produto produto) {
		produtoDao.cadastraComCategoria(produto);
	}

	public List<Produto> listaProdutos() {
		return produtoDao.listaProdutos();
	}

	public void deletaProduto(Integer id) {
		produtoDao.deletaProduto(id);
	}

	public void editaProduto(String nome, String descricao, Integer id) {
		produtoDao.editaProduto(nome, descricao, id);
	}
}
