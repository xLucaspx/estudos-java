package curso;

public class ArrayReferencias {
  public static void main(String[] args) {
    Cliente[] clientes = new Cliente[5];

    // System.out.println(clientes[0].nome); // null pointer exception

    for (int i = 0; i < clientes.length; i++) {
      clientes[i] = new Cliente();
      clientes[i].nome = "Pafúncio";
    }

    for (Cliente cliente : clientes) {
      System.out.println(cliente.nome);
    }

    // polimorfismo:
    Cliente[] clientes2 = new Cliente[5];
    clientes2[0] = new Cliente();
    clientes2[1] = new ClienteEspecial();

    // array de REFERÊNCIAS: altera a referência, altera também no array
    Cliente juca = new Cliente();
    juca.nome = "Juca";
    clientes2[2] = juca;
    System.out.println(juca.nome); // Juca
    System.out.println(clientes2[2].nome); // Juca

    juca.nome = "Carvalho";
    System.out.println(juca.nome); // Carvalho
    System.out.println(clientes2[2].nome); // Carvalho

    // casting em arrays de referências é possível,
    // desde que os tipos sejam compatíveis:
    String[] nomes = { "Juca", "Pafúncio" };
    Object[] objetos = nomes; // Object pode receber String, mas o contrário não

    for (Object o : objetos) {
      System.out.print(o + " - ");
    }
  }
}

class Cliente {
  String nome;
}

class ClienteEspecial extends Cliente {
}
