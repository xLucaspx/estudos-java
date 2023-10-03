package controller;

import java.util.Set;

import exceptions.ValidationException;
import models.Author;
import models.dto.AuthorDto;
import services.AuthorServices;
import utils.Validator;

public class AuthorController extends Controller {

	private final AuthorServices authorServices;

	public AuthorController() {
		this.authorServices = new AuthorServices(connection);
	}

	public Author getById(int id) {
		return authorServices.getById(id);
	}

	public Set<Author> getAll() {
		return authorServices.getAll();
	}

	public Set<Author> filterByName(String name) {
		return authorServices.filterByName(name);
	}

	public Set<Author> filterByNationality(String nationality) {
		return authorServices.filterByNationality(nationality);
	}

	// returns the created author
	public Author create(AuthorDto authorData) {
		if (!Validator.isValidString(authorData.name()))
			throw new ValidationException("O nome deve ser corretamente preenchido!");

		if (!Validator.isValidString(authorData.nationality()))
			throw new ValidationException("A nacionalidade deve ser corretamente preenchida!");

		int id = authorServices.create(authorData);
		return getById(id);
	}

	// returns the updated author
	public Author update(int id, AuthorDto authorData) {
		authorServices.update(id, authorData);
		return getById(id);
	}

	public void delete(int id) {
		authorServices.delete(id);
	}
}
