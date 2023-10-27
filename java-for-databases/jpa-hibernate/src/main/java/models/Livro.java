package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Produto {
	private String autor;
	private int numeroDePaginas;

	public Livro() {}

	public Livro(String autor, int numeroDePaginas) {
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
}
