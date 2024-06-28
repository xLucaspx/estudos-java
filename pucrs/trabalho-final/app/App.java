package app;

import model.Doacao;
import model.ListaDoacao;
import model.ListaPessoa;
import model.Pessoa;

import java.util.Scanner;

import static utils.Validador.*;

public class App {
	private static ListaPessoa pessoas = new ListaPessoa();
	private static ListaDoacao doacoes = new ListaDoacao();
	private static boolean continuar = true;

	/*
TODO:
[ ] Incluir método que gera CPF para testes
[ ] Incluir mensagem que informa que a ordenação é prejudicada pelos acentos
[ ] Criar README
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		abertura();

		while (continuar) {
			menuPrincipal(in);
		}

		in.close();
		System.out.println("\n\nprograma encerrado\n");
	}

	private static void listaPessoas() {
		Pessoa[] lista = pessoas.getPessoas();

		System.out.println("Lista de pessoas:\n");
		for (Pessoa p : lista) {
			System.out.println(p);
		}
	}

	private static void listaDoacoes() {
		Doacao[] lista = doacoes.getDoacoes();

		System.out.println("Lista de doações:\n");
		for (Doacao p : lista) {
			System.out.println(p);
		}
	}

	private static void ordenaPessoasPorCpf() {
		System.out.println("Ordenando...");
		pessoas.ordenaPorCpf();
		System.out.println("Ordenação concluída\n");
		listaPessoas();
	}

	private static void ordenaPessoasPorNome() {
		System.out.println("Ordenando...");
		pessoas.ordenaPorNome();
		System.out.println("Ordenação concluída\n");
		listaPessoas();
	}

	private static void consultaPessoaPorCpf(Scanner in) {
		System.out.print("Digite o CPF que deseja consultar... ");
		String cpf = in.nextLine();
		Pessoa p = pessoas.buscaPorCpf(cpf);

		String saida = p != null ? "Resultado encontrado:\n" + p : "Nenhum resultado encontrado!";
		System.out.println(saida);
	}

	private static void alteraEmailPessoa(Scanner in) {
		System.out.print("Digite o CPF para localizar a pessoa... ");
		String cpf = in.nextLine();
		Pessoa p = pessoas.buscaPorCpf(cpf);

		if (p == null) {
			System.out.println("Nenhuma pessoa encontrada para o CPF encontrado!");
			return;
		}

		boolean emailValido = false;
		String email = "";
		do {
			System.out.printf("E-mail atual: %s%n", p.getEmail());
			System.out.print("Digite o novo e-mail... ");
			email = in.nextLine();

			emailValido = validaEmail(email);

			if (!emailValido) {
				System.err.println("O e-mail inserido é inválido!");
			}
		} while (!emailValido);

		p.setEmail(email);
		System.out.println("E-mail alterado com sucesso!");
	}

	private static Doacao buscaDoacao(Scanner in) {
		System.out.print("Digite a descrição ou código da doação... ");
		String input = in.nextLine();

		Doacao d;

		try {
			int codigo = Integer.parseInt(input);
			d = doacoes.buscaPorCodigo(codigo);
		} catch (Exception e) {
			d = doacoes.buscaPorDescricao(input);
		}

		return d;
	}

	private static void consultaDoacao(Scanner in) {
		Doacao d = buscaDoacao(in);

		String saida = d != null ? "Resultado encontrado:\n" + d : "Nenhum resultado encontrado!";
		System.out.println(saida);
	}

	private static void adicionaQuantidadeDeDoacao(Scanner in) {
		Doacao d = buscaDoacao(in);

		if (d == null) {
			System.out.println("Nenhuma doação encontrada!");
			return;
		}

		double quantidade = 0;
		do {
			System.out.printf("%s - Quantidade atual: %.2f%n", d.getDescricao(), d.getQuantidade());
			System.out.print("Digite a quantidade a ser adicionada... ");
			quantidade = leDouble(in);

			if (quantidade <= 0) {
				System.err.println("A quantidade deve ser maior do que 0!");
			}
		} while (quantidade <= 0);

		d.adiciona(quantidade);
		System.out.println("Quantidade adicionada com sucesso!");
	}

	private static void removeQuantidadeDeDoacao(Scanner in) {
		Doacao d = buscaDoacao(in);

		if (d == null) {
			System.out.println("Nenhuma doação encontrada!");
			return;
		}

		double quantidade = 0;
		do {
			System.out.printf("%s - Quantidade atual: %.2f%n", d.getDescricao(), d.getQuantidade());
			System.out.print("Digite a quantidade a ser removida... ");
			quantidade = leDouble(in);

			if (quantidade <= 0) {
				System.err.println("A quantidade deve ser maior do que 0!");
			}
		} while (quantidade <= 0);

		boolean sucesso = d.remove(quantidade);
		String saida = sucesso ? "Quantidade removida com sucesso!"
			: "Não foi possível remover: quantidade superior à disponível em estoque!";
		System.out.println(saida);
	}

	private static void consultaDoacaoPorQuantidade(Scanner in) {
		System.out.print("""
			Lista todos os produtos com quantidade maior ou igual à informada
			Digite a quantidade...\s
			""");
		double quantidade = leDouble(in);
		Doacao[] lista = doacoes.getDoacoesPorQuantidade(quantidade);

		if (lista.length == 0) {
			System.out.println("Nenhuma doação encontrada para a quantidade informada!");
			return;
		}

		System.out.println("\nResultado encontrado:");
		for (Doacao d : lista) {
			System.out.println(d);
		}
	}

	private static void cadastraDoacao(Scanner in) {
		boolean codigoValido = false;
		boolean descricaoValida = false;
		boolean quantidadeValida = false;
		boolean dadosValidos = false;
		int codigo = 0;
		String descricao = "";
		double quantidade = 0.0;

		do {
			if (!codigoValido) {
				System.out.println("Digite o código da doação: ");
				codigo = leInt(in);

				codigoValido = codigo > 0;

				if (!codigoValido) {
					System.err.println("O código inserido é inválido! Digite um valor maior do que 0.");
					continue;
				}

				if (doacoes.buscaPorCodigo(codigo) != null) {
					System.err.println("Já existe uma doação cadastrada com esse código!");
					codigoValido = false;
					continue;
				}
			}

			if (!descricaoValida) {
				System.out.println("Digite a descrição da doação: ");
				descricao = in.nextLine();
				descricaoValida = !descricao.trim().isEmpty();

				if (!descricaoValida) {
					System.err.println("A descrição inserida é inválida!");
					continue;
				}

				if (doacoes.buscaPorDescricao(descricao) != null) {
					System.err.println("Já existe uma doação cadastrada com essa descrição!");
					descricaoValida = false;
					continue;
				}
			}

			if (!quantidadeValida) {
				System.out.println("Digite a quantidade da doação: ");
				quantidade = leDouble(in);
				quantidadeValida = quantidade > 0;

				if (!quantidadeValida) {
					System.err.println("A quantidade inserida é inválida!");
					continue;
				}
			}

			dadosValidos = true;
		} while (!dadosValidos);

		Doacao d = new Doacao(codigo, descricao, quantidade);
		doacoes.cadastraDoacao(d);
		System.out.println("Doação cadastrada com sucesso!");
	}

	private static void cadastraPessoa(Scanner in) {
		boolean nomeValido = false;
		boolean cpfValido = false;
		boolean telefoneValido = false;
		boolean emailValido = false;
		boolean dadosValidos = false;
		String nome = "";
		String cpf = "";
		String telefone = "";
		String email = "";

		do {
			if (!nomeValido) {
				System.out.println("Digite o nome da pessoa: ");
				nome = in.nextLine();
				nomeValido = !nome.trim().isEmpty();

				if (!nomeValido) {
					System.err.println("O nome inserido é inválido!");
					continue;
				}
			}

			if (!cpfValido) {
				System.out.println("Digite o CPF da pessoa: ");
				cpf = in.nextLine();
				cpfValido = validaCpf(cpf);

				if (!cpfValido) {
					System.err.println("O CPF inserido é inválido!");
					continue;
				}

				if (pessoas.buscaPorCpf(cpf) != null) {
					System.err.println("Já existe uma pessoa cadastrada com este CPF!");
					cpfValido = false;
					continue;
				}
			}

			if (!telefoneValido) {
				System.out.println("Digite o telefone da pessoa: ");
				telefone = in.nextLine();
				telefoneValido = validaTelefone(telefone);

				if (!telefoneValido) {
					System.err.println("O telefone inserido é inválido!");
					continue;
				}
			}

			if (!emailValido) {
				System.out.println("Digite o e-mail da pessoa: ");
				email = in.nextLine();
				emailValido = validaEmail(email);

				if (!emailValido) {
					System.err.println("O e-mail inserido é inválido!");
					continue;
				}
			}

			// se chegar aqui, os dados são válidos
			dadosValidos = true;
		} while (!dadosValidos);

		Pessoa p = new Pessoa(cpf, nome, email, telefone);
		pessoas.cadastraPessoa(p);
		System.out.println("Pessoa cadastrada com sucesso!");
	}

	private static void menuPessoas(Scanner in) {
		int opcao = -1;

		do {
			System.out.println("""
				    
				- Menu pessoas -
				[1] Cadastrar pessoa
				[2] Consultar por CPF
				[3] Ordenar lista por CPF
				[4] Ordenar lista por nome
				[5] Alterar e-mail
				[6] Listar
				[7] Escolher doação
				[0] Sair

				Escolha...\s
				""");
			opcao = leInt(in);

			if (opcao < 0 || opcao > 7) {
				System.err.println("Opção inválida!\n");
			}

		} while (opcao < 0 || opcao > 7);

		switch (opcao) {
			case 1 -> cadastraPessoa(in);
			case 2 -> consultaPessoaPorCpf(in);
			case 3 -> ordenaPessoasPorCpf();
			case 4 -> ordenaPessoasPorNome();
			case 5 -> alteraEmailPessoa(in);
			case 6 -> listaPessoas();
			// case 7 -> escolheDoacao(in);
			case 0 -> continuar = false;
		}
	}

	private static void menuDoacoes(Scanner in) {
		int opcao = -1;

		do {
			System.out.println("""
				    
				- Menu doações -
				[1] Cadastra doação
				[2] Consulta doação
				[3] Consulta por quantidade
				[4] Adiciona quantidade
				[5] Remove quantidade
				[6] Listar

				Escolha...\s
				""");
			opcao = leInt(in);

			if (opcao < 0 || opcao > 6) {
				System.err.println("Opção inválida!\n");
			}

		} while (opcao < 0 || opcao > 6);

		switch (opcao) {
			case 1 -> cadastraDoacao(in);
			case 2 -> consultaDoacao(in);
			case 3 -> consultaDoacaoPorQuantidade(in);
			case 4 -> adicionaQuantidadeDeDoacao(in);
			case 5 -> removeQuantidadeDeDoacao(in);
			case 6 -> listaDoacoes();
			case 0 -> continuar = false;
		}
	}

	private static void menuPrincipal(Scanner in) {
		int opcao = -1;

		do {
			System.out.println("""
				    
				- Menu principal -
				[1] Doações
				[2] Pessoas
				[0] Sair

				Escolha...\s""");
			opcao = leInt(in);

			if (opcao < 0 || opcao > 2) {
				System.err.println("Opção inválida!\n");
			}

		} while (opcao < 0 || opcao > 2);

		switch (opcao) {
			case 1 -> menuDoacoes(in);
			case 2 -> menuPessoas(in);
			case 0 -> continuar = false;
		}
	}

	private static int leInt(Scanner in) {
		int valor = -1;

		try {
			valor = Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			System.err.println("Valor inválido digitado!\n");
		}

		return valor;
	}

	private static double leDouble(Scanner in) {
		double valor = -1;

		try {
			valor = Double.parseDouble(in.nextLine());
		} catch (Exception e) {
			System.err.println("Valor inválido digitado!\n");
		}

		return valor;
	}

	private static void abertura() {
		System.out.println("""
			--- Sistema de doações ---
			   
			Desenvolvido por:
			- Lucas da Paz (24102437)
			- Régis Júnior (24102590)
						
			""");
	}
}
