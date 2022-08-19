
public class TestaLacos2 {
	public static void main(String[] args) {
		for (int linha = 0; linha < 10; linha++) {
			
//			for (int coluna = 0; coluna < 10; coluna++) {
//				if (coluna == linha) break; //para escrever um asterisco a mais que a linha anterior
// 			O código comentado acima pode ser substituido por:
				
			for (int coluna = 0; coluna <= linha; coluna ++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
