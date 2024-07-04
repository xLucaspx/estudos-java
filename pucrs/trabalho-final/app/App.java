package app;

import model.Doacao;
import model.ListaDoacao;
import model.ListaPessoa;
import model.Pessoa;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static utils.Validador.*;

public class App {
	private static final ListaPessoa PESSOAS = new ListaPessoa();
	private static final ListaDoacao DOACOES = new ListaDoacao();
	private static boolean continuar = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		abertura();

		while (continuar) {
			menuPrincipal(in);
		}

		in.close();
		System.out.println("\n\nprograma encerrado\n");
	}

	/**
	 * Método que imprime todas as pessoas da lista de pessoas.
	 */
	private static void listaPessoas() {
		Pessoa[] lista = PESSOAS.getPessoas();

		System.out.println("Lista de pessoas:\n");
		for (Pessoa p : lista) {
			System.out.println(p);
		}
	}

	/**
	 * Método que imprime todas as doações da lista de doações.
	 */
	private static void listaDoacoes() {
		Doacao[] lista = DOACOES.getDoacoes();

		System.out.println("Lista de doações:\n");
		for (Doacao p : lista) {
			System.out.println(p);
		}
	}

	/**
	 * Método que realiza a ordenação da lista de pessoas por CPF utilizando o método <code>compareTo</code> da classe
	 * String.
	 */
	private static void ordenaPessoasPorCpf() {
		System.out.println("Ordenando...");
		PESSOAS.ordenaPorCpf();
		System.out.println("Ordenação concluída\n");
		listaPessoas();
	}

	/**
	 * Método que realiza a ordenação da lista de pessoas por nome, em ordem alfabética, utilizando o método
	 * <code>compareToIgnoreCase</code> da classe String; acentuações e caracteres especiais podem prejudicar a
	 * ordenação.
	 */
	private static void ordenaPessoasPorNome() {
		System.out.println("Ordenando...");
		PESSOAS.ordenaPorNome();
		System.out.println("Ordenação concluída\n");
		listaPessoas();
	}

	/**
	 * Método que busca uma pessoa pelo CPF informado pelo usuário.
	 *
	 * @param in O Scanner para ler a entrada do usuário
	 * @return A pessoa encontrada ou null caso não seja encontrada uma pessoa correspondente na lista
	 */
	private static Pessoa buscaPessoa(Scanner in) {
		System.out.print("Digite o CPF para localizar a pessoa... ");
		String cpf = in.nextLine();
		return PESSOAS.buscaPorCpf(cpf);
	}

	/**
	 * Método que consulta uma pessoa pelo CPF informado pelo usuário e, caso encontre uma
	 * correspondência, imprime-a na tela; caso contrário, informa o usuário.
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
	private static void consultaPessoaPorCpf(Scanner in) {
		Pessoa p = buscaPessoa(in);

		if (p == null) {
			System.out.println("Nenhuma correspondência encontrada!");
			return;
		}

		System.out.printf("""
			Resultado encontrado:
			%s
				Doações recebidas:
			""", p);

		Doacao[] doacoes = p.getDoacoesRecebidas();
		for (Doacao d : doacoes) {
			System.out.printf("\t\t%s%n", d);
		}
	}

	/**
	 * Método para alterar o e-mail de uma pessoa cadastrada; o usuário informa o CPF da pessoa que deseja alterar e,
	 * caso seja encontrada correspondência, é informado o e-mail atual e solicitado o novo valor, que deve ser um
	 * endereço de e-mail válido.
	 *
	 * @param in O Scanner para ler a entrada do usuário
	 */
	private static void alteraEmailPessoa(Scanner in) {
		Pessoa p = buscaPessoa(in);

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

	/**
	 * Método que busca uma doação pelo código ou descrição informado pelo usuário.
	 *
	 * @param in O Scanner para ler a entrada do usuário
	 * @return A doação encontrada ou null caso não seja encontrada uma doação correspondente na lista
	 */
	private static Doacao buscaDoacao(Scanner in) {
		System.out.print("Digite a descrição ou código da doação... ");
		String input = in.nextLine();

		Doacao d;

		try {
			int codigo = Integer.parseInt(input);
			d = DOACOES.buscaPorCodigo(codigo);
		} catch (Exception e) {
			d = DOACOES.buscaPorDescricao(input);
		}

		return d;
	}

	/**
	 * Método que consulta uma doação pelo código ou descrição informado pelo usuário e, caso encontre uma
	 * correspondência, imprime-a na tela; caso contrário, informa o usuário.
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
	private static void consultaDoacao(Scanner in) {
		Doacao d = buscaDoacao(in);

		String saida = d != null ? "Resultado encontrado:\n" + d : "Nenhum resultado encontrado!";
		System.out.println(saida);
	}

	/**
	 * Método para adicionar determinada quantidade a uma doação. O usuário informa o código ou a descrição da doação que
	 * deseja modificar e, caso seja encontrada uma correspondência na lista, é informada a quantidade atual e
	 * solicitada a quantidade a ser adicionada, que deve ser maior ou igual a zero.
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
	private static void adicionaQuantidadeDeDoacao(Scanner in) {
		Doacao d = buscaDoacao(in);

		if (d == null) {
			System.out.println("Nenhuma doação encontrada!");
			return;
		}

		double quantidade = -1;
		do {
			System.out.printf("%s - Quantidade atual: %.2f%n", d.getDescricao(), d.getQuantidade());
			System.out.print("Digite a quantidade a ser adicionada... ");
			quantidade = leDouble(in);

			if (quantidade < 0) {
				System.err.println("A quantidade deve ser maior ou igual a 0!");
			}
		} while (quantidade < 0);

		boolean sucesso = d.adiciona(quantidade);
		String saida = sucesso ? "Quantidade adicionada com sucesso! Resultado: %.2f".formatted(d.getQuantidade())
			: "Nenhuma operação realizada!";
		System.out.println(saida);
	}

	/**
	 * Método para remover determinada quantidade de uma doação. O usuário informa o código ou a descrição da doação que
	 * deseja modificar e, caso seja encontrada uma correspondência na lista, é informada a quantidade atual e
	 * solicitada a quantidade a ser removida, que deve ser maior ou igual a zero e menor do que a quantidade atual.
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
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

			if (quantidade < 0) {
				System.err.println("A quantidade deve ser maior ou igual a 0!");
			}

			if (quantidade > d.getQuantidade()) {
				System.err.println("Quantidade superior à disponível em estoque!");
			}
		} while (quantidade < 0 || quantidade > d.getQuantidade());

		boolean sucesso = d.remove(quantidade);
		String saida = sucesso ? "Quantidade removida com sucesso! Resultado: %.2f".formatted(d.getQuantidade())
			: "Nenhuma operação realizada!";
		System.out.println(saida);
	}

	/**
	 * Método que lista todas as doações cadastradas com quantidade igual ou superior à informada pelo usuário.
	 * A quantidade informada deve ser maior ou igual a zero.
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
	private static void consultaDoacaoPorQuantidade(Scanner in) {
		double quantidade = -1;

		do {
			System.out.print("""
				Lista todos os produtos com quantidade maior ou igual à informada
				Digite a quantidade...\s
				""");
			quantidade = leDouble(in);

			if (quantidade < 0) {
				System.err.println("Informe uma quantidade maior ou igual a zero!");
			}
		} while (quantidade < 0);

		Doacao[] lista = DOACOES.getDoacoesPorQuantidade(quantidade);

		if (lista.length == 0) {
			System.out.println("Nenhuma doação encontrada para a quantidade informada!");
			return;
		}

		System.out.println("\nResultado encontrado:");
		for (Doacao d : lista) {
			System.out.println(d);
		}
	}

	/**
	 * Método utilizado para cadastrar uma doação no sistema. Solicita do usuário as informações necessárias uma a uma
	 * e, após garantir que todas estão válidas, adiciona a doação à lista de doações.
	 * Não permite o cadastro de doações com código ou descrição duplicados ou com dados inválidos.
	 *
	 * @param in O Scanner utilizado para ler as entradas do usuário
	 */
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
				System.out.println("Digite o código da doação (inteiro): ");
				codigo = leInt(in);

				codigoValido = codigo > 0;

				if (!codigoValido) {
					System.err.println("O código inserido é inválido! Digite um valor maior do que 0.");
					continue;
				}

				if (DOACOES.buscaPorCodigo(codigo) != null) {
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

				if (DOACOES.buscaPorDescricao(descricao) != null) {
					System.err.println("Já existe uma doação cadastrada com essa descrição!");
					descricaoValida = false;
					continue;
				}
			}

			if (!quantidadeValida) {
				System.out.println("Digite a quantidade da doação (double): ");
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
		DOACOES.cadastraDoacao(d);
		System.out.println("Doação cadastrada com sucesso!");
	}

	/**
	 * Método utilizado para cadastrar uma pessoa no sistema. Solicita do usuário as informações necessárias uma a uma
	 * e, após garantir que todas estão válidas, adiciona a pessoa à lista de pessoas.
	 * Não permite o cadastro de pessoas com CPF duplicado ou dados inválidos.
	 *
	 * @param in O Scanner utilizado para ler as entradas do usuário
	 */
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
				System.out.println("Digite o CPF da pessoa (deve ser um CPF válido): ");
				cpf = in.nextLine();
				cpfValido = validaCpf(cpf);

				if (!cpfValido) {
					System.err.println("O CPF inserido é inválido!\nTente utilizar " + geraCpfTeste());
					continue;
				}

				if (PESSOAS.buscaPorCpf(cpf) != null) {
					System.err.println("Já existe uma pessoa cadastrada com este CPF!");
					cpfValido = false;
					continue;
				}
			}

			if (!telefoneValido) {
				System.out.println("Digite o telefone da pessoa (deve estar em um formato válido): ");
				telefone = in.nextLine();
				telefoneValido = validaTelefone(telefone);

				if (!telefoneValido) {
					System.err.println("O telefone inserido é inválido!");
					continue;
				}
			}

			if (!emailValido) {
				System.out.println("Digite o e-mail da pessoa (deve estar em formato válido): ");
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
		PESSOAS.cadastraPessoa(p);
		System.out.println("Pessoa cadastrada com sucesso!");
	}

	/**
	 * Método que permite que determinada pessoa escolha uma quantidade de itens para receber como doação; informa-se o
	 * CPF da pessoa e, caso seja encontrada uma correspondência,
	 * informa-se o código ou a descrição da doação e a quantidade desejada. Caso todas as informações sejam válidas, a
	 * operação será realizada.
	 *
	 * @param in O Scanner para ler as entradas do usuário
	 */
	private static void escolheDoacao(Scanner in) {
		System.out.println("Para qual pessoa irá a doação?");
		Pessoa p = buscaPessoa(in);

		if (p == null) {
			System.err.println("Nenhuma pessoa encontrada para o CPF informado!");
			return;
		}

		System.out.println("Qual item será doado?");
		Doacao d = buscaDoacao(in);

		if (d == null) {
			System.err.println("Nenhuma doação encontrada para o critério informado!");
			return;
		}

		double quantidadeDoada = 0;
		do {
			System.out.printf("%s - Quantidade atual: %.2f%n", d.getDescricao(), d.getQuantidade());
			System.out.print("Informe a quantidade que será doada... ");
			quantidadeDoada = leDouble(in);

			if (quantidadeDoada < 0) {
				System.err.println("A quantidade deve ser maior ou igual a 0!");
			}

			if (quantidadeDoada > d.getQuantidade()) {
				System.err.println("Quantidade superior à disponível em estoque!");
			}
		} while (quantidadeDoada < 0 || quantidadeDoada > d.getQuantidade());

		boolean sucesso = d.remove(quantidadeDoada);
		String saida = "Nenhuma operação realizada!";

		if (sucesso) {
			sucesso = p.adicionaDoacao(new Doacao(d.getCodigo(), d.getDescricao(), quantidadeDoada));
			if (sucesso) {
				saida = "Doação realizada com sucesso!";
			}
		}

		System.out.println(saida);
	}

	/**
	 * Método que exibe o menu de pessoas do programa. Mostra as opções disponíveis e lê a escolha do usuário; caso a
	 * opção digitada seja válida, chama o método correspondente, caso contrário informa o usuário e solicita a entrada
	 * novamente
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
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
				[8] Voltar
				[0] Sair

				Escolha...\s
				""");
			opcao = leInt(in);

			if (opcao < 0 || opcao > 8) {
				System.err.println("Opção inválida!\n");
			}

		} while (opcao < 0 || opcao > 8);

		switch (opcao) {
			case 1 -> cadastraPessoa(in);
			case 2 -> consultaPessoaPorCpf(in);
			case 3 -> ordenaPessoasPorCpf();
			case 4 -> ordenaPessoasPorNome();
			case 5 -> alteraEmailPessoa(in);
			case 6 -> listaPessoas();
			case 7 -> escolheDoacao(in);
			case 8 -> {return;}
			case 0 -> continuar = false;
		}
	}

	/**
	 * Método que exibe o menu de doações do programa. Mostra as opções disponíveis e lê a escolha do usuário; caso a
	 * opção digitada seja válida, chama o método correspondente, caso contrário informa o usuário e solicita a entrada
	 * novamente
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
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
				[7] Voltar
				[0] Sair

				Escolha...\s
				""");
			opcao = leInt(in);

			if (opcao < 0 || opcao > 7) {
				System.err.println("Opção inválida!\n");
			}

		} while (opcao < 0 || opcao > 7);

		switch (opcao) {
			case 1 -> cadastraDoacao(in);
			case 2 -> consultaDoacao(in);
			case 3 -> consultaDoacaoPorQuantidade(in);
			case 4 -> adicionaQuantidadeDeDoacao(in);
			case 5 -> removeQuantidadeDeDoacao(in);
			case 6 -> listaDoacoes();
			case 7 -> {return;}
			case 0 -> continuar = false;
		}
	}

	/**
	 * Método que exibe o menu principal do programa. Mostra as opções disponíveis e lê a escolha do usuário; caso a
	 * opção digitada seja válida, chama o método correspondente, caso contrário informa o usuário e solicita a entrada
	 * novamente
	 *
	 * @param in O Scanner utilizado para ler a entrada do usuário
	 */
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

	/**
	 * Método que lê um inteiro digitado pelo usuário. Caso o valor digitado seja inválido ou ocorra algum erro, informa
	 * o usuário e retorna -1
	 *
	 * @param in O Scanner que será utilizado para ler a entrada do usuário
	 * @return O inteiro digitado pelo usuário ou -1 em caso de erro
	 */
	private static int leInt(Scanner in) {
		int valor = -1;

		try {
			valor = Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			System.err.println("Valor inválido digitado!\n");
		}

		return valor;
	}

	/**
	 * Método que lê um double digitado pelo usuário. Caso o valor digitado seja inválido ou ocorra algum erro, informa
	 * o usuário e retorna -1
	 *
	 * @param in O Scanner que será utilizado para ler a entrada do usuário
	 * @return O double digitado pelo usuário ou -1 em caso de erro
	 */
	private static double leDouble(Scanner in) {
		double valor = -1;

		try {
			valor = Double.parseDouble(in.nextLine());
		} catch (Exception e) {
			System.err.println("Valor inválido digitado!\n");
		}

		return valor;
	}

	/**
	 * Método utilizado para imprimir a abertura do programa
	 */
	private static void abertura() {
		System.out.println("""
			--- Sistema de doações ---
			   
			Desenvolvido por:
			- Lucas da Paz (24102437)
			- Régis Júnior (24102590)
			""");
	}

	private static String geraCpfTeste() {
		System.out.println("gera cpf teste chamado");
		int min = 0;
		int max = 1000;

		String parte1 = String.format("%03d", ThreadLocalRandom.current().nextInt(min, max));
		String parte2 = String.format("%03d", ThreadLocalRandom.current().nextInt(min, max));
		String parte3 = String.format("%03d", ThreadLocalRandom.current().nextInt(min, max));

		String cpf = parte1 + parte2 + parte3;

		// primeiro dígito verificador
		int soma = 0;
		int resto = 0;

		for (int i = 0; i < 9; i++) {
			int digito = cpf.charAt(i) - '0';
			soma += digito * (10 - i);
		}

		resto = (soma * 10) % 11;
		cpf += resto == 10 ? 0 : resto;

		// segundo dígito verificador
		soma = 0;

		for (int i = 0; i < 10; i++) {
			int digito = cpf.charAt(i) - '0';
			soma += digito * (11 - i);
		}

		resto = (soma * 10) % 11;
		cpf += resto == 10 ? 0 : resto;

		return validaCpf(cpf) ? cpf : geraCpfTeste();
	}
}
