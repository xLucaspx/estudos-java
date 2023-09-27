package controller;

import exceptions.ValidationException;
import java.util.Set;
import models.Category;
import services.CategoryServices;
import utils.Validator;

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
  public Category create(String name) {
    if (!Validator.checkValidString(name))
      throw new ValidationException("O nome da categoria deve ser preenchido corretamente!");

    int id = categoryServices.create(name);
    return getById(id);
  }

  // returns the updated category
  public Category update(int id, String name) {
    if (!Validator.checkValidString(name))
      throw new ValidationException("O nome da categoria deve ser preenchido corretamente!");

    categoryServices.update(id, name);
    return getById(id);
  }

  public void delete(int id) {
    categoryServices.delete(id);
  }
}
