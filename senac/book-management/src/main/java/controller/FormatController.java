package controller;

import java.util.Set;

import models.Format;
import services.FormatServices;

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
  public Format create(String format) {
    int id = formatServices.create(format);
    return getById(id);
  }

  // returns the updated format
  public Format update(int id, String format) {
    formatServices.update(id, format);
    return getById(id);
  }

  public void delete(int id) {
    formatServices.delete(id);
  }
}
