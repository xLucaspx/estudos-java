package testes;

import models.Consultor;
import models.ControleBonificacao;
import models.Designer;
import models.Diretor;
import models.Funcionario;
import models.Gerente;
import models.SistemaInterno;

// testes.TestesFuncionarios -> qualified name
public class TestesFuncionarios {
	public static void main(String[] args) {
		System.out.println("Testes de herança e polimorfismo - funcionários");

		// Instanciando funcionários:

		// Funcionario emp1 = new Funcionario("Rodrigo", "778.544.123-69", 3500);
		// Funcionário é uma classe abstrata, ou seja, não pode mais ser instanciada

		// Funcionários autenticáveis:
		Diretor diretor1 = new Diretor("Nelson", "963.852.741-00", 6200.00);
		Gerente gerente1 = new Gerente("Luciano", "998.665.321-02", 5600.00);

		// Funcionários comuns:
		Consultor consultor1 = new Consultor("Marcio", "789.547.896-33", 4750.00);
		Designer designer1 = new Designer("Everton", "854.258.456-96", 3250.00);

		// Exibindo informações dos funcionários:
		System.out.println("Funcionários:");

		// System.out.println("Funcionário: " + emp1.getNome() + " salário R$ " +
		// emp1.getSalario() + " bonificação R$ " + emp1.getBonificacao());

		System.out.println("Diretor: " + diretor1.getNome() + " salário R$ " + diretor1.getSalario()
				+ " bonificação R$ " + diretor1.getBonificacao());

		System.out.println("Gerente: " + gerente1.getNome() + " salário R$ " + gerente1.getSalario()
				+ " bonificação R$ " + gerente1.getBonificacao());

		System.out.println("Consultor: " + consultor1.getNome() + " salário R$ " + consultor1.getSalario()
				+ " bonificação R$ " + consultor1.getBonificacao());

		System.out.println("Designer: " + designer1.getNome() + " salário R$ " + designer1.getSalario()
				+ " bonificação R$ " + designer1.getBonificacao());

		// Testando controle de bonificação:

		ControleBonificacao controleBonificacao = new ControleBonificacao();

		// controleBonificacao.registraBonificacao(emp1);
		controleBonificacao.registraBonificacao(gerente1);
		controleBonificacao.registraBonificacao(consultor1);
		controleBonificacao.registraBonificacao(designer1);

		System.out.println("Controle de bonificação: R$ " + controleBonificacao.getSoma());

		// Testando sistema interno

		SistemaInterno sistema = new SistemaInterno(8520);

		diretor1.setSenha(8520);
		gerente1.setSenha(0123);

		sistema.autentica(diretor1); // senha correta
		sistema.autentica(gerente1); // senha incorreta

		System.out.println("Total de funcionários: " + Funcionario.getTotalDeFuncionarios());
	}
}
