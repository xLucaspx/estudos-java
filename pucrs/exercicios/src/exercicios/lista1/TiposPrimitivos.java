package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class TiposPrimitivos extends RunnableExercise {

	public TiposPrimitivos() {
		super("Lista I", 1, "Tipos primitivos");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		System.out.println("\nA linguagem Java possui 8 tipos primitivos e seus respectivos wrappers; são eles:\n");
		exibeIntervaloByte();
		exibeIntervaloShort();
		exibeIntervaloInt();
		exibeIntervaloLong();
		System.out.println("""
			Diferentemente dos números inteiros, os números reais utilizam um bit para o sinal e o restantes para representar o número,
			o que faz com que seus valores mínimo e máximo sejam os mesmos, apenas com sinais diferentes!
			""");
		exibeIntervaloFloat();
		exibeIntervaloDouble();
		exibeIntervaloBoolean();
		exibeIntervaloChar();
	}

	private void exibeIntervaloByte() {
		System.out.printf(
			"O tipo byte (Byte) utiliza %d bits (%d byte, obviamente) e consegue representar valores inteiros de %d a " +
			"%d%n%n",
			8 * Byte.BYTES,
			Byte.BYTES,
			Byte.MIN_VALUE,
			Byte.MAX_VALUE
		);
	}

	private void exibeIntervaloShort() {
		System.out.printf(
			"O tipo short (Short) utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n%n",
			8 * Short.BYTES,
			Short.BYTES,
			Short.MIN_VALUE,
			Short.MAX_VALUE
		);
	}

	private void exibeIntervaloInt() {
		System.out.printf(
			"O tipo int (Integer) utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n%n",
			8 * Integer.BYTES,
			Integer.BYTES,
			Integer.MIN_VALUE,
			Integer.MAX_VALUE
		);
	}

	private void exibeIntervaloLong() {
		System.out.printf(
			"O tipo long (Long) utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n%n",
			8 * Long.BYTES,
			Long.BYTES,
			Long.MIN_VALUE,
			Long.MAX_VALUE
		);
	}

	private void exibeIntervaloFloat() {
		System.out.printf(
			"O tipo float (Float) utiliza %d bits (%d bytes) e consegue representar valores reais (positivos ou negativos) " +
			"com precisão simples até %.2f%n%n",
			8 * Float.BYTES,
			Float.BYTES,
			Float.MAX_VALUE
		);
	}

	private void exibeIntervaloDouble() {
		System.out.printf(
			"O tipo double (Double) utiliza %d bits (%d bytes) e consegue representar valores reais (positivos ou negativos)"
			+ " com precisão dupla até %.2f%n%n",
			8 * Double.BYTES,
			Double.BYTES,
			Double.MAX_VALUE
		);
	}

	private void exibeIntervaloBoolean() {
		System.out.println("O tipo boolean (Boolean) utiliza 1 bit e representa os valores false (0) ou true (1)\n\n");
	}

	private void exibeIntervaloChar() {
		System.out.printf(
			"O tipo char (Character) utiliza %d bits (%d bytes) e representa caracteres Unicode; seu valor mínimo é \\u0000 "
			+ "(ou 0) e seu" + " valores máximo é \\uffff (ou 65535)%n%n",
			8 * Character.BYTES,
			Character.BYTES
		);
	}
}
