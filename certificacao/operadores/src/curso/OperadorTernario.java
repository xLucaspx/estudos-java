package curso;

public class OperadorTernario {
  public static void main(String... args) {
    // (condição) ? caso_true : caso_false
    int i = 5;
    int resultado = (i == 5) ? 100 : 0;
    System.out.println(resultado);

    // também é possível fazer direto, porém os retornos da expressão sempre devem
    // ser compatíveis com onde a expressão será utilizada; por exemplo, o sysout é
    // compatível com praticamente tudo, pois pode receber até mesmo object, então
    // podemos passar vários tipos de retorno:
    System.out.println(i < 5 ? 25 : "Não");

    // porém, se tentarmos atribuir esta expressão a uma variável do tipo int ou do
    // tipo String, teremos erro de compilação (type mismatch):
    // int resultado2 = i < 5 ? 25 : "Não";
    // String resultado2 = i < 5 ? 25 : "Não";

    // mas podemos atribuir ao tipo Object, mas isso envolve casting:
    Object resultado2 = i < 5 ? 25 : "Não";
    System.out.println(resultado2);

    int exp1 = i == 5 ? 10 : 0; // funciona pois retorna int
    double exp2 = i == 5 ? 10 : 0; // funciona, converte para double
    // int exp3 = i == 5 ? 10 : 0d; // não funciona pois converte para double

    System.out.println(exp1);
    System.out.println(exp2);
  }
}