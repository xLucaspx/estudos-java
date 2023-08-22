package desconto;

import java.math.BigDecimal;

import models.Orcamento;

public abstract class Desconto {
  protected Desconto next;

  public Desconto(Desconto next) {
    this.next = next;
  }

  protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

  protected abstract boolean isApplicable(Orcamento orcamento);

  public BigDecimal calcular(Orcamento orcamento) {
    if (isApplicable(orcamento))
      return efetuarCalculo(orcamento);

    return next.calcular(orcamento);
  }
}
