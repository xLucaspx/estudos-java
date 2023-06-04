package curso;

public class TestaTratamentoException {
  // Exceptions unchecked são filhas de RuntimeException, que estende Exception,
  // que estende Throwable;
  // Exceptions checked são filhas diretas de exception.
  public static void main(String[] args) {
    String s = null;
    // s.toLowerCase(); joga NullPointerException

    try { // try sozinho não compila, precisa de catch ou finally
      s.toLowerCase();
      // mesmo dentro do try, linhas de código após uma Exception não são executadas:
      System.out.println("próxima linha!");

      // catch pode ser específico ou genérico, porém só podemos colocar exceções
      // checked dentro do catch caso o código realmente possa lançar tal exception:
      // } catch (NullPointerException e) { // específico

      // } catch (IndexOutOfBoundsException e) { // específico, porém neste caso não
      // pegaria a exception (NullPointer)

      // } catch (IOException e) { // não compila: This exception is never thrown from
      // the try statement body

      // } catch (Throwable e) { // muito genérico, mas funciona

      // } catch (RuntimeException e) { // genérico

    } catch (Exception e) { // mais comum
      System.err.println("Pegamos a Exception: " + e.getMessage());
    }

    System.out.println("fim do código!");
  }
}
