package app;

import exercicios.lista1.*;
import model.RunnableExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.util.Map.entry;

public class App {
	private static final String MENU_PROMPT = "O que você deseja executar? ";
	private static final String CONTINUE_PROMPT = "Digite S para continuar... ";

	public static void main(String[] args) {
		var opcoes = new TreeMap<>(Map.ofEntries(
			entry(1, TiposPrimitivos.class),
			entry(2, DiferencaArredondamento.class),
			entry(3, CalculadoraAreaEsfera.class),
			entry(4, CalculadoraPotencia.class),
			entry(5, ConversorTemperatura.class),
			entry(6, Calculadora.class),
			entry(7, CalculadoraAreaTerreno.class),
			entry(8, CalculadoraAltura.class),
			entry(9, CalculadoraTempo.class),
			entry(10, InversorNumero.class),
			entry(11, CalculadoraDinheiro.class),
			entry(12, CalculadoraPascoa.class),
			entry(13, CalculadoraSegundos.class),
			entry(14, ExercicioEscada.class),
			entry(15, CalculadoraVolumeGarrafa.class),
			entry(16, CalculaDigitoVerificadorConta.class),
			entry(17, CalculaNotaAtleta.class)
		));

		var run = true;
		try (var in = new Scanner(System.in)) {

			var menu = App.criaMenu(opcoes);

			do {
				try {
					System.out.println(menu);
					System.out.print(MENU_PROMPT);
					var opcao = Integer.parseInt(in.nextLine());

					if (!opcoes.containsKey(opcao)) {
						throw new IllegalArgumentException("Não há opção especificada para o valor " + opcao);
					}

					opcoes.get(opcao).getDeclaredConstructor().newInstance().run(in);

					System.out.print(CONTINUE_PROMPT);
					var res = in.nextLine();

					if (!res.equalsIgnoreCase("s")) {
						run = false;
					}

				} catch (NumberFormatException e) {
					System.err.println("Valor inválido!");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} while (run);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro inesperado durante a execução do programa: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Programa finalizado!");
		System.exit(0);
	}

	private static String criaMenu(Map<Integer, Class<? extends RunnableExercise>> params) throws Exception {
		StringBuilder menu = new StringBuilder("\n"); // quebra de linha

		for (var param : params.entrySet()) {
			var exercise = param.getValue().getDeclaredConstructor().newInstance();
			menu.append("[%2d] %s%n".formatted(param.getKey(), exercise));
		}

		return menu.toString();
	}
}
