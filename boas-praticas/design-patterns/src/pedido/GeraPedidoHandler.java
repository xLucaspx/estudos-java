package pedido;

import java.time.LocalDateTime;
import java.util.List;

import orcamento.Orcamento;
import pedido.acao.AcaoPedido;

public class GeraPedidoHandler {
  private List<AcaoPedido> acoes;

  // construtor com injeção de dependencias: repository/dao, services, etc.
  // utilizando pattern Observer para simplificar e diminuir acoplamento
  public GeraPedidoHandler(List<AcaoPedido> acoes) {
    this.acoes = acoes;
  }

  public void executa(GeraPedido dados) {
    Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
    Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

    // utilizando as dependências recebidas para executar ações:
    acoes.forEach(acao -> acao.executarAcao(pedido));
  }
}
