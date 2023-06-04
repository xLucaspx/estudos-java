package testes;

import models.Cliente;
import models.Conta;

public class TesteBanco {
  public static void main(String[] args) {
    Cliente cliente1 = new Cliente();

    cliente1.setNome("Rodrigo");
    cliente1.setCpf("025.147.697-95");
    cliente1.setProfissao("Programador");

    Conta conta1 = new Conta(1223, 17540);

    // conta1.setAgencia(1223);
    // conta1.setNumero(17554);
    conta1.setTitular(cliente1);

    conta1.deposita(500);

    Conta conta2 = new Conta(5241, 25887);
    conta2.setTitular(new Cliente());
    conta2.getTitular().setNome("Julia");
    conta1.transfere(conta2, 250);

    System.out.println(conta1.getTitular().getNome() + " seu saldo é: R$ " + conta1.getSaldo());
    System.out.println(conta2.getTitular().getNome() + " seu saldo é: R$ " + conta2.getSaldo());
    System.out.println("Número de contas: " + Conta.getNumeroDeContas());
  }
}
