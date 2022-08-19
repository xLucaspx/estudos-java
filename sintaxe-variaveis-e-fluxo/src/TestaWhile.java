
public class TestaWhile {
	public static void main(String[] args) {
		int i = 0;

		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}		
		System.out.println("Contador: " + i); //contador continua acessível após o while (!= for)
	}
}
