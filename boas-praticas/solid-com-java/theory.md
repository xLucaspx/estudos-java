# Tell, Don’t Ask

Não pergunte para uma classe se você pode chamar um método; afirme para ela o que que você deseja que seja executado.

**Exemplo do que não fazer**:

```java
class Post {
	public Status status; // atributo público

	public Post() {
		this.status = Status.RASCUNHO;
	}

	public static void main(String... args) {
		Post p = new Post();
		// toda vez quequisermos publicar um post, teremos que fazer esse if
		if (p.status == Status.RASCUNHO)
			p.status = Status.PUBLICADO
		else
			throw new PostJaPublicadoException();
	}
}
```

**Exemplo de código otimizado com Tell, Don’t Ask**:

```java
class Post {
	private Status status; // definindo como private

	public Post() {
		this.status = Status.RASCUNHO;
	}

	public publica() {
		if (this.status == Status.RASCUNHO)
			this.status = Status.PUBLICADO
		else
			throw new PostJaPublicadoException();
	}

	public static void main(String... args) {
		Post p = new Post();
		p.publica()
	}
}
```

# Fail Fast

Podemos melhorar ainda mais o código acima; é consenso entre os desenvolvedores que utilizar `else` no código é uma má prática (ver Object Callisthenics). Além disso, se checarmos a condição antes de chamar o método, podemos remover um nível de indentação, o que é muito bom.

**Exemplo de código com Fail Fast**:

```java
class Post {
	private Status status;

	public Post() {
		this.status = Status.RASCUNHO;
	}

	// este método agora está mais legível:
	public publica() {
		if (this.status != Status.RASCUNHO)
			throw new PostJaPublicadoException();

		this.status = Status.PUBLICADO
	}

	public static void main(String... args) {
		Post p = new Post();
		p.publica()
	}
}
```

# SOLID

**S**ingle Responsibility Principle (Responsabilidade Única)

**O**pen Closed Principle (Aberto Fechado)

**L**iskov Substitution Principle (Substituição de Liskov)

**I**nterface Segregation Principle (Segregação de Interface)

**D**ependency Inversion Principle (Inversão de Dependências)

---

## Princípios da Orientação a Objetos

### Coesão

União harmônica entre as coisas. Na programação, é um dos pilares da orientação a objetos. Uma classe coesa é aquela que tem apenas uma responsabilidade e a executa de forma concisa; já uma classe _não coesa_ tende a ter muitas tarefas e crescer indefinidamente, o que torna-a difícil de ser mantida.

**Exemplo de classe não coesa**:

```java
class Funcionario() {
	private String nome;
	private String cpf;
	private BigDecimal salario;
	private Cargo cargo;
	private String cep;
	private String logradouro;
	private String bairro;
	private String numero;
	private String cidade;
	private String uf;

	public void formataCpf() {
		// logica para formatar CPF
	}

	public void formataCep() {
		// logica para formatar CEP
	}

		public void completaEndereco() {
		// logica para consultar WS dos correios
	}
}
```

**Exemplo de classe coesa**:

```java
class Funcionario() {
	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;

	public void isGerente() {
		return this.cargo == Cargo.GERENTE;
	}
}
```

### Encapsulamento

Outro princípio da orientação a objetos, é o ato de incluir ou proteger alguma coisa em uma cápsula. Na programação nada mais é do que uma forma de blindar uma classe contra influências e manipulações externas que podem prejudicar as informações contidas ali; além disso, ao encapsular determinados dados e liberar acesso apenas ao necessário, tornamos nossos objetos mais fáceis de serem utilizados. Já as classes não encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento.

Getters e setters por si só não fornecem nenhum tipo de encapsulamento. O fato de criar getters e setters para tudo, na verdade, quebra o encapsulamento da classe, fornecendo acesso direto a propriedades que não deveriam ser expostas.

**Exemplo de classe que fere o encapsulamento**:

```java
public class Funcionario {
	private String nome;
	private String cpf;
	private Cargo cargo;
	private float salario;

	public void setSalario(float salario) {
		// por mais que o atributo salario esteja privado, com o setter conseguimos
		// manipulá-lo e burlar as regras de negócio
		this.salario = salario;
	}
}

Funcionario novo = carregaDoBancoDeDados();
novo.setSalario(100000);
```

**Exemplo de classe encapsulada**:

```java
public class Funcionario {
	private String nome;
	private String cpf;
	private Cargo cargo;
	private float salario;

	public void reajustaSalario (float aumento) {
		float precentualReajuste = (aumento / salario) * 100;

		if (percentualReajuste > 40)
			throw new IllegalArgumentException("O percentual de reajuste deve ser menor do que 40%");

		this.salario += aumento;
	}
}
```

### Acoplamento

O terceiro dos grandes princípios da orientação a objetos, acoplamento é a ação de acoplar, ou o agrupamento dos pares. Na programação o acoplamento ocorre quando dois ou mais componentes estão interligados e causando uma dependência entre si, por exemplo uma classe A que chama uma classe B.

Porém, o acoplamento não é necessariamente uma coisa ruim, a não ser quando se torna muito forte, ou seja, quando uma classe conhece muitos detalhes da outra e qualquer mudança na classe B pode gerar um impacto na classe A e em todas as outras classes que utilizam a classe B.

> Classes muito acopladas causam fragilidade no código, o que dificulta a manutenção.

**Exemplo de código com alto acoplamento**:

```java
// quebra de encapsulamento e dados manipulados fora da classe
Funcionario funcionario = carregaDoBancoDeDados();
float totalReajustes = 0;
List<Reajuste> reajustes = funcionario.getReajustes();

for (Reajuste r : reajustes)
	totalReajustes += r.getValor();
```

