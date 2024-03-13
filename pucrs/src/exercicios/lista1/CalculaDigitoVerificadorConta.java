package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculaDigitoVerificadorConta extends RunnableExercise {
	public CalculaDigitoVerificadorConta() {
		super("Lista I", 18, "Calcular odígito verificador de uma conta");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer conta = null;

		do {
			try {
				System.out.println(
					"\nVamos calcular o dígito verificador de uma conta; para isso, iremos inverter os dígitos, somá-los com o " + "número da conta e, deste valor, iremos multiplicar cada número pela sua posição e o último dígito desta " + "multiplicação será o dígito verificador!");

				System.out.print("Digite o número da conta: ");
				conta = Integer.parseInt(in.nextLine());

				if (conta < 100) {
					System.err.println("O número da conta deve ter pelo menos três dígitos!");
					conta = null;
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (conta == null);

		System.out.printf("%nConta: %d.%d%n%n", conta, calculaDigitoVerificadorConta(conta));
	}

	private int calculaDigitoVerificadorConta(int conta) {
		var inversoStr = new StringBuilder(String.valueOf(conta)).reverse();
		var inverso = Integer.parseInt(inversoStr.toString());
		var soma = String.valueOf(conta + inverso);
		var checksum = 0;

		for (var i = 0; i < soma.length(); i++) {
			checksum += (soma.charAt(i) - '0') * (i + 1);
		}

		return checksum % 10;
	}
}
