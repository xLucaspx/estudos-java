package pedido.acao;

import pedido.Pedido;

public class EnviarEmailPedido implements AcaoPedido {
  @Override
  public void executarAcao(Pedido pedido) {
    System.out.println("Enviando e-mail com dados do pedido!");
  }
}
