package orcamento.situacao;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class EmAnalise extends SituacaoOrcamento {
  @Override
  public BigDecimal calculaDescontoExtra(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.05));
  }

  @Override
  public void aprovar(Orcamento orcamento) {
    orcamento.setSituacao(new Aprovado());
  }

  @Override
  public void reprovar(Orcamento orcamento) {
    orcamento.setSituacao(new Reprovado());
  }
}
