package orcamento;

import java.math.BigDecimal;

import orcamento.situacao.EmAnalise;
import orcamento.situacao.SituacaoOrcamento;

public class Orcamento {
  private BigDecimal valor;
  private int quantidadeItens;
  private SituacaoOrcamento situacao;

  public Orcamento(BigDecimal valor, int quantidadeItens) {
    this.valor = valor;
    this.quantidadeItens = quantidadeItens;
    this.situacao = new EmAnalise();
  }

  public SituacaoOrcamento getSituacao() {
    return situacao;
  }

  public void setSituacao(SituacaoOrcamento situacao) {
    this.situacao = situacao;
  }

  public void aplicarDescontoExtra() {
    BigDecimal descontoExtra = this.situacao.calculaDescontoExtra(this);
    this.valor = this.valor.subtract(descontoExtra);
  }

  public void aprovar() {
    this.situacao.aprovar(this);
  }

  public void reprovar() {
    this.situacao.reprovar(this);
  }

  public void finalizar() {
    this.situacao.finalizar(this);
  }

  public BigDecimal getValor() {
    return valor;
  }

  public int getQuantidadeItens() {
    return quantidadeItens;
  }
}
