package services.tributacao;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste {
  BigDecimal getImpostoDeRenda();
}
