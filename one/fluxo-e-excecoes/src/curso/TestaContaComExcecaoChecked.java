package curso;

public class TestaContaComExcecaoChecked {
	public static void main(String[] args) {

		Conta c = new Conta();

		try {
			c.saca();
		} catch (MinhaException e) {
			System.out.println(
					"Precisamos tratar exceções que herdam diretamente de Exception pois elas são checked, ou seja, o código só compila se elas forem tratadas");
		}
	}
}
