package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

/**
 * Faça um programa que leia a capacidade (em litros) do tanque de um
 * carro, o seu consumo médio (km/litro) e a distância (em km) que esse
 * carro precisa percorrer. O programa deve calcular e escrever tantas vezes
 * será necessário parar para abastecer para que o carro consiga percorrer a
 * distância informada.
 */
public class ExercicioCarro extends RunnableExercise {

	public ExercicioCarro() {
		super("Lista I", 20, "Calcula quantas vezes será necessário abastecer um veículo");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		var capacidadeLitros = 0.0;
		var consumoMedioKmL = 0.0;
		var distanciaKm = 0.0;
		var validData = false;

		do {
			try {
				System.out.println("""
					Vamos calcular quantas vezes será necessário abastecer o veículo em um determinado trajeto...
					Partiremos do pressuposto que o tanque está vazio!
					""");

				System.out.print("Digite a capacidade do tanque do veículo (litros): ");
				capacidadeLitros = leDoubleMaiorQue0(in);

				System.out.print("Digite o consumo médio do veículo (Km/l): ");
				consumoMedioKmL = leDoubleMaiorQue0(in);

				System.out.print("Digite a distância a ser percorrida pelo veículo (Km): ");
				distanciaKm = leDoubleMaiorQue0(in);

				validData = true;
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		var combustivelNecessario = distanciaKm / consumoMedioKmL;
		var tanquesNecessarios = combustivelNecessario / capacidadeLitros;
		var quantidadeAbastecimentos = (int) Math.ceil(tanquesNecessarios);

		System.out.printf("%nPara completar o trajeto serão necessários %.2f l de combustível%n", combustivelNecessario);
		System.out.printf("isso equivale a %.2f tanques de combustível de %.2f l%n", tanquesNecessarios, capacidadeLitros);
		System.out.printf("ou seja, será necessário abastecer %d vezes%n%n", quantidadeAbastecimentos);
	}

	private double leDoubleMaiorQue0(Scanner in) {
		var numero = Double.parseDouble(in.nextLine());

		if (numero <= 0) {
			throw new IllegalArgumentException("Os valores devem ser maiores do que 0");
		}

		return numero;
	}
}
