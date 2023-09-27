package controller;

import exceptions.ValidationException;
import java.util.Set;

import models.Format;
import services.FormatServices;
import utils.Validator;

public class FormatController extends Controller {

  private final FormatServices formatServices;

  public FormatController() {
    this.formatServices = new FormatServices(connection);
  }

  public Format getById(int id) {
    return formatServices.getById(id);
  }

  public Set<Format> getAll() {
    return formatServices.getAll();
  }

  public Set<Format> filterByName(String name) {
    return formatServices.filterByName(name);
  }

  // returns the created format
  public Format create(String name) {
    if (!Validator.checkValidString(name))
      throw new ValidationException("O nome do formato deve ser preenchido corretamente!");

    int id = formatServices.create(name);
    return getById(id);
  }

  // returns the updated format
  public Format update(int id, String name) {
    if (!Validator.checkValidString(name))
      throw new ValidationException("O nome do formato deve ser preenchido corretamente!");

    formatServices.update(id, name);
    return getById(id);
  }

  public void delete(int id) {
    formatServices.delete(id);
  }
}
