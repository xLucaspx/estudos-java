package app;

import static exercicios.Calculadora.*;
import static exercicios.IntervalosPrimitivos.*;
import static exercicios.ConversorTemperatura.*;
import static exercicios.DiferencaArredondamento.exibeDiferencaArredondamento;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		System.out.println(converteFahrenheitParaCelsius(0));
		System.out.println(converteCelsiusParaFahrenheit(0));

		System.out.println(calculaAreaEsfera(2));

		exibeDiferencaArredondamento(1.4, 5.8);

		System.exit(0);

		exibeIntervaloByte();
		exibeIntervaloShort();
		exibeIntervaloInt();
		exibeIntervaloLong();
		exibeIntervaloFloat();
		exibeIntervaloDouble();
		exibeIntervaloBoolean();
		exibeIntervaloChar();

		System.exit(0);

		var continuar = true;
		try (var in = new Scanner(System.in)) {
			do {
				Double x = null;
				Double y = null;

				do {
					try {
						System.out.print("Digite o primeiro valor: ");
						x = Double.parseDouble(in.nextLine());

						System.out.print("Digite o segundo valor: ");
						y = Double.parseDouble(in.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Valor inválido inserido!");
					}
				} while (x == null || y == null);


				System.out.printf("%.1f + %.1f = %.1f%n", x, y, soma(x, y));
				System.out.printf("%.1f - %.1f = %.1f%n", x, y, subtrai(x, y));
				System.out.printf("Média de %.1f e %.1f = %.1f%n", x, y, calculaMedia(x, y));
				System.out.printf("Maior entre %.1f e %.1f = %.1f%n", x, y, retornaMaior(x, y));
				System.out.printf("Menor entre %.1f e %.1f = %.1f%n", x, y, retornaMenor(x, y));

				System.out.print("Digite S para continuar... ");
				var res = in.nextLine();

				if (!res.equalsIgnoreCase("s")) continuar = false;


			} while (continuar);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro durante a execução do programa:");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
