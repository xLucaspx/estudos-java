# Trabalho final de Fundamentos de Programação

O objetivo deste trabalho é implementar um programa que gerencia doações recebidas e entregues a pessoas necessitadas em uma situação de calamidade. Será necessário implementar:

- Classe `Pessoa` contendo CPF, nome, e-mail, telefone, lista de doacoes recebidas;
- Classe `Doacao` contendo código da doação, nome/descrição do item e quantidade de itens doados.

Estas duas classes deverão ter:

- Métodos set e construtor com validações;
- Métodos get;
- Método toString.

Na classe `Pessoa` também é necessário um método que adiciona uma doação recebida pela pessoa; quando uma pessoa recebe uma doação, esta deverá ser retirada da lista de doacoes ou a quantidade de itens desta doação deve ser diminuída.

A seguir, deve ser implementada a classe `ListaPessoa`. Defina os seguintes métodos, necessários para manipular essa lista:

- Método que cadastra uma pessoa (não podem ter pessoas com o mesmo CPF na lista);
- Método que consulta uma pessoa pelo CPF;
- Método que ordena todas as pessoas pelo CPF;
- Método que ordena todas as pessoas pelo nome;
- Método que altera o email de uma pessoa, localizando a pessoa pelo CPF;
- Método que lista todas as pessoas cadastradas.


Deve ser implementada, também, a classe `ListaDoacao`. Defina os seguintes métodos, necessários para manipular essa lista:

- Método que cadastra uma doação (só podem ser criadas novas doações quando estas ainda não tenham sido cadastradas);
- Método que consulta uma doação pelo nome dado ao item;
- Método que adiciona quantidades de itens para uma doação já existente;
- Método que retorna todas as doações que tem um número maior ou igual a X de itens na lista;
- Método que retira itens de uma determinada doação;
- Método que imprime todas as doações.

Implemente uma classe `App`. O menu de opções deverá ter ações para cada um dos métodos requeridos nas classes que implementam as listas; além disso, o menu deverá oferecer uma opção onde uma pessoa cadastrada poderá escolher um item para receber como doação.
**Exemplo**: _A Ana Paula pegou 2 cobertores_.
