package curso;

public class EscreveFatoriais {
	public static void main(String[] args) {
		int fatorial = 1;
		for (int i = 1; i <= 10; i++) {
			fatorial *= i;
			System.out.println("Fatorial de " + i + ": " + fatorial);
		}
	}
}

// O fatorial de um número n é n * n-1 * n-2 ... até n = 1.
// Ou seja:
// O fatorial de 4! = 1 x 2 x 3 x 4 = 24
// O fatorial de 6! = 1 x 2 x 3 x 4 x 5 x 6 = 720
