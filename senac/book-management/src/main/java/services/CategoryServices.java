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
import models.Category;

public class CategoryServices extends Services {

	public CategoryServices(Connection con) {
		super(con);
	}

	public Category getById(int id) {
		String sql = "SELECT `id`, `category` FROM `category` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			Set<Category> categories = transformResultSet(statement);

			if (categories.isEmpty()) throw new NotFoundException("No category was found for the id: " + id);

			return categories.toArray(new Category[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Category> getAll() {
		String sql = "SELECT `id`, `category` FROM `category`;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			Set<Category> categories = transformResultSet(statement);
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Category> filterByName(String name) {
		name = "%" + name + "%";
		String sql = "SELECT `id`, `category` FROM `category` WHERE `category` LIKE ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, name);
			Set<Category> categories = transformResultSet(statement);
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// returns the generated id
	public int create(String category) {
		String sql = "INSERT INTO `category` (`category`) VALUES (?);";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, category);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) throw new SQLException("Failed to create category, no rows affected!");

			int categoryId = getGeneratedId(statement);
			return categoryId;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, String category) {
		String sql = "UPDATE `category` SET `category` = ? WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, category);
			statement.setInt(2, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM `category` WHERE `id` = ?";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Category> transformResultSet(PreparedStatement ps) throws SQLException {
		Set<Category> categories = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);

				Category category = new Category(id, name);
				categories.add(category);
			}
			return Collections.unmodifiableSet(categories);
		} catch (Exception e) {
			throw e;
		}
	}
}
