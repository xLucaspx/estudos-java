package testes;

import models.Conta;

public class TesteMetodo {
  public static void main(String[] args) {
    System.out.println("testes de metodos e referencias");
    Conta conta = new Conta(1325, 25538);

    conta.deposita(150);

    System.out.println(conta.getSaldo());

    boolean conseguiuSacar = conta.saca(120);
    System.out.println(conta.getSaldo());
    System.out.println(conseguiuSacar);

    conseguiuSacar = conta.saca(150);
    System.out.println(conta.getSaldo());
    System.out.println(conseguiuSacar);

    Conta primeiraConta = new Conta(2152, 14885);
    primeiraConta.deposita(200.75);
    // primeiraConta.setAgencia(2152);
    // primeiraConta.setNumero(14885);

    System.out.print(primeiraConta.getSaldo() + " ");
    System.out.print(primeiraConta.getAgencia() + " ");
    System.out.print(primeiraConta.getNumero() + " ");
    // System.out.println(primeiraConta.getTitular() + " ");

    Conta segundaConta = new Conta(1337, 25469);
    segundaConta.deposita(500);
    System.out.println(segundaConta.getSaldo());

    boolean conseguiuTransferir = segundaConta.transfere(primeiraConta, 100);

    if (conseguiuTransferir) {
      System.out.println("Sua transferência foi enviada!");
      System.out.println(segundaConta.getSaldo());
      System.out.println(primeiraConta.getSaldo());
    } else {
      System.out.println("Ocorreu algum erro...");
    }

    // teste de referências:

    // Conta segundaConta = primeiraConta;
    //
    // System.out.println(segundaConta);
    // System.out.println(primeiraConta);
    // System.out.println(segundaConta.saldo);
    //
    // segundaConta.agencia = 25;
    // System.out.println(segundaConta.agencia);
    // System.out.println(primeiraConta.agencia);

    // Conta segundaConta = new Conta();
    //
    // System.out.println(segundaConta.saldo);
    // System.out.println(segundaConta.agencia);
    // System.out.println(segundaConta.numero);
    // System.out.println(segundaConta.titular);
  }
}
