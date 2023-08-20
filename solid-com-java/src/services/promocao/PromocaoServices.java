package services.promocao;

import exceptions.ValidacaoException;
import models.Cargo;
import models.Funcionario;

public class PromocaoServices {
  public void promover(Funcionario funcionario, boolean metaBatida) {
    Cargo cargoAtual = funcionario.getCargo();

    if (cargoAtual == Cargo.GERENTE)
      throw new ValidacaoException("Gerentes não podem ser promovidos!");

    if (!metaBatida)
      throw new ValidacaoException("Funcionário não bateu a meta!");

    Cargo novoCargo = cargoAtual.getProximoCargo();
    funcionario.promoveFuncionario(novoCargo);
  }
}
