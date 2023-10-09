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
import models.Author;
import models.dto.AuthorDto;

public class AuthorServices extends Services {

	public AuthorServices(Connection con) {
		super(con);
	}

	public Author getById(int id) {
		String sql = "SELECT `id`, `name`, `nationality`, countBooksByAuthor(`id`) AS `books_owned` FROM `author` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			Set<Author> authors = transformResultSet(statement);

			if (authors.isEmpty()) throw new NotFoundException("Nenhum autor encontrado para o id: " + id);

			return authors.toArray(new Author[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Author> getAll() {
		String sql = "SELECT `id`, `name`, `nationality`, countBooksByAuthor(`id`) AS `books_owned` FROM `author`;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			Set<Author> authors = transformResultSet(statement);
			return authors;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Author> filterByName(String name) {
		name = "%" + name + "%";
		String sql = "SELECT `id`, `name`, `nationality`, countBooksByAuthor(`id`) AS `books_owned` FROM `author` WHERE `name` LIKE ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, name);
			Set<Author> authors = transformResultSet(statement);
			return authors;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Author> filterByNationality(String nationality) {
		nationality = "%" + nationality + "%";
		String sql = "SELECT `id`, `name`, `nationality`, countBooksByAuthor(`id`) AS `books_owned` FROM `author` WHERE `nationality` LIKE ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, nationality);
			Set<Author> authors = transformResultSet(statement);
			return authors;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// returns the generated id
	public int create(AuthorDto authorData) {
		String sql = "INSERT INTO `author` (`name`, `nationality`) VALUES (?, ?);";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, authorData.name());
			statement.setString(2, authorData.nationality());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) throw new SQLException("Falha ao criar autor, nenhuma linha do banco afetada!");

			int authorId = getGeneratedId(statement);
			return authorId;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, AuthorDto authorData) {
		String sql = "UPDATE `author` SET `name` = ?, `nationality` = ? WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, authorData.name());
			statement.setString(2, authorData.nationality());
			statement.setInt(3, id);

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM `author` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Author> transformResultSet(PreparedStatement ps) throws SQLException {
		Set<Author> authors = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nationality = rs.getString("nationality");
				int booksOwned = rs.getInt("books_owned");

				Author author = new Author(id, name, nationality, booksOwned);
				authors.add(author);
			}
			return Collections.unmodifiableSet(authors);
		} catch (SQLException e) {
			throw e;
		}
	}
}
