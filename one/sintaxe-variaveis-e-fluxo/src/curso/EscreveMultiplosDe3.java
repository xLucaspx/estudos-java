package curso;

public class EscreveMultiplosDe3 {
  public static void main(String[] args) {
    int i = 3;
    while (i <= 100) {
      if (i % 3 == 0) {
        System.out.print(i + " ");
      }
      i++;
    }
  }
}
