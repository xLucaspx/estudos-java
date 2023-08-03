package enums;

public enum Opcional {
  MASSA_INTEGRAL("Massa integral", 6.0f), BACON_EXTRA("Bacon extra", 9.5f), BORDA_CHEDDAR("Borda com cheddar", 7.5f),
  BORDA_CHOCOLATE("Borda com chocolate", 7.5f);

  private String opcional;
  private float valor;

  private Opcional(String opcional, float valor) {
    this.opcional = opcional;
    this.valor = valor;
  }

  public float getValor() {
    return valor;
  }

  @Override
  public String toString() {
    return this.opcional;
  }
}
