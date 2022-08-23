
public class Fluxo {
	public static void main(String[] args) {
		System.out.println("Início do main");
		
		try {
			metodo1();			
		} catch (Exception e) { // alguns metodos das exceptions:
			String mensagem = e.getMessage();
			System.out.println("Exception: " + mensagem);
			e.printStackTrace();
		}
		
		System.out.println("Fim do main");
	}

	private static void metodo1() throws MinhaException { // throws pq MinhaExeption é checked
		System.out.println("Início do metodo1");
		metodo2();
		System.out.println("Fim do metodo1"); // linha não é executada pois o try-catch está no main, então esta linha é removida da stack sem executar
	  }

	private static void metodo2() throws MinhaException {
		System.out.println("Início do metodo2");
		throw new MinhaException("Deu erro...");

//		for (int i = 1; i <= 5; i++) {
//			System.out.print(i + " "); 
//			System.out.println(1 / 0); // ArithmeticException
//		}
//		System.out.println("");
//		System.out.println("Fim do metodo2"); // linhas após a exceção não podem ser lidas, logo o código não compila se não estiverem comentadas
	}
}
