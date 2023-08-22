package imposto;

import java.math.BigDecimal;

import models.Orcamento;

public class ISS implements Imposto {
  @Override
  public BigDecimal calcula(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.06)); // 6%
  }
}
