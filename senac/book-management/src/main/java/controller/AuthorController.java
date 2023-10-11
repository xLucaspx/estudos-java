package controller;

import java.util.Set;

import models.Author;
import models.dto.AuthorDto;
import services.AuthorServices;

public class AuthorController {
	private final AuthorServices authorServices;

	public AuthorController(AuthorServices services) {
		this.authorServices = services;
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
