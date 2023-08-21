package services.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {
  private BigDecimal valor;
  private LocalDate data;

  public Anuenio(BigDecimal valor) {
    this.valor = valor;
    this.data = LocalDate.now();
  }

  @Override
  public BigDecimal getValor() {
    return valor;
  }

  @Override
  public LocalDate getData() {
    return data;
  }
}
