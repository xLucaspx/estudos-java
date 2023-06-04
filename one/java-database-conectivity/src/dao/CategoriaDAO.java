package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Categoria;
import models.Produto;

public class CategoriaDAO {
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listaCategorias() {
		List<Categoria> categorias = new ArrayList<>();

		String sql = "SELECT id, nome FROM categorias;";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					categorias.add(new Categoria(result.getInt(1), result.getString(2)));
				}
			}
			return categorias;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> listaComProdutos() {
		List<Categoria> categorias = new ArrayList<>();
		Categoria categoria = null;

		String sql = "SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM categorias c INNER JOIN produtos p ON c.id = p.categoria_id;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					if (categoria == null || !categoria.getId().equals(result.getInt(1))) {

						categoria = new Categoria(result.getInt(1), result.getString(2));
						categorias.add(categoria);
					}
					categoria.adiciona(new Produto(result.getInt(3), result.getString(4), result.getString(5)));
				}
			}
			return Collections.unmodifiableList(categorias);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
