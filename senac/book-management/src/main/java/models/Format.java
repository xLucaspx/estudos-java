package models;

public enum Format {
	HARDCOVER(1, "Capa dura"), PAPERBACK(2, "Brochura"), EBOOK(3, "Ebook"), BOX(4, "Box");

	private int code;
	private String name;

	private Format(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return name;
	}

	public String formatAsJson() {
		return String.format("Format: { code: %d, name: \"%s\" }", code, name);
	}
}
