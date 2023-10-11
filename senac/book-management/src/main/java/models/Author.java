package models;

public class Author implements Comparable<Author> {

	private int id;
	private String name;
	private String nationality;
	private int booksOwned;

	public Author(int id, String name, String nationality, int booksOwned) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.booksOwned = booksOwned;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public int getBooksOwned() {
		return booksOwned;
	}

	@Override
	public int hashCode() {
		return id * name.hashCode() * nationality.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Author author = (Author) o;
		return id == author.getId()
			&& name.equals(author.getName())
			&& nationality.equals(author.getNationality());
	}

	@Override
	public int compareTo(Author o) {
		return name.compareToIgnoreCase(o.getName());
	}

	@Override
	public String toString() {
		return name;
	}

	public String formatAsJson() {
		return String.format("Author { id: %d, name: \"%s\", nationality: \"%s\", booksOwned: %d }",
			id, name, nationality, booksOwned);
	}
}
