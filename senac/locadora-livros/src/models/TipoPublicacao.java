package models;

public enum TipoPublicacao {
	AUTO_AJUDA("Auto-ajuda"), ESPORTES("Esportes"), ADMINISTRACAO("Admnistração"), INFANTIL("Infantil"),
	POLICIAL("Policial"), SUSPENSE("Suspense"), ROMANCE("Romance"), LITERATURA("Literatura");

	private String tipoPublicacao;

	private TipoPublicacao(String tipoPublicacao) {
		this.tipoPublicacao = tipoPublicacao;
	}

	@Override
	public String toString() {
		return tipoPublicacao;
	}
}
