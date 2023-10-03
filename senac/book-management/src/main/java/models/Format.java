package models;

public class Format {

	private int id;
	private String name;

	public Format(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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

		Format format = (Format) o;
		return id == format.getId() && name.equals(format.getName());
	}

	@Override
	public String toString() {
		return name;
	}

	public String formatAsJson() {
		return String.format("Format { id: %d, name: %s }", id, name);
	}
}
