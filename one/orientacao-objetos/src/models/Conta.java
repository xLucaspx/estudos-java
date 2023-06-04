package models;

public class Conta {
  private double saldo;
  private int agencia;
  private int numero;
  private Cliente titular;
  private static int totalDeContas;

  public Conta(int agencia, int numero) {
    totalDeContas++;
    System.out.println("Conta nº " + getNumeroDeContas() + ":");
    setAgencia(agencia);
    setNumero(numero);
    System.out.println("-*-*-*-*-*-");
  }

  public double getSaldo() {
    return this.saldo;
  }

  public int getAgencia() {
    return this.agencia;
  }

  public void setAgencia(int agencia) {
    if (agencia <= 0) {
      System.out.println("Numero de agência inválido");
      return;
    }
    this.agencia = agencia;
    System.out.println("Agência definida para " + agencia);
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    if (numero <= 0) {
      System.out.println("Número de conta inválido");
      return;
    }
    this.numero = numero;
    System.out.println("Número da conta definido para " + numero);
  }

  public Cliente getTitular() {
    return this.titular;
  }

  public void setTitular(Cliente titular) {
    this.titular = titular;
  }

  public static int getNumeroDeContas() {
    return Conta.totalDeContas;
  }

  public void deposita(double valor) {
    if (valor > 0) {
      this.saldo += valor;
    }
  }

  public boolean saca(double valor) {
    if (valor > 0 && this.saldo >= valor) {
      this.saldo -= valor;
      return true;
    }
    return false;
  }

  public boolean transfere(Conta destino, double valor) {
    if (valor > 0 && this.saldo >= valor) {
      this.saca(valor);
      destino.deposita(valor);
      return true;
    }
    return false;
  }
}
