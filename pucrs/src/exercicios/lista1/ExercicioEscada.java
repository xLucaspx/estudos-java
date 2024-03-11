package exercicios.lista1;

import java.util.Scanner;

import model.RunnableExercise;

public class ExercicioEscada extends RunnableExercise {
	
  private static final double ALTURA_MINIMA_PESSOA = 1.0;
  private static final double ALTURA_MAXIMA_PESSOA = 2.3;

	public ExercicioEscada() {
		super("Lista I", 16, "Calcular altura de uma pessoa em determinada escada");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);

		var quantidadeDegraus = 0;
		var alturaDegraus = 0.0;

		var alturaAtual = 0.0;
		var alturaDesejada = 0.0;
		
		var validData = false;

		do {
			try {
				System.out.println(
						"\nVamos calcular, com base na altura e quantidade de degraus desta escada, quantos degraus uma pessoa precisa subir "
						+ "para atingir determinada altura e qual a altura máxima que pode ser atingida");
				
				System.out.println("Dimensões da escada");

				System.out.print("Quantidade de degraus: ");
				quantidadeDegraus = Integer.parseInt(in.nextLine());
				
				if (quantidadeDegraus <= 0) {
					throw new IllegalArgumentException("A quantidade de degraus deve ser maior do que 0!");
				}
				
				System.out.print("Altura de cada degrau (metros): ");
				alturaDegraus = Double.parseDouble(in.nextLine());
				
				if (alturaDegraus <= 0) {
					throw new IllegalArgumentException("A altura de cada degrau deve ser maior do que 0!");
				}

				System.out.println("\nDimensões da pessoa");

				System.out.print("Altura atual (metros): ");
				alturaAtual = Double.parseDouble(in.nextLine());
				
				if (alturaAtual < ALTURA_MINIMA_PESSOA || alturaAtual > ALTURA_MAXIMA_PESSOA) {
					throw new IllegalArgumentException("A altura atual deve estar entre %.2f m e %.2f m!".formatted(ALTURA_MINIMA_PESSOA, ALTURA_MAXIMA_PESSOA));
				}
				
				System.out.print("Altura desejada (metros): ");
				alturaDesejada = Double.parseDouble(in.nextLine());
				
				if (alturaDesejada < alturaAtual) {
					throw new IllegalArgumentException("A altura desejada não pode ser menor do que a altura atual!");
				}
				
				validData = true; // se chegar até aqui, os dados são válidos
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		var alturaEscada = alturaDegraus * quantidadeDegraus;
		var degrausParaAlturaDesejada = Math.ceil((alturaDesejada - alturaAtual) / alturaDegraus); 
		var alturaMaxima = alturaAtual + alturaEscada;
		
		var msg = "Para atingir a altura desejada, ";
		msg += degrausParaAlturaDesejada > quantidadeDegraus
				? "seria preciso subir %.0f degraus, %d a mais do que a escada possui".formatted(degrausParaAlturaDesejada, Math.round(degrausParaAlturaDesejada - quantidadeDegraus))
				: "será necessário subir %.0f degraus da escada".formatted(degrausParaAlturaDesejada);
		msg += ", atingindo uma altura de %.2f m%n%n".formatted((degrausParaAlturaDesejada * alturaDegraus + alturaAtual));
		
		System.out.printf("%nAltura atual = %.2f m%n", alturaAtual);
		System.out.printf("Altura desejada = %.2f m%n", alturaDesejada);
		System.out.printf("Altura da escada = %.2f m%n", alturaEscada);
		System.out.printf("Altura máxima possível = %.2f m%n", alturaMaxima);
		System.out.printf(msg);
	}
}
