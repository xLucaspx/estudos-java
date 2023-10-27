package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "informatica")
public class Informatica extends Produto {
	private String autor;
	private String modelo;

	public Informatica() {}

	public Informatica(String autor, String modelo) {
		this.autor = autor;
		this.modelo = modelo;
	}

	public String getAutor() {
		return autor;
	}

	public String getModelo() {
		return modelo;
	}
}
