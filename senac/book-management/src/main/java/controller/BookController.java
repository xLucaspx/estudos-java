package controller;

import java.util.Set;

import models.Book;
import models.Genre;
import models.dto.BookDto;
import services.BookServices;

public class BookController extends Controller {

	private final BookServices bookServices;

	public BookController() {
		this.bookServices = new BookServices(connection);
	}

	public Book getById(int id) {
		return bookServices.getById(id);
	}

	public Set<Book> getAll() {
		return bookServices.getAll();
	}

	// returns the created book
	// TODO: check if the range of categories is between 1 and 3.
	public Book create(BookDto bookData, Set<Genre> genres) {
		int bookId = bookServices.create(bookData);
		genres.forEach(g -> bookServices.addGenre(bookId, g.getId()));
		return getById(bookId);
	}

	public void update(int id, BookDto bookData, Set<Genre> newGenres) {
		bookServices.update(id, bookData);
		var book = getById(id);
		var oldGenres = book.getGenres();

		for (Genre g : oldGenres) {
			if (newGenres.contains(g)) {
				newGenres.remove(g);
				continue;
			}
			bookServices.removeGenre(id, g.getId());
		}

		newGenres.forEach(g -> bookServices.addGenre(id, g.getId()));
	}

	public void delete(int id) {
		bookServices.delete(id);
	}
}
