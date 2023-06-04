package testes;

public class TesteArrayString {
	public static void main(String[] args) { // podemos passar parâmetros para args na execução do programa
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("Funcionou!");
	}
}
