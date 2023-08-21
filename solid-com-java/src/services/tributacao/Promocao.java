package services.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel {
  private BigDecimal valor;
  private LocalDate data;

  public Promocao(BigDecimal valor) {
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

  @Override
  public BigDecimal getImpostoDeRenda() {
    return valor.multiply(BigDecimal.valueOf(0.1)); // 10 %
  }
}
