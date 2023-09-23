package models;

public class Author {
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
  public String toString() {
    return String.format(
      "Author { id: %d, name: %s, nationality: %s, books owned: %d }", id, name, nationality, booksOwned
    );
  }
}
