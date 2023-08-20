package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import exceptions.ValidacaoException;
import models.Funcionario;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

  public void validar(Funcionario funcionario, BigDecimal aumento) {
    BigDecimal salarioAtual = funcionario.getSalario();
    BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);

    if (percentualReajuste.compareTo(BigDecimal.valueOf(0.4)) > 0)
      throw new ValidacaoException("O reajuste não pode ser superior a 40% do salário!");
  }
}
