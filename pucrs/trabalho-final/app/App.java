package app;

import model.Doacao;
import model.ListaDoacao;
import model.ListaPessoa;
import model.Pessoa;

public class App {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("12345678909", "Régis", "res@email.com", "5134776544");
		Doacao d1 = new Doacao(5, "Descrição da doação", 200);

		ListaPessoa listaPessoa = new ListaPessoa();
		listaPessoa.cadastraPessoa(p1);

		ListaDoacao listaDoacao = new ListaDoacao();
		listaDoacao.cadastraDoacao(d1);

		for (Pessoa p : listaPessoa.getPessoas()) {
			System.out.println(p);
		}

		for (Doacao d : listaDoacao.getDoacoes()) {
			System.out.println(d);
		}
	}
}
