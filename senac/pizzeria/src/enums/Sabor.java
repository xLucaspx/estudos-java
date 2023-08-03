package enums;

public enum Sabor {
  PEPPERONI("Pepperoni"), BASCA("Basca"), FRANGO_BACON("Frango c/ bacon"), CINCO_QUEIJOS("Cinco-queijos"),
  CHOCOLATE_MORANGO("Chocolate c/ morango");

  private String sabor;

  private Sabor(String sabor) {
    this.sabor = sabor;
  }

  @Override
  public String toString() {
    return this.sabor;
  }
}
