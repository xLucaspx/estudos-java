package models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;
	private int quantidade;

	// É uma boa prática sempre alterar o carregamento dos relacionamentos toOne para Lazy:
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;

	public ItemPedido() {}

	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.valorUnitario = produto.getPreco();
	}

	public ItemPedido(long id, BigDecimal valorUnitario, int quantidade, Pedido pedido, Produto produto) {
		this.id = id;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.valorUnitario = produto.getPreco();
	}

	public long getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorUnitario.multiply(new BigDecimal(quantidade));
	}
}
