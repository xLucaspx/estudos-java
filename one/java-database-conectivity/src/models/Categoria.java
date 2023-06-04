package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public String toString() {
		return String.format("Id %3d | %s", this.id, this.nome);
	}
}
