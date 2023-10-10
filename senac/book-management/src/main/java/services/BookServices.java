package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exceptions.NotFoundException;
import models.Author;
import models.Book;
import models.Format;
import models.Genre;
import models.Publisher;
import models.dto.BookDto;

public class BookServices extends Services {

	public BookServices(Connection con) {
		super(con);
	}

	public Book getById(int id) {
		String sql = """
			  SELECT
			    b.`id`, b.`title`, b.`isbn_10`, b.`isbn_13`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
			    b.`format`, b.`author_id`, b.`publisher_id`, g.`genre_id`
			  FROM `book` b
			    INNER JOIN `book_genre` g ON b.`id` = g.`book_id`
			   WHERE b.`id` = ?;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			Set<Book> books = transformResultSet(statement);

			if (books.isEmpty()) throw new NotFoundException("Nenhum livro encontrado para o id: " + id);

			return books.toArray(new Book[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Book> getByAuthor(Author author) {
		String sql = """
			  SELECT
			    b.`id`, b.`title`, b.`isbn_10`, b.`isbn_13`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
			    b.`format`, b.`author_id`, b.`publisher_id`, g.`genre_id`
			  FROM `book` b
			    INNER JOIN `book_genre` g ON b.`id` = g.`book_id`
			  WHERE b.`author_id` = ?;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, author.getId());

			Set<Book> books = transformResultSet(statement);
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Book> getByPublisher(Publisher publisher) {
		String sql = """
			  SELECT
			    b.`id`, b.`title`, b.`isbn_10`, b.`isbn_13`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
			    b.`format`, b.`author_id`, b.`publisher_id`, g.`genre_id`
			  FROM `book` b
			    INNER JOIN `book_genre` g ON b.`id` = g.`book_id`
			  WHERE b.`publisher_id` = ?;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, publisher.getId());

			Set<Book> books = transformResultSet(statement);
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Book> getByGenre(Genre genre) {
		String sql = """
			  SELECT
			    b.`id`, b.`title`, b.`isbn_10`, b.`isbn_13`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
			    b.`format`, b.`author_id`, b.`publisher_id`, g.`genre_id`
			  FROM `book` b
			    INNER JOIN `book_genre` g ON b.`id` = g.`book_id`
			  WHERE g.`genre_id` = ?;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, genre.getId());

			Set<Book> books = transformResultSet(statement);
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Book> getAll() {
		String sql = """
			  SELECT
			    b.`id`, b.`title`, b.`isbn_10`, b.`isbn_13`, b.`pages`, b.`read`, b.`purchase_date`, b.`price`,
			    b.`format`, b.`author_id`, b.`publisher_id`, g.`genre_id`
			  FROM `book` b
			    INNER JOIN `book_genre` g ON b.`id` = g.`book_id`;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			Set<Book> books = transformResultSet(statement);
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// returns the generated id
	public int create(BookDto bookData) {
		String sql = """
				INSERT INTO `book`
					(`title`, `isbn_10`, `isbn_13`, `pages`, `read`, `format`, `author_id`, `publisher_id`, `purchase_date`, `price`)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
			""";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, bookData.title());
			statement.setString(2, bookData.isbn10());
			statement.setString(3, bookData.isbn13());
			statement.setInt(4, bookData.pages());
			statement.setBoolean(5, bookData.read());
			statement.setInt(6, bookData.format().getCode());
			statement.setInt(7, bookData.author().getId());
			statement.setInt(8, bookData.publisher().getId());
			statement.setDate(9, Date.valueOf(bookData.purchaseDate()));
			statement.setFloat(10, bookData.price());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) throw new SQLException("Falha ao criar livro, nenhuma linha do banco afetada");

			int bookId = getGeneratedId(statement);
			return bookId;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void addGenre(int bookId, int genreId) {
		String sql = "INSERT INTO `book_genre` (`book_id`, `genre_id`) VALUES (?, ?);";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, bookId);
			statement.setInt(2, genreId);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeGenre(int bookId, int genreId) {
		String sql = "DELETE FROM `book_genre` WHERE `book_id` = ? AND `genre_id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, bookId);
			statement.setInt(2, genreId);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, BookDto bookData) {
		String sql = """
			UPDATE `book`
			 SET `title` = ?, `isbn_10` = ?, `isbn_13` = ?, `pages` = ?, `read` = ?,
			 `format` = ?, `author_id` = ?, `publisher_id` = ?, `purchase_date` = ?, `price` = ?
			WHERE id = ?;
			""";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, bookData.title());
			statement.setString(2, bookData.isbn10());
			statement.setString(3, bookData.isbn13());
			statement.setInt(4, bookData.pages());
			statement.setBoolean(5, bookData.read());
			statement.setInt(6, bookData.format().getCode());
			statement.setInt(7, bookData.author().getId());
			statement.setInt(8, bookData.publisher().getId());
			statement.setDate(9, Date.valueOf(bookData.purchaseDate()));
			statement.setFloat(10, bookData.price());
			statement.setInt(11, id);

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateReadStatus(Book book) {
		String sql = "UPDATE `book` SET `read`= ? WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setBoolean(1, !book.isRead());
			statement.setInt(2, book.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM `book` WHERE `id` = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Book> transformResultSet(PreparedStatement ps) throws SQLException {
		Map<Integer, Book> books = new HashMap<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String isbn10 = rs.getString("isbn_10");
				String isbn13 = rs.getString("isbn_13");
				int pages = rs.getInt("pages");
				boolean read = rs.getBoolean("read");
				var purchaseDate = rs.getDate("purchase_date");
				float price = rs.getFloat("price");
				String formatName = rs.getString("format");
				int authorId = rs.getInt("author_id");
				int publisherId = rs.getInt("publisher_id");
				int genreId = rs.getInt("genre_id");

				Genre genre = new GenreServices(con).getById(genreId);

				if (books.containsKey(id)) {
					books.get(id).addGenre(genre);
					continue;
				}

				Author author = new AuthorServices(con).getById(authorId);
				Publisher publisher = new PublisherServices(con).getById(publisherId);
				Format format = Format.valueOf(formatName.toUpperCase());

				Book book = new Book(id, title, isbn13, pages, read, format, author, publisher, price);

				if (isbn10 != null) book.setIsbn10(isbn10);
				if (purchaseDate != null) book.setPurchaseDate(purchaseDate.toLocalDate());

				book.addGenre(genre);
				books.put(id, book);
			}

			return Collections.unmodifiableSet(new HashSet<>(books.values()));
		} catch (SQLException e) {
			throw e;
		}
	}
}
