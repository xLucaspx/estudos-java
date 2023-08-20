package models;

public enum Cargo {
  ASSISTENTE("Assistente"), ANALISTA("Analista"), ESPECIALISTA("Especialista"), GERENTE("Gerente");

  private String cargo;

  private Cargo(String cargo) {
    this.cargo = cargo;
  }

  @Override
  public String toString() {
    return this.cargo;
  }
}
