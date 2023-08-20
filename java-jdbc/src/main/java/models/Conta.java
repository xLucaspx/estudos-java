package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {
  private Integer numero;
  private BigDecimal saldo;
  private Cliente titular;
  private boolean ativa;

  public Conta(int numero, Cliente titular) {
    this.numero = numero;
    this.titular = titular;
    this.saldo = BigDecimal.ZERO;
    this.ativa = true;
  }

  public Conta(int numero, BigDecimal saldo, Cliente titular) {
    this.numero = numero;
    this.titular = titular;
    this.saldo = saldo;
    this.ativa = true;
  }

  public Conta(int numero, BigDecimal saldo, Cliente titular, boolean ativa) {
    this.numero = numero;
    this.titular = titular;
    this.saldo = saldo;
    this.ativa = ativa;
  }

  public int getNumero() {
    return numero;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  public Cliente getTitular() {
    return titular;
  }

  public boolean possuiSaldo() {
    return this.saldo.compareTo(BigDecimal.ZERO) != 0;
  }

  public boolean estaAtiva() {
    return this.ativa;
  }

  public void sacar(BigDecimal valor) {
    this.saldo = this.saldo.subtract(valor);
  }

  public void depositar(BigDecimal valor) {
    this.saldo = this.saldo.add(valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || o.getClass() != getClass())
      return false;

    Conta c = (Conta) o;
    return numero.equals(c.getNumero());
  }

  @Override
  public String toString() {
    return String.format("Conta: { numero: %04d, saldo R$ %.2f, %s }", numero, saldo, titular);
  }
}
