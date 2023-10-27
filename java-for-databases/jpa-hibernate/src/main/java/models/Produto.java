package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();
	// a JPA já entende que é um relacionamento entre duas entidades, devemos apenas dizer a cardinalidade:
	@ManyToOne(fetch = FetchType.LAZY) // um produto tem uma categoria, categorias podem ter vários produtos
	private Categoria categoria;

	public Produto() {};

	public Produto(long id, String nome, String descricao, BigDecimal preco, Categoria categoria,
			LocalDate dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.dataCadastro = dataCadastro;
	}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return """
			produto: {
				id: %d,
				nome: "%s",
				descricao: "%s",
				preco: "R$ %.2f",
				dataCadastro: "%s",
				%s
			}
			""".formatted(id, nome, descricao, preco, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataCadastro),
				categoria);
	}
}
