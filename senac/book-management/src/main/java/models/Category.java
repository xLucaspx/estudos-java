package models;

public class Category {

  private int id;
  private String name;

  public Category(int id, String name) {
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

    Category category = (Category) o;
    return id == category.getId()
      && name.equals(category.getName());
  }

  @Override
  public String toString() {
    return String.format("Category { id: %d, name: %s }", id, name);
  }
}
