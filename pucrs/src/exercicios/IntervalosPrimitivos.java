package exercicios;

public class IntervalosPrimitivos {
	public static void exibeIntervaloByte() {
		System.out.printf(
			"O tipo byte utiliza %d bits (%d byte, obviamente) e consegue representar valores inteiros de %d a %d%n",
			8 * Byte.BYTES,
			Byte.BYTES,
			Byte.MIN_VALUE,
			Byte.MAX_VALUE
		);
	}

	public static void exibeIntervaloShort() {
		System.out.printf("O tipo short utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n",
			8 * Short.BYTES,
			Short.BYTES,
			Short.MIN_VALUE,
			Short.MAX_VALUE
		);
	}

	public static void exibeIntervaloInt() {
		System.out.printf("O tipo int utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n",
			8 * Integer.BYTES,
			Integer.BYTES,
			Integer.MIN_VALUE,
			Integer.MAX_VALUE
		);
	}

	public static void exibeIntervaloLong() {
		System.out.printf("O tipo long utiliza %d bits (%d bytes) e consegue representar valores inteiros de %d a %d%n",
			8 * Long.BYTES,
			Long.BYTES,
			Long.MIN_VALUE,
			Long.MAX_VALUE
		);
	}

	public static void exibeIntervaloFloat() {
		System.out.printf(
			"O tipo float utiliza %d bits (%d bytes) e consegue representar valores reais com precisão simples de %.2f a %.2f%n",
			8 * Float.BYTES,
			Float.BYTES,
			Float.MIN_VALUE,
			Float.MAX_VALUE
		);
	}

	public static void exibeIntervaloDouble() {
		System.out.printf(
			"O tipo double utiliza %d bits (%d bytes) e consegue representar valores reais com precisão dupla de %.2f a %" +
				".2f%n",
			8 * Double.BYTES,
			Double.BYTES,
			Double.MIN_VALUE,
			Double.MAX_VALUE
		);
	}

	public static void exibeIntervaloBoolean() {
		System.out.println("O tipo boolean utiliza 1 bit e representa os valores false (0) ou true (1)");
	}

	public static void exibeIntervaloChar() {
		System.out.printf(
		"O tipo char utiliza %d bits (%d bytes) e representa caracteres Unicode; seu valor mínimo é \\u0000 (ou 0) e seu valores máximo é \\uffff (ou 65535)",
			8 * Character.BYTES,
			Character.BYTES
		);
	}
}
