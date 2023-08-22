package imposto;

import java.math.BigDecimal;

import models.Orcamento;

public interface Imposto {
  BigDecimal calcula(Orcamento orcamento);
}
