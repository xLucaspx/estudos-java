package models.dto;

import java.time.LocalDate;

import models.Author;
import models.Format;

public record BookDto(String title, String isbn, int pages, Author author, Format format, LocalDate purchaseDate, double price,
		boolean read) {}
