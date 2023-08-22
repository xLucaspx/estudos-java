package desconto;

import java.math.BigDecimal;

import models.Orcamento;

public class DescontoPorQuantidade extends Desconto {
  public DescontoPorQuantidade(Desconto next) {
    super(next);
  }

  @Override
  protected boolean isApplicable(Orcamento orcamento) {
    return orcamento.getQuantidadeItens() > 5;
  }

  @Override
  protected BigDecimal efetuarCalculo(Orcamento orcamento) {
    // 10% de desconto para orçamentos com mais de 5 itens
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.1));
  }
}
