package exercicios.lista1;

import model.RunnableExercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraPascoa extends RunnableExercise {
	public CalculadoraPascoa() {
		super("Lista I", 14, "Calcula o domingo de páscoa com base no ano");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer ano = null;

		do {
			try {
				System.out.println("""

					O domingo de Páscoa é o primeiro domingo após a primeira lua cheia do equinócio de outono no Hemisfério Sul.
					Vamos calcular a data da Páscoa a partir do ano com o algoritmo inventado pelo matemático Carl Friedrich Gauss em 1800""");

				System.out.print("Digite o ano: ");
				ano = Integer.parseInt(in.nextLine());

				/* O Algoritmo Computacional de Gauss para calcular a data da Páscoa possui algumas limitações. Em particular,
				 o algoritmo foi projetado para calcular a data da Páscoa para anos entre 1583 e 4099, pois esses são os
				 limites para os quais o calendário gregoriano, usado no algoritmo, foi reformado. */
				if (ano < 1583 || ano > 4099) {
					System.err.println("O valor deve estar entre 1583 e 4099!");

					ano = null;
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (ano == null);

		System.out.printf("%nPáscoa em: %n%s%n", gaussEasterAlgorithm(ano));
	}

	private String gaussEasterAlgorithm(int ano) {
		var a = ano % 19;
		var b = ano / 100;
		var c = ano % 100;
		var d = b / 4;
		var e = b % 4;
		var g = (8 * b + 13) / 25;
		var h = (19 * a + b - d - g + 15) % 30;
		var j = c / 4;
		var k = c % 4;
		var m = (a + 11 * h) / 319;
		var r = (2 * e + 2 * j - k - h + m + 32) / 7;
		var mes = (h - m + r + 90) / 25; // mês
		var dia = (h - m + r + mes + 19) % 32; // dia

		var data = LocalDateTime.of(ano, mes, dia, 0, 0);
		var strData = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		var extensoData = data.format(DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy", Locale.of("pt", "BR")));

		return "%s (%s)%n".formatted(strData, extensoData);
	}
}
