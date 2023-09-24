package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Book {
  private int id;
  private String title;
  private String isbn;
  private int pages;
  private boolean read;
  private Author author;
  private Format format;
  private Set<Category> categories;
  private LocalDate purchaseDate;
  private float price;

  public Book(int id, String title, String isbn, int pages, boolean read, Author author, Format format,
      LocalDate purchaseDate, float price) {
    this.id = id;
    this.title = title;
    this.isbn = isbn;
    this.pages = pages;
    this.read = read;
    this.author = author;
    this.format = format;
    this.categories = new HashSet<>();
    this.purchaseDate = purchaseDate;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
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

  public Format getFormat() {
    return format;
  }

  public void addCategory(Category category) {
    categories.add(category);
  }

  public Set<Category> getCategories() {
    return Collections.unmodifiableSet(categories);
  }

  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public int hashCode() {
    return id * title.hashCode() * isbn.hashCode() * author.hashCode() * format.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;
    if (this.getClass() != o.getClass())
      return false;

    Book book = (Book) o;
    return id == book.getId()
        && title.equals(book.getTitle())
        && isbn.equals(book.getIsbn())
        && author.equals(book.getAuthor())
        && format.equals(book.getFormat());
  }

  @Override
  public String toString() {
    String strCategories = "";
    for (Category c : categories)
      strCategories += "    " + c.toString() + ",\n";

    return String.format(
        "Book {\n  id: %d,\n  title: %s,\n  ISBN: %s,\n  pages: %d,\n  read: %b,\n  purchase date: %s,\n  price R$ %.2f,\n  %s,\n  %s,\n  categories: { \n%s  }\n}",
        id, title, isbn, pages, read, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(purchaseDate), price, author,
        format, strCategories);
  }
}
