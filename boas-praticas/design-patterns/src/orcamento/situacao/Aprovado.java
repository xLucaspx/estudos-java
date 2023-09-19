package orcamento.situacao;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento {
  @Override
  public BigDecimal calculaDescontoExtra(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(0.02));
  }

  @Override
  public void finalizar(Orcamento orcamento) {
    orcamento.setSituacao(new Finalizado());
  }
}
