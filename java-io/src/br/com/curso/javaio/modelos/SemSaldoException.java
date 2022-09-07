package br.com.curso.javaio.modelos;

public class SemSaldoException extends Exception { // checked
	
	private static final long serialVersionUID = 1L;

	public SemSaldoException(String mensagem) {
		super(mensagem);
	}
}
