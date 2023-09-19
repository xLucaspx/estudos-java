import java.math.BigDecimal;

import desconto.CalculadoraDesconto;
import imposto.CalculadoraImposto;
import imposto.ICMS;
import imposto.ISS;
import orcamento.Orcamento;

public class Testes {
  public static void main(String... args) {
    Orcamento orcamento1 = new Orcamento(BigDecimal.valueOf(100.0), 1);
    Orcamento orcamento2 = new Orcamento(BigDecimal.valueOf(700.0), 4);
    Orcamento orcamento3 = new Orcamento(BigDecimal.valueOf(300.0), 6);

    CalculadoraImposto calculadoraImposto = new CalculadoraImposto();

    BigDecimal iss = calculadoraImposto.calcula(orcamento1, new ISS());
    BigDecimal icms = calculadoraImposto.calcula(orcamento1, new ICMS());

    System.out.println(String.format("ISS: R$ %.2f", iss)); // 6%
    System.out.println(String.format("ICMS: R$ %.2f", icms)); // 10%

    CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

    BigDecimal desconto1 = calculadoraDesconto.calcula(orcamento1); // 0
    BigDecimal desconto2 = calculadoraDesconto.calcula(orcamento2); // 5%
    BigDecimal desconto3 = calculadoraDesconto.calcula(orcamento3); // 10%

    System.out.println(String.format("Desconto orçamento 1: R$ %.2f", desconto1));
    System.out.println(String.format("Desconto orçamento 2: R$ %.2f", desconto2));
    System.out.println(String.format("Desconto orçamento 3: R$ %.2f", desconto3));
  }
}
