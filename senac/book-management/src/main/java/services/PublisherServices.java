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
import models.Publisher;

public class PublisherServices extends Services {

	public PublisherServices(Connection con) {
		super(con);
	}

	public Publisher getById(int id) {
		String sql = "SELECT `id`, `name`, countBooksByPublisher(`id`) AS `books_owned` FROM `publisher` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			Set<Publisher> publishers = transformResultSet(statement);

			if (publishers.isEmpty()) throw new NotFoundException("Nenhuma editora encontrada para o id: " + id);

			return publishers.toArray(new Publisher[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Publisher> getAll() {
		String sql = "SELECT `id`, `name`, countBooksByPublisher(`id`) AS `books_owned` FROM `publisher`;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			Set<Publisher> publishers = transformResultSet(statement);
			return publishers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Publisher> filterByName(String name) {
		name = "%" + name + "%";
		String sql = "SELECT `id`, `name`, countBooksByPublisher(`id`) AS `books_owned` FROM `publisher` WHERE `name` LIKE ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, name);
			Set<Publisher> publishers = transformResultSet(statement);
			return publishers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// returns the generated id
	public int create(String publisherName) {
		String sql = "INSERT INTO `publisher` (`name`) VALUES (?);";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, publisherName);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) throw new SQLException("Falha ao criar editora, nenhuma linha do banco afetada!");

			int formatId = getGeneratedId(statement);
			return formatId;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, String newName) {
		String sql = "UPDATE `publisher` SET `name` = ? WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, newName);
			statement.setInt(2, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM `publisher` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Publisher> transformResultSet(PreparedStatement ps) throws SQLException {
		Set<Publisher> publishers = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int booksOwned = rs.getInt("books_owned");

				Publisher publisher = new Publisher(id, name, booksOwned);
				publishers.add(publisher);
			}
			return Collections.unmodifiableSet(publishers);
		} catch (Exception e) {
			throw e;
		}
	}
}
