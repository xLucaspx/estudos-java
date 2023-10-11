package models;

public class Publisher implements Comparable<Publisher> {

	private int id;
	private String name;
	private int booksOwned;

	public Publisher(int id, String name, int booksOwned) {
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

		Publisher publisher = (Publisher) o;
		return id == publisher.getId() && name.equals(publisher.getName());
	}

	@Override
	public int compareTo(Publisher o) {
		return name.compareToIgnoreCase(o.getName());
	}

	@Override
	public String toString() {
		return name;
	}

	public String formatAsJson() {
		return String.format("Publisher: { id: %d, name: \"%s\", booksOwned: %d }", id, name, booksOwned);
	}
}
