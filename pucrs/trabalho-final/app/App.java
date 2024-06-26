package app;

import model.Doacao;
import model.ListaDoacao;
import model.ListaPessoa;
import model.Pessoa;

public class App {
	public static void main(String[] args) {
		/*
		TODO:
		[ ] Incluir método que gera CPF para testes
		[ ] Incluir mensagem que informa que a ordenação é prejudicada pelos acentos
		[ ] Criar README
		 */
		Pessoa p1 = new Pessoa("12345678909", "Thalia da Silva", "thaliasilva@email.com", "51 9 88715564");
		Pessoa p2 = new Pessoa("09876543229", "Gabriel Domingues", "dg-gab@email.com", "53 3340-9998");
		Pessoa p3 = new Pessoa("10928374696", "Lucas Oliveira", "lucas@email.com", "51 9 96991275");
		Pessoa p4 = new Pessoa("11223344517", "Eduardo Ita", "eita@email.com", "54 9 8217-4556");
		Pessoa p5 = new Pessoa("01004567740", "Rodrigo Bajara", "brod@email.com", "5536654122");
		Pessoa p6 = new Pessoa("05347504943", "Régis", "regis@email.com", "51 80206040");

		Doacao d1 = new Doacao(1, "Descrição da doação 1", 200);
		Doacao d2 = new Doacao(2, "Descrição da doação 2", 205);
		Doacao d3 = new Doacao(3, "Descrição da doação 3", 2.00);
		Doacao d4 = new Doacao(4, "Descrição da doação 4", 5.90);
		Doacao d5 = new Doacao(5, "Descrição da doação 5", 2);

		ListaDoacao listaDoacao = new ListaDoacao();
		listaDoacao.cadastraDoacao(d1);
		listaDoacao.cadastraDoacao(d2);
		listaDoacao.cadastraDoacao(d3);
		listaDoacao.cadastraDoacao(d4);
		listaDoacao.cadastraDoacao(d5);

		System.out.println(listaDoacao.remove("Descrição da doação 2", 5));
		System.out.println(listaDoacao.adiciona("descrição da doação 2", 10.8976));

		for (Doacao d : listaDoacao.getDoacoes()) {
			System.out.println(d);
		}

		ListaPessoa listaPessoa = new ListaPessoa();
		listaPessoa.cadastraPessoa(p1);
		listaPessoa.cadastraPessoa(p2);
		listaPessoa.cadastraPessoa(p3);
		listaPessoa.cadastraPessoa(p4);
		listaPessoa.cadastraPessoa(p5);
		listaPessoa.cadastraPessoa(p6);

		listaPessoa.ordenaPorCpf();
		// listaPessoa.ordenaPorNome();

		listaPessoa.alteraEmail("12345678909", "novoemail@email.com");

		for (Pessoa p : listaPessoa.getPessoas()) {
			System.out.println(p);
		}
	}
}
