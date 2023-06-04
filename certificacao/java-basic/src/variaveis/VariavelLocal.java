package variaveis;

public class VariavelLocal {
	// Variável local: é declarada dentro de um método ou de um construtor,
	// e existe dentro do bloco que ela foi criada:

	public void m1() {
		int x = 10;

		if (x >= 10) {
			int y = 50;
			System.out.println(y);
		}
		System.out.println(x);
		// System.out.println(y); a variável y só existe dentro do bloco if
	}

	public void m2() {
		for (int i = 0, j = 0; i <= 10; i++) {
			j++;
			System.out.print(j + " ");
		}
		// as variáveis i e j não estão acessíveis fora do escopo do for
		// System.out.println(i);
		// System.out.println(j);
	}

	public static void main(String[] args) {
		VariavelLocal teste = new VariavelLocal();
		teste.m1();
		teste.m2();

		// se eu tenho uma variável local com um nome eu não posso ter outra variável
		// local naquele mesmo escopo com o mesmo nome:
		int a = 10;
		// int a = 20; erro
		System.out.println("\n" + a); // só pra silenciar os warnings

		// a variável args já foi definida dentro do método main. Quer dizer que eu não
		// posso ter duas variáveis locais com o mesmo nome:
		// String[] args = null;
	}
}
