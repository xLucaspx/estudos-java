package curso;

public class Casting {
  public static void main(String[] args) {
    double d = 15.999;
    int i = (int) d; // 15: casting não arrendonda, apenas corta tudo o que vem depois do ponto
    System.out.println(i);

    long l = 151515151515l;
    int j = (int) l; // neste caso será impresso um número louco, pois estouramos o tamanho do int
    System.out.println(j); // 1191296155

    l = 151515151515l - 2191296155l;
    j = (int) l;
    System.out.println(j); // -1000000000

    byte b1 = 5;
    byte b2 = 3;
    byte b3 = (byte) (b1 + b2); // como o resulatdo de uma operação retorna no mínimo int, o cast é necessário
    System.out.println(b3); // 8
  }
}
