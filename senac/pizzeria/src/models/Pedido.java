package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
  private Cliente cliente;
  private HashMap<Pizza, Integer> itens;
  private float valor;
  
  public Pedido(Cliente cliente) {
    setCliente(cliente);
    itens = new HashMap<>();
  }

  public Pedido() {
    itens = new HashMap<>();
  }

  public void setCliente(Cliente cliente) {
    if (cliente == null) throw new IllegalArgumentException("Por favor, preencha corretamente as informações do cliente!");

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
  
  // private float calculaValor() {
  //   float total = 0.0f;
    
  //   for (HashMap.Entry<Pizza, Integer> item : itens.entrySet()) {
  //     Pizza p = item.getKey();
  //     Integer unidades = item.getValue();
  //     float valorTamanho = p.getTamanho().getValor();
  //     float valorOpcionais = 0.0f;
  //     for (Opcional o : p.getOpcionais()) valorOpcionais += o.getValor();
  //     total += (valorTamanho + valorOpcionais) * unidades;
  // }
  //   this.valor = total;
  //   return total;
  // }

  public float getValor() {
    // calculaValor();
    return valor;
  }
}