package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Publicacao {
	private String titulo;
	private LocalDate dataPublicacao;
	private TipoPublicacao tipoPublicacao;

	public Publicacao(String titulo, LocalDate dataPublicacao, TipoPublicacao tipoPublicacao) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.tipoPublicacao = tipoPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDataPublicacao() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataPublicacao);
	}

	public TipoPublicacao getTipoPublicacao() {
		return tipoPublicacao;
	}

	@Override
	public String toString() {
		return String.format("Título: %s\nTipo: %s\nData publicação: %s", titulo, tipoPublicacao, getDataPublicacao());
	}
}
