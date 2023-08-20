package services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.ValidacaoException;
import models.Funcionario;

public class ValidacaoPeriodoReajuste implements ValidacaoReajuste {

  public void validar(Funcionario funcionario, BigDecimal aumento) {
    LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
    long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, LocalDate.now());

    if (mesesDesdeUltimoReajuste < 6)
      throw new ValidacaoException("O intervalo entre reajustes não pode ser inferior a 6 meses!");
  }
}
