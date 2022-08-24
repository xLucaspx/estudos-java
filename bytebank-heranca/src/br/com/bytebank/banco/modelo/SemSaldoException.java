package br.com.bytebank.banco.modelo;

public class SemSaldoException extends Exception { // checked
	
	public SemSaldoException(String mensagem) {
		super(mensagem);
	}
}
