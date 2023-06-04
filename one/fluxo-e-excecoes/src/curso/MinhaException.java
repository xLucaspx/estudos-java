package curso;

public class MinhaException extends Exception { // checked (para ser unchecked deveria extender "RuntimeException")
	public MinhaException(String mensagem) {
		super(mensagem);
	}
}
