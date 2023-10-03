package controller;

import java.util.Set;

import exceptions.ValidationException;
import models.Book;
import models.Category;
import models.dto.BookDto;
import services.BookServices;
import utils.Validator;

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
	public Book create(BookDto bookData, Set<Category> categories) {
		if (!Validator.isValidString(bookData.title()))
			throw new ValidationException("O título do livro deve ser preenchido corretamente!");

		if (!Validator.isValidIsbn(bookData.isbn()))
			throw new ValidationException("O ISBN inserido é inválido!");

		int bookId = bookServices.create(bookData);
		categories.forEach(c -> bookServices.addCategory(bookId, c.getId()));
		return getById(bookId);
	}

	public void update(int id, BookDto bookData, Set<Category> categories) {
		bookServices.update(id, bookData);
		var book = getById(id);
		var oldCategories = book.getCategories();

		for (Category category : oldCategories) {

			if (categories.contains(category)) {
				categories.remove(category);
				continue;
			}
			bookServices.removeCategory(id, category.getId());
		}

		for (Category category : categories) {

			if (oldCategories.contains(category)) continue;
			
			bookServices.addCategory(id, category.getId());
		}
	}

	public void delete(int id) {
		bookServices.delete(id);
	}
}
