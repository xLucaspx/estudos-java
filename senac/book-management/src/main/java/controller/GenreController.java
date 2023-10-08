package controller;

import static utils.Validator.isValidString;

import java.util.Set;

import exceptions.ValidationException;
import models.Genre;
import services.GenreServices;

public class GenreController extends Controller {

	private final GenreServices genreServices;

	public GenreController() {
		this.genreServices = new GenreServices(connection);
	}

	public Genre getById(int id) {
		return genreServices.getById(id);
	}

	public Set<Genre> getAll() {
		return genreServices.getAll();
	}

	public Set<Genre> filterByName(String name) {
		return genreServices.filterByName(name);
	}

	// returns the created genre
	public Genre create(String name) {
		if (!isValidString(name)) throw new ValidationException("O nome da categoria deve ser preenchido corretamente!");

		int id = genreServices.create(name);
		return getById(id);
	}

	// returns the updated genre
	public Genre update(int id, String name) {
		if (!isValidString(name)) throw new ValidationException("O nome da categoria deve ser preenchido corretamente!");

		genreServices.update(id, name);
		return getById(id);
	}

	public void delete(int id) {
		genreServices.delete(id);
	}
}
