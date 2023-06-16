package models;

import java.time.LocalDate;

public class Revista extends Publicacao {
	private int numero;

	public Revista(String titulo, LocalDate dataPublicacao, TipoPublicacao tipoPublicacao, int numero) {
		super(titulo, dataPublicacao, tipoPublicacao);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return String.format("\n%s\nNúmero: %d\n", super.toString(), numero);
	}
}
