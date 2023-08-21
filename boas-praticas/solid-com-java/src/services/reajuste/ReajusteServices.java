package services.reajuste;

import java.math.BigDecimal;
import java.util.List;

import models.Funcionario;

public class ReajusteServices {
  private List<ValidacaoReajuste> validacoes;

  public ReajusteServices(List<ValidacaoReajuste> validacoes) {
    this.validacoes = validacoes;
  }

  public void reajustaSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
    this.validacoes.forEach(v -> v.valida(funcionario, aumento));

    BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
    funcionario.atualizaSalario(salarioReajustado);
  }
}
