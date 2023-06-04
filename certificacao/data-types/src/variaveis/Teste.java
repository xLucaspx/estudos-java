package variaveis;

public class Teste {
  public static void main(String[] args) {
    /*
     * byte: -128 a 127;
     * short e char tem o mesmo tamanho, mas char é sempre positivo;
     * tamanhos: short/char < int < long
     * char: 0 ou + (sempre positivo);
     * double e float: únicos primitivos com ponto flutuante
     * variáveis de pontos flutuantes podem assumir valores especiais, como +∞ ou -∞
     * (mais infinito ou menos infinito), +0 ou -0 e NaN (número inválido);
     * boolean: único tipo primitivo não considerado numérico;
     */
    Automovel carro = new Automovel();
    System.out.println("Valor padrão de int: " + carro.numero); // 0
    System.out.println("Valor padrão de double: " + carro.preco); // 0.0
    System.out.println("Valor padrão de String: " + carro.marca);
    System.out.println("Valor padrão de char: " + carro.primeiraLetra); // char 0 (blank)
    System.out.println("no caso, valor padrão de char == 0: " + (carro.primeiraLetra == 0)); // true
    System.out.println("Valor padrão de boolean: " + carro.usado); // false
    System.out.println("Valor padrão de referência: " + carro.motor); // null

    // Arrays são populados com valores padrão:
    boolean[] arrBool = new boolean[5];
    int[] arrInt = new int[5];
    String[] arrStr = new String[5];
    for (int i = 0; i < 5; i++) {
      System.out.print(arrBool[i] + " "); // false
      System.out.print(arrInt[i] + " "); // 0
      System.out.print(arrStr[i] + " "); // null
      System.out.println();
    }

    // por padrão, inteiros são int e números quebrados são double; para explicitar
    // um long ou um float, usamos as letras l/L e f/F no final do número:
    int i = 15;
    double d = 10.2; // também pode ser 10.2d
    long l = 15l;
    float f = 10.2f; // float precisa ser explícito
    System.out.println(i);
    System.out.println(d);
    System.out.println(l);
    System.out.println(f);

    // podemos usar _ para separar dígitos de números, desde que eu tenha, de cada
    // lado, um caracter que faz parte do valor do número:
    long l2 = 1_234_567_890_234l;
    long l3 = 1__2345_6789_0234l;
    // long l4 = _123_456_789_0234_l; // Erro
    System.out.println(l2);
    System.out.println(l3);

    // exceções para números inteiros:
    int x = 0761; // representação octal; output: 497
    // int X = 08; erro: out of range da representação octal

    int y = 0xA; // representação hexadecimal; output: 10
    // int y = 0xG; // erro:invalid hex literal number

    int z = 0b1101; // representação binária; output: 13
    // int z = 0b012; // syntax error: binário aceita apenas 0s e 1s

    System.out.println(x);
    System.out.println(y);
    System.out.println(z);

    // ponto flutuante também aceita notação científica:
    double d2 = 3.1E3; // output: 3100.0
    float f2 = 2e4f; // output: 20000.0

    System.out.println(d2);
    System.out.println(f2);

    // usos de char:
    char a1 = 'A';
    char a2 = 65;
    char omega = '\u03a9'; // unicode

    System.out.println(a1);
    System.out.println(a2);
    System.out.println(omega);

    for (char q = 'a'; q <= 'z'; q++) {
      System.out.print(q + " ");
    }

    // Nenhuma palavra-chave em Java possui caractere maiúsculo.

    // Nomes de variáveis: é case sensitive; não pode usar palavras chave; pode usar
    // letras unicode, números (menos no primeiro caractere), $ e _:
    int numero = 0;
    int NUMERO = 0;
    boolean $valor = false;
    double valor_decimal = 0.0;
    // string 2textos; => erro
    // boolean int; => erro
    System.out.println("\n" + numero);
    System.out.println(NUMERO);
    System.out.println($valor);
    System.out.println(valor_decimal);
  }
}

class Automovel {
  // variáveis membro possuem valor default, associado a 0.
  int numero; // 0
  double preco; // 0.0
  String marca;
  char primeiraLetra; // char 0
  boolean usado; // false
  Motor motor; // valor default de uma referência é null
}

class Motor {
}
