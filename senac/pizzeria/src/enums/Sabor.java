package enums;

public enum Sabor {
  PEPPERONI("Pepperoni"), BASCA("Basca"), FRANGO_BACON("Frango c/ bacon"), CINCO_QUEIJOS("Cinco-queijos"),
  CHOCOLATE_MORANGO("Chocolate c/ morango");

  private String sabor;

  private Sabor(String sabor) {
    this.sabor = sabor;
  }

  public static Sabor fromString(String sabor) {
    for (Sabor s : Sabor.values()) {
      if (s.sabor.equals(sabor)) return s;
    }
    throw new IllegalArgumentException("Não foi encontrado nenhum sabor para o valor " + sabor);
  }

  @Override
  public String toString() {
    return this.sabor;
  }
}
