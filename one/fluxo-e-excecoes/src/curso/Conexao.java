package curso;

public class Conexao implements AutoCloseable { // Autocloseable para poder utilizar try-with-resources
	public Conexao() {
		System.out.println("Abrindo conexão");
		// throw new IllegalStateException(); // erros para fins didáticos
	}

	public void leDados() {
		System.out.println("Recebendo dados");
		throw new IllegalStateException();
	}

	@Override
	public void close() { // throws Exception é opcional
		System.out.println("Fechando conexão");
	}

	// método substituido por close() (acima) para usar a interface AutoCloseable:
	// public void fecha() {
	// System.out.println("Fechando conexão");
	// }
}
