package factory;

import controller.AuthorController;
import controller.BookController;
import controller.GenreController;
import controller.PublisherController;

public class ControllerFactory {
	private final ServicesFactory servicesFactory;

	public ControllerFactory() {
		this.servicesFactory = new ServicesFactory();
	}

	public BookController getBookController() {
		return new BookController(servicesFactory.createBookServices());
	}

	public AuthorController getAuthorController() {
		return new AuthorController(servicesFactory.createAuthorServices());
	}

	public PublisherController getPublisherController() {
		return new PublisherController(servicesFactory.createPublisherServices());
	}

	public GenreController getGenreController() {
		return new GenreController(servicesFactory.createGenreServices());
	}
}
