package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
  private static int numero;
  private Cliente cliente;
  // private HashMap<Pizza, Integer> itens;
  private ArrayList<Item> itens;
  private float valor;

  public Pedido(Cliente cliente) {
    setCliente(cliente);
    itens = new ArrayList<>();
    numero++;
  }

  public Pedido() {
    itens = new ArrayList<>();
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

  public void addItem(Item item) {
    if (item == null)
      throw new IllegalArgumentException("Por favor, preencha as informações do item corretamente!");

    this.valor += item.getValor();
    itens.add(item);
  }

  public void removeItem(int index) {
    if (index < 0) throw new IllegalArgumentException("Nenhum item foi selecionado!");

    this.valor -= itens.get(index).getValor();
    itens.remove(index);
  }

  public List<Item> getItens() {
    return Collections.unmodifiableList(itens);
  }

  private String listaItens() {
    String listaItens = String.format("%-4s - %-25s - %-10s - %-67s - %-4s - %-13s\n", "Item", "Sabor", "Tamanho",
        "Opcionais", "Un.", "Subtotal item");

    for (int i = 0; i < itens.size(); i++) {
      Item item = itens.get(i);
      Pizza p = item.getPizza();
      Integer unidades = item.getUnidades();
      String valor = String.format("R$ %.2f", item.getValor());

      listaItens += String.format("%04d - %-25s - %-10s - %-67s - %04d - %13s\n", i + 1, p.getSabor(), p.getTamanho(),
          p.getOpcionais().size() > 0 ? p.getOpcionais().toString().replace("[", "").replace("]", "") : "Sem opcionais",
          unidades, valor);
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
    return String.format("Pedido %d - %s\n\nInformações do cliente:\n%s\n\nItens do pedido:\n%s\n%138s", numero,
        dtFormatter.format(datetime), cliente, listaItens(), valor);
  }
}