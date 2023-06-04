package curso;

public class ComparacaoDeObjetos {
  public static void main(String[] args) {
    Cliente c1 = new Cliente("Juca");
    Cliente c2 = new Cliente("Beto");
    Cliente c3 = new Cliente("Juca");

    // == serve para comparar se duas variáveis apontam para a mesma referência:
    System.out.println(c1 == c2); // false
    System.out.println(c1 == c3); // false

    // equals: método da classe Object que verifica se dois objetos são iguais
    // dentro de um determinado critério, decidido pelo programador; se não
    // definirmos um critério para comparação, o equals acaba utilizando o ==; para
    // definir o critério, devemos sobrescrever o método equals na nossa classe

    // critério definido: nome do cliente
    System.out.println(c1.equals(c2)); // false, nomes diferentes
    System.out.println(c1.equals(c3)); // true, mesmo nome

    // Classes como String, Integer e muitas outras possuem o método equals()
    // reescrito, por exemplo:
    // new Integer(10) == new Integer(10) // false
    // new Integer(10).equals(new Integer(10)) // true
  }
}

class Cliente {
  String nome;

  Cliente(String nome) {
    this.nome = nome;
  }

  // lembrando que, para sobrescrever um método, a assinatura deve ser EXATAMENTE
  // IGUAL a da classe mãe, senão estamos apenas o sobrecarregando com outra
  // implementação (overload)
  @Override
  public boolean equals(Object obj) {
    // O método equals não consegue tirar proveito do generics, então precisamos
    // receber Object e ainda verificar se o tipo do objeto passado como argumento é
    // realmente um Cliente (o contrato do método diz que você deve retornar false,
    // e não deixar lançar exception em um caso desses)
    if (!(obj instanceof Cliente)) {
      return false;
    }
    Cliente outro = (Cliente) obj;
    return this.nome.equals(outro.nome);
  }
}
