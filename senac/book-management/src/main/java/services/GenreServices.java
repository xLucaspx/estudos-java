package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import exceptions.NotFoundException;
import models.Genre;

public class GenreServices extends Services {

	public GenreServices(Connection con) {
		super(con);
	}

	public Genre getById(int id) {
		String sql = "SELECT `id`, `name`, countBooksByGenre(`id`) AS `books_owned` FROM `genre` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			Set<Genre> genres = transformResultSet(statement);

			if (genres.isEmpty()) throw new NotFoundException("Nenhum gênero encontrado para o id: " + id);

			return genres.toArray(new Genre[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Genre> getAll() {
		String sql = "SELECT `id`, `name`, countBooksByGenre(`id`) AS `books_owned` FROM `genre`;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			Set<Genre> genres = transformResultSet(statement);
			return genres;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Genre> filterByName(String name) {
		name = "%" + name + "%";
		String sql = "SELECT `id`, `name`, countBooksByGenre(`id`) AS `books_owned` FROM `genre` WHERE `name` LIKE ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, name);
			Set<Genre> genres = transformResultSet(statement);
			return genres;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// returns the generated id
	public int create(String genreName) {
		String sql = "INSERT INTO `genre` (`name`) VALUES (?);";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, genreName);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) throw new SQLException("Falha ao criar gênero, nenhuma linha do banco afetada!");

			int formatId = getGeneratedId(statement);
			return formatId;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, String newName) {
		String sql = "UPDATE `genre` SET `name` = ? WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, newName);
			statement.setInt(2, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM `genre` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Genre> transformResultSet(PreparedStatement ps) throws SQLException {
		Set<Genre> genres = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int booksOwned = rs.getInt("books_owned");

				Genre genre = new Genre(id, name, booksOwned);
				genres.add(genre);
			}
			return Collections.unmodifiableSet(genres);
		} catch (Exception e) {
			throw e;
		}
	}
}
