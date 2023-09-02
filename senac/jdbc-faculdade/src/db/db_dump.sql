CREATE TABLE `professor` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `salario` decimal(10,2) NOT NULL
);

CREATE TABLE `aluno` (
  `matricula` int PRIMARY KEY,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
);
