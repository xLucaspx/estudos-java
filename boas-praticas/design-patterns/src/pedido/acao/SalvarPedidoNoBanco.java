package pedido.acao;

import pedido.Pedido;

public class SalvarPedidoNoBanco implements AcaoPedido {
  @Override
  public void executarAcao(Pedido pedido) {
    System.out.println("Salvando pedido no banco de dados!");
  }
}
