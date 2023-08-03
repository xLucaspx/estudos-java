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
  private float valor;

  public Pizza(Sabor sabor, Tamanho tamanho) {
    setSabor(sabor);
    setTamanho(tamanho);
    opcionais = new HashSet<>();
  }

  public Sabor getSabor() {
    return sabor;
  }

  private void setSabor(Sabor sabor) {
    if (sabor == null)
      throw new IllegalArgumentException("O sabor da pizza deve ser selecionado!");

    this.sabor = sabor;
  }

  public Tamanho getTamanho() {
    return tamanho;
  }

  private void setTamanho(Tamanho tamanho) {
    if (tamanho == null)
      throw new IllegalArgumentException("O tamanho da pizza deve ser selecionado!");

    this.valor += tamanho.getValor();
    this.tamanho = tamanho;
  }

  public void addOpcional(Opcional opcional) {
    if (sabor == null)
      throw new IllegalArgumentException("O valor selecionado não é um opcional válido! Valor selecionado: " + opcional);

    this.valor += opcional.getValor();
    opcionais.add(opcional);
  }

  public Set<Opcional> getOpcionais() {
    return Collections.unmodifiableSet(opcionais);
  }

  public float getValor() {
    return valor;
  }

  @Override
  public String toString() {
    return String.format("Pizza sabor %s\nTamanho: %s\nOpcionais: %s", sabor, tamanho,
        opcionais.size() > 0 ? opcionais : "sem opcionais");
  }
}
