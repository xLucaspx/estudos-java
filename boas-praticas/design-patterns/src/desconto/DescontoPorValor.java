package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class DescontoPorValor extends Desconto {
  public DescontoPorValor(Desconto proximo) {
    super(proximo);
  }

  @Override
  protected boolean isApplicable(Orcamento orcamento) {
    return orcamento.getValor().compareTo(BigDecimal.valueOf(500.0)) > 0;
  }

  @Override
  protected BigDecimal efetuarCalculo(Orcamento orcamento) {
    // 5% de desconto para orçamentos com valor superior a R$ 500,00
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.05));
  }
}
