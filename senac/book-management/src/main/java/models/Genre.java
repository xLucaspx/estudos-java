package models;

public class Genre implements Comparable<Genre> {

	private int id;
	private String name;
	private int booksOwned;

	public Genre(int id, String name, int booksOwned) {
		this.id = id;
		this.name = name;
		this.booksOwned = booksOwned;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBooksOwned() {
		return booksOwned;
	}

	@Override
	public int hashCode() {
		return id * name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Genre genre = (Genre) o;
		return id == genre.getId() && name.equals(genre.getName());
	}

	@Override
	public int compareTo(Genre o) {
		return name.compareToIgnoreCase(o.getName());
	}

	@Override
	public String toString() {
		return name;
	}

	public String formatAsJson() {
		return String.format("Genre: { id: %d, name: \"%s\", booksOwned: %d }", id, name, booksOwned);
	}
}
