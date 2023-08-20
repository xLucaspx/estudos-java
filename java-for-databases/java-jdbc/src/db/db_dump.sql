CREATE TABLE `conta` (
  `numero` int PRIMARY KEY,
  `saldo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `nome_titular` varchar(50) NOT NULL,
  `cpf_titular` varchar(11) NOT NULL,
  `email_titular` varchar(50) NOT NULL,
  `ativa` boolean NOT NULL DEFAULT true
);
