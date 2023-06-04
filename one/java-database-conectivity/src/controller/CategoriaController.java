package controller;

import java.sql.Connection;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import models.Categoria;

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
