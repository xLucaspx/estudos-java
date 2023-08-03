package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
  private static int numero;
  private Cliente cliente;
  private HashMap<Pizza, Integer> itens;
  private float valor;

  public Pedido(Cliente cliente) {
    setCliente(cliente);
    itens = new HashMap<>();
    numero++;
  }

  public Pedido() {
    itens = new HashMap<>();
    numero++;
  }

  public void setCliente(Cliente cliente) {
    if (cliente == null)
      throw new IllegalArgumentException("Por favor, preencha corretamente as informações do cliente!");

    this.cliente = cliente;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void addItem(Pizza pizza, Integer unidades) {
    if (pizza == null)
      throw new IllegalArgumentException("Por favor, preencha as informações da pizza corretamente!");

    if (unidades <= 0)
      throw new IllegalArgumentException("O campo unidades deve ser preenchido com um número inteiro maior do que 0!");

    this.valor += (pizza.getValor() * unidades);
    itens.put(pizza, unidades);
  }

  public Map<Pizza, Integer> getItens() {
    return Collections.unmodifiableMap(itens);
  }

  private String listaItens() {
    String listaItens = String.format("%-4s - %-25s - %-10s - %-67s - %-4s - %-7s\n", "Item", "Sabor", "Tamanho",
        "Opcionais", "Un.", "Subtotal item");
    int i = 1;

    for (HashMap.Entry<Pizza, Integer> item : itens.entrySet()) {
      Pizza p = item.getKey();
      Integer unidades = item.getValue();
      String valor = String.format("R$ %.2f", p.getValor() * unidades);
      listaItens += String.format("%-4d - %-25s - %-10s - %-67s - %-4d - %-7s\n", i, p.getSabor(), p.getTamanho(),
          p.getOpcionais().size() > 0 ? p.getOpcionais().toString().replace("[", "").replace("]", "") : "Sem opcionais",
          unidades, valor);
      i++;
    }
    return listaItens;
  }

  public float getValor() {
    return valor;
  }

  public static int getNumero() {
    return numero;
  }

  @Override
  public String toString() {
    LocalDateTime datetime = LocalDateTime.now();
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    String valor = String.format("Valor total R$ %.2f", getValor());
    return String.format("Pedido %d - %s\n\nInformações do cliente:\n%s\n\nItens do pedido:\n%s\n\n%138s", numero,
        dtFormatter.format(datetime), cliente, listaItens(), valor);
  }
}