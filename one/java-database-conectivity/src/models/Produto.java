package models;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;
	private Integer categoriaId;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(String nome, String descricao, Integer categoriaId) {
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public Produto(Integer id, String nome, String descricao, Integer categoriaId) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	@Override
	public String toString() {
		return String.format("id: %3d | nome: %s \ndescrição: %s \n--------------------------------------------------",
				this.id, this.nome, this.descricao);
	}
}
