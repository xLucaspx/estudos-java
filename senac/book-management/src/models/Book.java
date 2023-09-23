package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Book {
  private int id;
  private String title;
  private String isbn;
  private int pages;
  private boolean read;
  private Author author;
  private Format format;
  private List<Category> categories;
  private LocalDate purchaseDate;
  private float price;

  public Book(int id, String title, String isbn, int pages, boolean read, Author author, Format format,
      List<Category> categories, LocalDate purchaseDate, float price) {
    this.id = id;
    this.title = title;
    this.isbn = isbn;
    this.pages = pages;
    this.read = read;
    this.author = author;
    this.format = format;
    this.categories = categories;
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

  public List<Category> getCategories() {
    return Collections.unmodifiableList(categories);
  }

  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public String toString() {
    String strCategories = "";
    for (Category c : categories)
      strCategories += "    " + c.toString() + "\n";

    return String.format(
        "Book {   id: %d,\n  title: %s,\n  ISBN: %s,\n  pages: %d,\n  read: %b,\n  purchase date: %s,\n  price R$ %.2f\n  %s\n  %s\n  categories: { \n%s  }\n}",
        id, title, isbn, pages, read, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(purchaseDate), price, author,
        format, strCategories);
  }
}
