package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Book implements Comparable<Book> {

	private int id;
	private int pages;
	private double price;
	private boolean read;
	private String title;
	private String isbn10;
	private String isbn13;
	private String review;
	private Format format;
	private Author author;
	private Publisher publisher;
	private LocalDate purchaseDate;
	private Set<Genre> genres;

	// constuctor with the required fields
	public Book(int id, String title, String isbn13, int pages, boolean read, Format format, Author author,
			Publisher publisher, float price) {
		this.id = id;
		this.title = title;
		this.isbn13 = isbn13;
		this.pages = pages;
		this.read = read;
		this.format = format;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.genres = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public int getPages() {
		return pages;
	}

	public boolean isRead() {
		return read;
	}

	public Author getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Format getFormat() {
		return format;
	}

	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	public Set<Genre> getGenres() {
		return Collections.unmodifiableSet(genres);
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPrice() {
		return price;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public int hashCode() {
		return id * title.hashCode() * isbn13.hashCode() * author.hashCode() * publisher.hashCode() * format.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Book book = (Book) o;
		return id == book.getId()
			&& title.equals(book.getTitle())
			&& isbn13.equals(book.getIsbn13())
			&& author.equals(book.getAuthor())
			&& format.equals(book.getFormat());
	}

	@Override
	public int compareTo(Book o) {
		return title.compareToIgnoreCase(o.getTitle());
	}

	@Override
	public String toString() {
		String strGenres = "";
		for (Genre g : genres) strGenres += String.format("%3s%s,\n", "	", g.formatAsJson());

		return """
			Book: {
				id: %d,
				title: "%s",
				ISBN-10: "%s",
				ISBN-13: "%s",
				pages: %d,
				read: %b,
				purchaseDate: "%s",
				price "R$ %.2f",
				%s,
				%s,
				%s,
				genres: {\n%s  }
			}
						""".formatted(id, title, (isbn10 != null ? isbn10 : "n/c"), isbn13, pages, read,
				(purchaseDate != null ? DateTimeFormatter.ofPattern("dd/MM/yyyy").format(purchaseDate) : "n/c"), price,
				format.formatAsJson(), author.formatAsJson(), publisher.formatAsJson(), strGenres);
	}
}
