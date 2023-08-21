package models;

public enum Cargo {
  ASSISTENTE("Assistente") {
    @Override
    public Cargo getProximoCargo() {
      return ANALISTA;
    }
  },
  ANALISTA("Analista") {
    @Override
    public Cargo getProximoCargo() {
      return ESPECIALISTA;
    }
  },
  ESPECIALISTA("Especialista") {
    @Override
    public Cargo getProximoCargo() {
      return GERENTE;
    }
  },
  GERENTE("Gerente") {
    @Override
    public Cargo getProximoCargo() {
      return GERENTE;
    }
  };

  private String cargo;

  private Cargo(String cargo) {
    this.cargo = cargo;
  }

  public abstract Cargo getProximoCargo();

  @Override
  public String toString() {
    return this.cargo;
  }
}
