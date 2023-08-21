package utils;

import java.math.BigDecimal;

import models.Orcamento;

public class CalculadoraImposto {

  public BigDecimal calcula(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.1)); // 10%
  }
}
