package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public interface Imposto {
  BigDecimal calcula(Orcamento orcamento);
}
