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
  public String toString() {
    return String.format("Format { id: %d, name: %s }", id, name);
  }
}
