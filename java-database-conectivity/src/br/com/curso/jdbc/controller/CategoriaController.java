package br.com.curso.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.curso.jdbc.dao.CategoriaDAO;
import br.com.curso.jdbc.factory.ConnectionFactory;
import br.com.curso.jdbc.modelos.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDao;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperaConexao();
		this.categoriaDao = new CategoriaDAO(connection);
	}

	public List<Categoria> listaCategorias() {
		return categoriaDao.listaCategorias();
	}
}
