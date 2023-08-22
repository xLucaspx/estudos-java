package desconto;

import java.math.BigDecimal;

import models.Orcamento;

public class CalculadoraDesconto {

  public BigDecimal calcula(Orcamento orcamento) {
    // Chain of Responsibility:
    Desconto desconto = new DescontoPorQuantidade(
        new DescontoPorValor(
            new SemDesconto()));

    return desconto.calcular(orcamento);
  }
}
