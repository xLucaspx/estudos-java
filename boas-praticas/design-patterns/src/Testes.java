import java.math.BigDecimal;

import desconto.CalculadoraDesconto;
import imposto.CalculadoraImposto;
import imposto.ICMS;
import imposto.ISS;
import orcamento.Orcamento;
import pedido.GeraPedido;
import pedido.GeraPedidoHandler;

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

    orcamento1.aprovar();
    orcamento3.reprovar();

    orcamento1.aplicarDescontoExtra();
    orcamento2.aplicarDescontoExtra();
    orcamento3.aplicarDescontoExtra();

    System.out.println(String.format("Valor 1 após desconto extra R$ %.2f", orcamento1.getValor())); // aprovado: 2%
    System.out.println(String.format("Valor 2 após desconto extra R$ %.2f", orcamento2.getValor())); // em analise: 5%
    System.out.println(String.format("Valor 3 após desconto extra R$ %.2f", orcamento3.getValor())); // reprovado: 0

    orcamento2.aprovar();

    orcamento1.finalizar();
    orcamento2.finalizar();
    orcamento3.finalizar();

    String cliente = "Wilmur Machado";
    BigDecimal valor = BigDecimal.valueOf(600);
    int quantidadeItens = 4;

    GeraPedido geradorPedido = new GeraPedido(cliente, valor, quantidadeItens);
    GeraPedidoHandler handler = new GeraPedidoHandler(/* repository/dao, services, etc */);
    handler.executa(geradorPedido);
  }
}
