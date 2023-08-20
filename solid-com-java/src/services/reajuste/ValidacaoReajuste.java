package services.reajuste;

import java.math.BigDecimal;

import models.Funcionario;

public interface ValidacaoReajuste {
  void validar(Funcionario funcionario, BigDecimal aumento);
}
