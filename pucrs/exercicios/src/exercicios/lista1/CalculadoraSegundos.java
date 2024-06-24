package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraSegundos extends RunnableExercise {
	private static final int SEGUNDOS_POR_DIA = 86400;
	private static final int SEGUNDOS_POR_HORA = 3600;
	private static final int SEGUNDOS_POR_MINUTO = 60;

	public CalculadoraSegundos() {
		super("Lista I", 15, "Quantos segundos para o dia acabar");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);

		var regex = "^([01]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		var pattern = Pattern.compile(regex);
		Matcher matcher;

		int horas;
		int minutos;
		int segundos;

		String tempo;

		do {
			System.out.println(
				"\nVamos converter um tempo no formato hh:MM:ss para segundos e calcular quantos segundos flatam para o fim " + "do" + " dia");

			System.out.print("Digite o tempo no formato hh:MM:ss (24h): ");
			tempo = in.nextLine();

			matcher = pattern.matcher(tempo);

			if (!matcher.matches()) {
				System.err.println("O tempo inserido não é válido! São permitidos valores de 00:00:00 a 23:59:59");
				tempo = null;
			}
		} while (tempo == null);

		horas = Integer.parseInt(matcher.group(1));
		minutos = Integer.parseInt(matcher.group(2));
		segundos = Integer.parseInt(matcher.group(3));

		var totalSegundos = converteTempoParaSegundos(horas, minutos, segundos);
		System.out.printf("%n%s em segundos = %d%n", tempo, totalSegundos);
		System.out.printf("segundos até o fim do dia = %d%n%n", segundosAteFimDoDia(totalSegundos));
	}

	private int converteTempoParaSegundos(int horas, int minutos, int segundos) {
		int total = segundos;
		total += horas * SEGUNDOS_POR_HORA;
		total += minutos * SEGUNDOS_POR_MINUTO;

		return total;
	}

	private int segundosAteFimDoDia(int tempoEmSegundos) {
		return SEGUNDOS_POR_DIA - tempoEmSegundos;
	}
}