**Exemplo de código com baixo acoplamento**:

```java
// codigo coeso e encapsulado, fácil de usar
Funcionario funcionario = carregaDoBancoDeDados();
float reajustes = funcionario.getTotalRecebidoEmReajustes();
```

> A falta de encapsulamento leva a um maior acoplamento.
> “Alta coesão, baixo acoplamento”!
> **Refatorações servem para melhorar o design do código, e não o funcionamento do sistema. Uma refatoração não deve influenciar em nada no funcionamento**.
> Favorecer a composição ao invés da herança.
> É mais interessante e mais seguro para o nosso código depender de interfaces (classes abstratas, assinaturas de métodos e interfaces em si) do que das implementações de uma classe, pois interfaces são menos propensas a sofrer mudanças, enquanto implementações podem mudar a qualquer momento.
> As interfaces devem definir apenas os métodos que fazem sentido para seu contexto e uma classe não deve ser obrigada a implementar um método que ela não precisa.

---

## Single Responsibility Principle

O princípio da responsabilidade única quer dizer, basicamente, que “só por que é possível ter um sistema inteiro escrito dentro de uma única classe, não quer dizer que isso deve ser feito”; quando encontramos este tipo de situação, está ferindo a coesão.

O termo **Single Responsibility Principle** foi cunhado pelo Uncle Bob com a ideia de que “uma classe (ou módulo, função, etc.) deveria ter um único motivo para mudar”; isso significa que a classe só deve mudar por motivos relacionados a ela.

Por exemplo, a classe `Funcionario` só deveria mudar quando houver alguma alteração na representação de um funcionário; então quando for alterado o jeito de enviar um e-mail no sistema, o jeito de gerar um relatório, o acesso ao banco de dados, etc. isso não deve impactar na classe `Funcionario`. Ela pode mudar quando for alterado o atributo "nome" ou o atributo "salario"; estes são dois motivos para mudar, mas eles estão relacionados entre si, se referem a mesma coisa. Essa é a ideia desse princípio, com o foco justamente em coesão.

## Open Closed Principle

Este princípio coloca que “entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, porém fechadas para modificação”, ou seja, quanto menos necessitarmos mexer em uma classe existente, melhor.

Exemplificando: nós temos que mexer no código quando é uma mudança de uma regra já existente, então em vez de, para toda nova regra de negócio ou toda nova validação, adicionarmos um novo código e alterarmos uma classe existente, nós conseguimos extrair esta lógica utilizando interfaces e polimorfismo.

Sempre será necessário alterar o software, adicionar novas funcionalidades, novas validações, algoritmos, regras, etc. Então precisamos escrever o código de uma maneira que não o deixamos engessado; temos que fazer o design do código de uma maneira que ele consiga ser extensível, sempre adicionando novos comportamentos e evitando ao máximo mexer em código existente para adicionar algo novo.

## Liskov Substitution Principle

> If it looks like a duck and quacks like a duck but it needs batteries, you probably have the wrong abstraction.

O princípio da substituição de Liskov (Barbara Liskov) constata que “se q(x) é uma propriedade demonstrável dos objetos x de tipo T, então q(y) deve ser verdadeiro para objetos y de tipo S, onde S é um subtipo de T”.

Ou seja: se eu tenho uma função que recebe um objeto do tipo T, ela tem um comportamento; se eu tenho um objeto do tipo S que herda de T, ao passar esse objeto para a mesma função não deve ser gerado nenhum efeito colateral. Se ocorrer um efeito colateral (ou ifs e elses para o tipo), o princípio não foi respeitado e o código pode ser inconsistente.

Quando usamos herança de maneira errada, acabamos tendo um comportamento inesperado; podemos ter classes que são parecidas e tentamos usar herança para reaproveitar, mas isso pode gerar um efeito colateral difícil de perceber: o código vai compilar normalmente, mas podemos estar ferindo as regras de negócio. Para evitar isso, podemos utilizar composição.

## Interface Segregation Principle

“Uma classe não deveria ser forçada a depender de métodos que não utilizará” (Uncle Bob); é semelhante ao princípio da substituição de Liskov.

Às vezes precisamos definir um novo método em uma interface, mas ele não vai fazer sentido para todas as classes que implementam esta interface, logo elas não deveria ser obrigadas a implementá-lo.

Para resolver isso, podemos criar uma nova interface que herda da anterior os métodos em comum de ambas, mas na nova implementamos os métodos mais específicos. Outra forma de resolver seria criar a outra interface sem herança, fazendo com que a classe que necessitar de ambas implemente as duas interfaces.

## Dependency Inversion Principle

“Abstrações não devem depender de implementações. Implementações devem depender de abstrações” (Uncle Bob). Por exemplo:

```java
public class ReajusteServices {
  private List<ValidacaoReajuste> validacoes;

  public ReajusteServices(List<ValidacaoReajuste> validacoes) {
    this.validacoes = validacoes;
  }

  public void reajustaSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
    this.validacoes.forEach(v -> v.validar(funcionario, aumento));

    BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
    funcionario.atualizaSalario(salarioReajustado);
  }
}

interface ValidacaoReajuste {
  void validar(Funcionario funcionario, BigDecimal aumento);
}
```

No código acima, as implementações da validação dependem de uma abstração, representada pela interface `ValidacaoReajuste`; dessa forma, são as implementações que estão dependendo da abstração, e não a abstração que está dependendo de uma implementação específica, até por que é possível ter mais de uma implementação, ou pode haver a necessidade de alterar essa implementação.

A vantagem em depender de interfaces e não de implementações é que não seremos afetados caso a implementação mude; ou seja, com a interface mantida, mesmo que a forma como um método executa uma tarefa seja alterada, não será necessário editar o código
