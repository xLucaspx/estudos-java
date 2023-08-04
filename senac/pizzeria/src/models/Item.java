package models;

public class Item {
  private Pizza pizza;
  private int unidades;
  private float valor;

  public Item(Pizza pizza, int unidades) {
    setPizza(pizza);
    setUnidades(unidades);
    calculaValor();
  }

  public Pizza getPizza() {
    return pizza;
  }

  private void setPizza(Pizza pizza) {
    if (pizza == null)
      throw new IllegalArgumentException("A pizza deve ser montada corretamente!");

    this.pizza = pizza;
  }

  public int getUnidades() {
    return unidades;
  }

  private void setUnidades(int unidades) {
    if (unidades <= 0)
      throw new IllegalArgumentException("O campo unidades deve ser preenchido com um número inteiro maior do que 0!");

    this.unidades = unidades;
  }

  public float getValor() {
    return valor;
  }

  private void calculaValor() {
    this.valor = pizza.getValor() * unidades;
  }
}
