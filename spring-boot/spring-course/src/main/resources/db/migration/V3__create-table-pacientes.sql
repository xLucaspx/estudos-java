CREATE TABLE pacientes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(75) NOT NULL,
	email VARCHAR(75) NOT NULL,
	cpf VARCHAR(11) UNIQUE,
	telefone VARCHAR(25) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	bairro VARCHAR(50) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	complemento VARCHAR(100),
	numero VARCHAR(10),
	uf VARCHAR(2) NOT NULL,
	cidade VARCHAR(50) NOT NULL
);