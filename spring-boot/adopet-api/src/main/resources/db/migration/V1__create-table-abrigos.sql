CREATE TABLE abrigos(
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(75) NOT NULL,
  telefone VARCHAR(17) NOT NULL UNIQUE,
  email VARCHAT(75) NOT NULL UNIQUE,
  PRIMARY KEY(id)
);
