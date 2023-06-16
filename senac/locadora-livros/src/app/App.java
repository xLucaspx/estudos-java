package app;

import java.time.LocalDate;
import java.time.Month;

import models.Endereco;
import models.Leitor;
import models.Livro;
import models.Locacao;
import models.Revista;
import models.TipoPublicacao;

public class App {
	public static void main(String[] args) {
		Livro l = new Livro("On The Road", LocalDate.of(1957, Month.SEPTEMBER, 5), TipoPublicacao.LITERATURA, 5, 380,
				"Jack Kerouac");
		Revista r = new Revista("Mundo Estranho", LocalDate.of(2020, Month.JUNE, 7), TipoPublicacao.INFANTIL, 173);

		Leitor pessoa = new Leitor("Fulano de Tal", "01234567801", new Endereco("Av. Venâncio Aires", "93", "Azenha"));

		Locacao locacao = new Locacao(LocalDate.of(2023, 05, 30), pessoa, 3.75f);
		
		locacao.addPublicacao(l);
		locacao.addPublicacao(r);

//		locacao.encerraLocacao(LocalDate.of(2023, Month.JUNE, 15));
		System.out.println(locacao);
//		System.out.println(r);
//		System.out.println(pessoa);
	}
}
