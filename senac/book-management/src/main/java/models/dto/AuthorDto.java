package models.dto;

import static utils.Validator.isValidString;

import exceptions.ValidationException;

public record AuthorDto(String name, String nationality) {
	public AuthorDto {
		if (!isValidString(name)) throw new ValidationException("O nome deve ser corretamente preenchido!");

		if (!isValidString(nationality)) throw new ValidationException("A nacionalidade deve ser corretamente preenchida!");
	}
}
