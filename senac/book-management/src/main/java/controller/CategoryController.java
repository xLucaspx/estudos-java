package controller;

import java.util.Set;

import models.Category;
import services.CategoryServices;

public class CategoryController extends Controller {

  private final CategoryServices categoryServices;

  public CategoryController() {
    this.categoryServices = new CategoryServices(connection);
  }

  public Category getById(int id) {
    return categoryServices.getById(id);
  }

  public Set<Category> getAll() {
    return categoryServices.getAll();
  }

  public Set<Category> filterByName(String name) {
    return categoryServices.filterByName(name);
  }

  // returns the created category
  public Category create(String category) {
    int id = categoryServices.create(category);
    return getById(id);
  }

  // returns the updated category
  public Category update(int id, String category) {
    categoryServices.update(id, category);
    return getById(id);
  }

  public void delete(int id) {
    categoryServices.delete(id);
  }
}
