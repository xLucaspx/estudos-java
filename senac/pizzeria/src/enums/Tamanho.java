package enums;

public enum Tamanho {
  BROTINHO("Brotinho", 18.0f), MEDIA("Média", 30.0f), GRANDE("Grande", 42.0f), FAMILIA("Família", 58.0f);

  private String tamanho;
  private float valor;

  private Tamanho(String tamanho, float valor) {
    this.tamanho = tamanho;
    this.valor = valor;
  }

  public static Tamanho fromString(String tamanho) {
    for (Tamanho t : Tamanho.values()) {
      if (t.tamanho.equals(tamanho)) return t;
    }
    throw new IllegalArgumentException("Não foi encontrado nenhum tamanho para o valor " + tamanho);
  }

  public float getValor() {
    return valor;
  }

  @Override
  public String toString() {
    return this.tamanho;
  }
}
