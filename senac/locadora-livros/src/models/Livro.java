package models;

import java.time.LocalDate;

public class Livro extends Publicacao {
	private int edicao;
	private String isbn;
	private int numPaginas;
	private String autor;

	public Livro(String titulo, LocalDate dataPublicacao, TipoPublicacao tipoPublicacao, int edicao, int nPaginas,
			String autor) {
		super(titulo, dataPublicacao, tipoPublicacao);
		this.edicao = edicao;
		this.numPaginas = nPaginas;
		this.autor = autor;
	}

	public int getEdicao() {
		return edicao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public String getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return String.format("\n%s\nEdição: %d\nN° de páginas: %d\nAutor: %s\nISBN: %s\n", super.toString(), edicao, numPaginas,
				autor, (isbn != null ? isbn : "não cadastrado"));
	}
}
