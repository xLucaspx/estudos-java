package models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@EmbeddedId
	private CategoriaId id;

	public Categoria() {}

	public Categoria(String nome, String tipo) {
		this.id = new CategoriaId(nome, tipo);
	}

	public CategoriaId getId() {
		return id;
	}

	public String getNome() {
		return id.nome();
	}

	public String getTipo() {
		return id.tipo();
	}

	@Override
	public String toString() {
		return String.format("categoria: { nome: \"%s\", tipo: \"%s\" }", getNome(), getTipo());
	}
}
