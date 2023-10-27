package vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// VO: Value Object, classe sem comportamentos, apenas para guardar informações
public class RelatorioDeVendasVo {

	private String nomeProduto;
	private long quantidadeVendida;
	private LocalDate ultimaVenda;

	public RelatorioDeVendasVo(String nomeProduto, long quantidadeVendida, LocalDate ultimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.ultimaVenda = ultimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getUltimaVenda() {
		return ultimaVenda;
	}

	@Override
	public String toString() {
		return """
			{ produto: "%s", quantidadeVendida: %d, ultimaVenda: "%s" }
			""".formatted(nomeProduto, quantidadeVendida, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(ultimaVenda));
	}
}
