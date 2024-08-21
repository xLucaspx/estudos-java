/**
 * <p>Desenvolva um sistema que possua pelo menos 2 classes: Matematica e Main.</p>
 * <p>Na classe Matematica deve haver um método de classe (static) que recebe 3 parâmetros: dividendo (inteiro), divisor
 * (inteiro), precisao (inteiro); este método retorna uma String com o resultado da divisão do dividendo pelo
 * divisor, com tantas casas decimais significativas quanto a precisão. Se a divisão não for possível, retorna null.</p>
 * <ul>
 * 	<li><strong>Exemplo 1</strong>: dividendo: 100, divisor: 3, precisão: 20, string de retorno: "33
 * 	.33333333333333333333";</li>
 * 	<li><strong>Exemplo 2</strong>: dividendo: 10, divisor: 4, precisão: 10, string de retorno: "2.5";</li>
 * 	<li><strong>Exemplo 3</strong>: dividendo: 10, divisor: 0, precisão: 10, string de retorno: null.</li>
 * </ul>
 * <p>Na classe Main, deve ter o método de classe main que:</p>
 * <ol>
 * 	<li>Realiza a entrada de dados:
 * 		<ul>
 * 			<li>Se não houver parâmetros vindos do sistema operacional, deve-se solicitar ao usuário que digite os valores
 * 			do dividendo, divisor e precisão;</li>
 * 			<li>Se houver parâmetros vindos do sistema operacional (String[] args), deve haver 3 parâmetros: o primeiro
 * 			deve ser o dividendo, o segundo deve ser o divisor e o terceiro deve ser a precisão.</li>
 * 		</ul>
 * 	</li>
 * 	<li>Realiza o cálculo da divisão, se os dados de entrada estiverem corretos.</li>
 * 	<li>Apresenta o resultado da divisão. Se houve dados de entrada inválidos ou cálculo nulo, apresenta a mensagem:
 * 	"Não foi possível realizar a divisão".</li>
 * </ol>
 */
public class Main {
	public static void main(String... args) {
		new App().run(args);
	}
}
