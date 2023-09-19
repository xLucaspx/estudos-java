package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class SemDesconto extends Desconto {
  public SemDesconto() {
    super(null);
  }

  @Override
  protected boolean isApplicable(Orcamento orcamento) {
    return true;
  }

  @Override
  protected BigDecimal efetuarCalculo(Orcamento orcamento) {
    return BigDecimal.ZERO;
  }
}
