package imposto;

import java.math.BigDecimal;

import models.Orcamento;

public class CalculadoraImposto {

  public BigDecimal calcula(Orcamento orcamento, Imposto imposto) {
    // Strategy:
    return imposto.calcula(orcamento);
  }
}
