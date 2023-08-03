package models;

import enums.Opcional;
import enums.Sabor;
import enums.Tamanho;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pizza {
  private Sabor sabor;
  private Tamanho tamanho;
  private HashSet<Opcional> opcionais;

  public Pizza(Sabor sabor, Tamanho tamanho) {
    setSabor(sabor);
    setTamanho(tamanho);
    opcionais = new HashSet<>();
  }

  public Sabor getSabor() {
    return sabor;
  }

  private void setSabor(Sabor sabor) {
    this.sabor = sabor;
  }

  public Tamanho getTamanho() {
    return tamanho;
  }

  private void setTamanho(Tamanho tamanho) {
    this.tamanho = tamanho;
  }

  public void addOpcional(Opcional opcional) {
    opcionais.add(opcional);
  }

  public Set<Opcional> getOpcionais() {
    return Collections.unmodifiableSet(opcionais);
  }
}
