package curso;

public class TesteConexao {
	public static void main(String[] args) {
		// try-with-resources; mais simples, executa o finally
		// automaticamente e substitui o código comentado abaixo:
		try (Conexao conexao = new Conexao()) { 
			conexao.leDados();
		} catch (Exception e) {
			System.out.println("Erro na conexão");
		}

		// declarar a variavel como null para ela ser acessível fora do escopo do try
		// Conexao conexao = null;

		// try {
		// 	conexao = new Conexao();
		// 	conexao.leDados();
		// } catch (IllegalStateException e) {
		// 	System.out.println("Erro na conexão");
		// } finally {
		// 	// finally é executado de qualquer maneira, havendo exceptions ou não; usado para não repetir código
		// 	System.out.println("Executando finally");
		// 	if (conexao != null) {
		// 		conexao.close(); // sempre devemos fechar uma conexão
		// 	}
		// }
	}
}
