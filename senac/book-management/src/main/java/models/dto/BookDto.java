package models.dto;

import static utils.Isbn.convertToIsbn13;
import static utils.Isbn.isValidIsbn13;
import static utils.Validator.isValidString;

import java.time.LocalDate;

import exceptions.ValidationException;
import models.Author;
import models.Format;
import models.Publisher;

public record BookDto(String title, String isbn10, String isbn13, int pages, boolean read, Format format, Author author,
		Publisher publisher, LocalDate purchaseDate, float price) {

	public BookDto {
		if (!isValidString(title)) throw new ValidationException("O título do livro deve ser corretamente preenchido!");

		if (isValidString(isbn10)) {
			String generatedIsbn13 = convertToIsbn13(isbn10);

			if (!isValidString(isbn13)) isbn13 = generatedIsbn13;

			if (!isbn13.equals(generatedIsbn13))
				throw new ValidationException("O ISBN-10 e ISBN-13 informados não pertencem ao mesmo livro!");
		}

		if (!isValidIsbn13(isbn13)) throw new ValidationException("O ISBN-13 inserido não é válido!");

		if (pages < 0) throw new ValidationException("O número de páginas não pode ser menor que 0!");

		if (format == null) throw new ValidationException("O formato não pode ser nulo!");

		if (author == null) throw new ValidationException("O autor não pode ser nulo!");

		if (publisher == null) throw new ValidationException("A editora não pode ser nula!");

		if (price < 0) throw new ValidationException("O preço não pode ser menor que 0!");
	}
}
