package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Locacao {
	private LocalDate inicioLocacao;
	private LocalDate dataFinalizacao;
	private Leitor leitor;
	private float valorDiario;
	private float valorTotal;
	private ArrayList<Publicacao> publicacoes;

	public Locacao(LocalDate inicioLocacao, Leitor leitor, float valorDiario) {
		this.inicioLocacao = inicioLocacao;
		setLeitor(leitor);
		setValorDiario(valorDiario);
		this.publicacoes = new ArrayList<>();
	}

	public String getInicioLocacao() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(inicioLocacao);
	}

	public Leitor getLeitor() {
		return leitor;
	}

	private void setLeitor(Leitor leitor) {
		if (leitor == null)
			throw new IllegalArgumentException("Você deve definir um leitor para a locação!");

		this.leitor = leitor;
	}

	public float getValorDiario() {
		return valorDiario;
	}

	private void setValorDiario(float valorDiario) {
		if (valorDiario <= 0)
			throw new IllegalArgumentException("O valor diário deve ser maior que 0!");

		this.valorDiario = valorDiario;
	}

	public List<Publicacao> getPublicacoes() {
		return Collections.unmodifiableList(publicacoes);
	}

	public boolean addPublicacao(Publicacao publicacao) {
		return publicacoes.add(publicacao);
	}

	private String listaPublicacoes() {
		int i = 1;
		String publicacoes = "";

		for (Publicacao p : this.publicacoes) {
			publicacoes += String.format("%d:%s\n", i, p);
			i++;
		}

		return (publicacoes.isEmpty() ? "Ainda não foram adicionadas publicações!" : publicacoes);
	}

	public float encerraLocacao(LocalDate dataFinalizacao) {
		if (dataFinalizacao.isBefore(inicioLocacao))
			throw new IllegalArgumentException("A data de finalização não pode ser anterior a data de início da locação!");

		if (publicacoes.isEmpty())
			throw new IllegalArgumentException("Não foi possível finalizar a locação: nenhuma publicação foi locada!");

		long dias = ChronoUnit.DAYS.between(inicioLocacao, dataFinalizacao);
		float total = dias * valorDiario;

		this.dataFinalizacao = dataFinalizacao;
		this.valorTotal = total;

		return total;
	}

	public String getDataFinalizacao() {
		if (dataFinalizacao != null)
			return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataFinalizacao);
		else
			return "Locação está ativa!";
	}

	public float getValorTotal() {
		if (valorTotal > 0)
			return valorTotal;
		else
			return (ChronoUnit.DAYS.between(inicioLocacao, LocalDate.now()) * valorDiario);
	}

	@Override
	public String toString() {
		return String.format(
				"- Dados leitor:\n%s\n\n- Dados locação:\nInício: %s\nFinal: %s\nValor diário: R$ %.2f\nValor total: R$ %.2f\n\n- Publicações:\n%s",
				leitor, getInicioLocacao(), getDataFinalizacao(), valorDiario, getValorTotal(), listaPublicacoes());
	}
}
