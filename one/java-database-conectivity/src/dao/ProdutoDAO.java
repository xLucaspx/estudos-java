package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Categoria;
import models.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastra(Produto produto) {
		String sql = "INSERT INTO produtos (nome, descricao) VALUES (?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					produto.setId(result.getInt(1));
					// System.out.println(produto.getNome() + " adicionado com sucesso. ID: " + produto.getId());
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void cadastraComCategoria(Produto produto) {
		String sql = "INSERT INTO produtos (nome, descricao, categoria_id) VALUES (?, ?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setInt(3, produto.getCategoriaId());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					produto.setId(result.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listaProdutos() {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT id, nome, descricao, categoria_id FROM produtos;";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();

			transformaResultSetEmProduto(produtos, statement);

			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> buscaProdutos(Categoria categoria) {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT id, nome, descricao FROM produtos WHERE categoria_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, categoria.getId());
			statement.execute();

			transformaResultSetEmProduto(produtos, statement);

			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletaProduto(Integer id) {
		String sql = "DELETE FROM produtos WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editaProduto(String nome, String descricao, Integer id) {
		String sql = "UPDATE produtos p SET p.nome = ?, p.descricao = ? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, nome);
			statement.setString(2, descricao);
			statement.setInt(3, id);

			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformaResultSetEmProduto(List<Produto> produtos, PreparedStatement statement) throws SQLException {
		try (ResultSet result = statement.getResultSet()) {
			while (result.next()) {
				Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
				produtos.add(produto);
			}
		}
	}
}
