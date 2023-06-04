package curso;

public class ContaCorrente extends Conta {

  @Override // override garante que vamos sobrescrever o metodo da classe mãe corretamente
  public void deposita(double valor) {
    double valorDepositado = valor - 1;
    super.deposita(valorDepositado);
  }
}
