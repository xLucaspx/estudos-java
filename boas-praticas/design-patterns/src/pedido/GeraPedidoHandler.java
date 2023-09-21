package pedido;

import java.time.LocalDateTime;

import orcamento.Orcamento;

public class GeraPedidoHandler {
  // construtor com injeção de dependencias: repository/dao, services, etc.

  public void executa(GeraPedido dados) {
    Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
    Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

    System.out.println("Salvar pedido no banco de dados");
    System.out.println("Enviar e-mail com dados do pedido");
  }
}
