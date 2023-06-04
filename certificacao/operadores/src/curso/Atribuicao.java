package curso;

import java.util.ArrayList;
import java.util.List;

public class Atribuicao {
  public static void main(String[] args) {
    // operador de atribuiçã0: =
    // do lado esquerdo é onde vou atribuir, do lado direito é o que vou atribuir

    // Atribuição de tipos primitivos é feita por valor
    long idade = 15;
    // long idade =; // syntax error
    // long = 15; // erro

    // A atribuição só compila se a expressão do lado direito, que eu quero
    // atribuir, for MENOS ABRANGENTE que o tipo do lado esquerdo, por exemplo: um
    // int cabe em um long, mas um long não cabe em um int.

    // menos abrangente -> mais abrangente:
    // byte -> short -> int -> long (todos aqui cabem em float e double)
    // float -> double (o float é menor e tem menos precisão do que o double).
    // char (apenas positivo);
    int a = 10;
    long b = 20;
    short c = 3;
    byte d = 4;
    char h = 65;
    // byte d = -200; // type mismatch
    // char h = -2; // type mismatch
    // c = h; // type mismatch
    // h = c; // type mismatch

    double e = 30.0;
    float f = 40.3f;
    e = f;
    // tentar colocar um tipo mais abrangente dentro de um menos abrangente gera uma
    // possível perda de precisão, e o compilador acusa type mismatch error:

    // byte d = -200; // byte começa em -120
    // char h = -2; // char é somente positivo

    // c = h; // apesar de terem o mesmo tamanho no Java, não é possível converter
    // h = c; // short pra char e nem o contrário, pois char é apenas positivo;

    // f = e; // double é mais abrangente que float

    f = a;
    f = b;
    f = c;
    f = d;
    f = h;

    e = a;
    e = b;
    e = c;
    e = d;
    e = h;

    System.out.println(e);
    System.out.println(idade);

    // Atribuição de objetos e referências para objetos é feita por referências
    ArrayList<String> lista = new ArrayList<>();
    // obj e ref também suportam polimorfismo, do menos para o mais abrangente:
    List<String> lista2 = lista;
    lista2.add("Para silenciar o warning!");
  }
}
