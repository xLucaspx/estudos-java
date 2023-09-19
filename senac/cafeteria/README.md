# Sistema de cafeteria

- Tabela de clientes: a cada R$ 1000 em compras ganha um bônus
- Tabela de cafés: grão, tamanho (ml), preço, c/leite, vegano
- Tabela de opcionais: (chantilly, mel, canela, açúcar-mascavo, etc), nome, preço, vegano
- Tabela de comidas: nome, unidade/tamanho (1 un/200gr)??, tipo (salgado, doce), vegano
- compras: guardar id do cliente, data e valor da compra

Uma cafeteria deseja manter um sistema de vendas com cadastro de clientes. Dos **clientes**, é relevante guardar `nome`, `data de nascimento`, `telefone`, `email` e `cpf`. Para os **cafés**, desejam guardar o `tipo de grão`, `tamanho (ml)`, `preço` e se é `com leite`; também deve ser possível adicionar **opcionais** - como mel, canela ou chantilly - nos cafés. Para as **comidas**, desejam armazenar o `nome`, `tamanho (gr)` e `tipo` (se é salgado ou doce). Todos os cafés, comidas e opcionais devem ter um `nome`e um `preço`, além de serem sinzalizados como `veganos` ou não.
A cafeteria também deseja presentear cada cliente cadastrado que atingir R$ 1000 em compras no período de 1 ano, então deve ser armazenada a `data da compra` e o `código do cliente`.

```sql
CREATE DATABASE IF NOT EXISTS cafeteria;
USE cafeteria;

CREATE TABLE IF NOT EXISTS cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(75) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS produto (
    codigo VARCHAR(25) PRIMARY KEY,
    nome VARCHAR(75) NOT NULL,
    vegano BOOLEAN NOT NULL DEFAULT FALSE,
    preco FLOAT(3 , 2 ) NOT NULL
);

CREATE TABLE IF NOT EXISTS cafe (
    codigo VARCHAR(25) PRIMARY KEY,
    grao VARCHAR(20) NOT NULL,
    tamanho VARCHAR(10) NOT NULL,
    com_leite BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT FK_codigo_cafe FOREIGN KEY (codigo)
        REFERENCES produto (codigo)
);

CREATE TABLE IF NOT EXISTS opcional (
    codigo VARCHAR(25) PRIMARY KEY,
    CONSTRAINT FK_codigo_opcional FOREIGN KEY (codigo)
        REFERENCES produto (codigo)
);

CREATE TABLE IF NOT EXISTS comida (
    codigo VARCHAR(25) PRIMARY KEY,
    tamanho VARCHAR(10) NOT NULL,
    tipo VARCHAR(20),
    CONSTRAINT FK_codigo_comida FOREIGN KEY (codigo)
        REFERENCES produto (codigo)
);

CREATE TABLE IF NOT EXISTS nota_venda (
    numero INT PRIMARY KEY,
    data_venda DATE NOT NULL,
    cpf_cliente VARCHAR(11) DEFAULT NULL,
    CONSTRAINT FK_cpf_nota FOREIGN KEY (cpf_cliente)
        REFERENCES cliente (cpf)
);

CREATE TABLE IF NOT EXISTS itens_nota_venda (
    numero_nota INT NOT NULL,
    codigo_item VARCHAR(25) NOT NULL,
    preco FLOAT(3 , 2 ) NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (numero_nota , codigo_item),
    CONSTRAINT FK_numero_nota FOREIGN KEY (numero_nota)
        REFERENCES nota_venda (numero),
    CONSTRAINT FK_item_nota FOREIGN KEY (codigo_item)
        REFERENCES produto (codigo)
);
```
