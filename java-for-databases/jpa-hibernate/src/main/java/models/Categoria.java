package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;

	public Categoria() {}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return String.format("categoria: { id: %d, nome: \"%s\" }", id, nome);
	}
}
