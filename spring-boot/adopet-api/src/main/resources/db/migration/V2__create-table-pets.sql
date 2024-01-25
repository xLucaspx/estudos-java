CREATE TABLE pets (
  id INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(50) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  raca VARCHAR(50) NOT NULL,
  idade INT NOT NULL,
  cor VARCHAR(25) NOT NULL,
  peso DECIMAL(4,2) NOT NULL,
  abrigo_id INT NOT NULL,
  adotado BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY(id),
  CONSTRAINT fk_pets_abrigo_id FOREIGN KEY (abrigo_id) REFERENCES abrigos(id)
);
