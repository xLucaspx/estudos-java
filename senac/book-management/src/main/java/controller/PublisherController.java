package controller;

import static utils.Validator.isValidString;

import java.util.Set;

import exceptions.ValidationException;
import models.Publisher;
import services.PublisherServices;;

public class PublisherController {
	private final PublisherServices publisherServices;

	public PublisherController(PublisherServices services) {
		this.publisherServices = services;
	}

	public Publisher getById(int id) {
		return publisherServices.getById(id);
	}

	public Set<Publisher> getAll() {
		return publisherServices.getAll();
	}

	public Set<Publisher> filterByName(String name) {
		return publisherServices.filterByName(name);
	}

	// returns the created publisher
	public Publisher create(String name) {
		if (!isValidString(name)) throw new ValidationException("O nome da editora deve ser preenchido corretamente!");

		int id = publisherServices.create(name);
		return getById(id);
	}

	// returns the updated publisher
	public Publisher update(int id, String name) {
		if (!isValidString(name)) throw new ValidationException("O nome da editora deve ser preenchido corretamente!");

		publisherServices.update(id, name);
		return getById(id);
	}

	public void delete(int id) {
		publisherServices.delete(id);
	}
}
