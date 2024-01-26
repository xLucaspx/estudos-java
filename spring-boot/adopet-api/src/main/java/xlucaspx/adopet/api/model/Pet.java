package xlucaspx.adopet.api.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;

@Entity
@Table(name = "pets")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoPet tipo;

	private String nome;
	private String raca;
	private Integer idade;
	private String cor;
	private Float peso;
	private Boolean adotado;

	@ManyToOne(fetch = FetchType.LAZY)
	private Abrigo abrigo;

	@OneToOne(mappedBy = "pet", fetch = FetchType.LAZY)
	private Adocao adocao;
	
	public Pet() {}
	
	public Pet(CadastroPetDto dto) {
		setNome(dto.nome());
		setRaca(dto.raca());
		setCor(dto.cor());
		setIdade(dto.idade());
		setPeso(dto.peso());
		setTipo(dto.tipo());
		setAdotado(false);
	}

	public Long getId() {
		return id;
	}

	public TipoPet getTipo() {
		return tipo;
	}

	public void setTipo(TipoPet tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Boolean isAdotado() {
		return adotado;
	}

	public void setAdotado(Boolean adotado) {
		this.adotado = adotado;
	}

	public Abrigo getAbrigo() {
		return abrigo;
	}

	public void setAbrigo(Abrigo abrigo) {
		this.abrigo = abrigo;
	}

	public Adocao getAdocao() {
		return adocao;
	}

	public void setAdocao(Adocao adocao) {
		this.adocao = adocao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pet pet = (Pet) o;
		return Objects.equals(id, pet.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
