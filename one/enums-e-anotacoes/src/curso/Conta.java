package curso;

/**
 * anotações javadoc:
 * 
 * @author L. paz
 * @version 0.1.0
 */
public abstract class Conta {

  @DoublePositivo // podemos criar nossas proprias anotações (no caso esta não faz nada)
  protected double saldo;

  public void deposita(double valor) {
    this.saldo += valor;
  }

  public double getSaldo() {
    return this.saldo;
  }
}
