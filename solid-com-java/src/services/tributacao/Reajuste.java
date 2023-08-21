package services.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {
  BigDecimal getValor();

  LocalDate getData();
}
