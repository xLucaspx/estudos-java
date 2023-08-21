package services.reajuste;

import java.math.BigDecimal;

import models.Funcionario;

public interface ValidacaoReajuste {
  void valida(Funcionario funcionario, BigDecimal aumento);
}
