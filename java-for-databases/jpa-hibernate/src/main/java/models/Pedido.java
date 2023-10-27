package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente; // o Hibernate, por padrão, cria as colunas de relacionamentos com a sintaxe snake_case (cliente_id)

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {};

	public Pedido(long id, Cliente cliente, LocalDate data) {
		this.id = id;
		this.cliente = cliente;
		this.data = data;
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionaItem(Produto produto, int quantidade) {
		ItemPedido item = new ItemPedido(quantidade, this, produto);
		itens.add(item);
		this.valorTotal = valorTotal.add(item.getValorTotal());
	}

	public long getId() {
		return id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return """
			pedido: {
				id: %d,
				valorTotal: "R$ %.2f",
				data: "%s",
				%s
			}
			""".formatted(id, valorTotal, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data), cliente);
	}
}
