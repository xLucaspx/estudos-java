create table adocoes(
  id INT NOT NULL AUTO_INCREMENT,
  data DATETIME NOT NULL,
  tutor_id INT NOT NULL,
  pet_id INT NOT NULL,
  motivo VARCHAR(255) NOT NULL,
  status VARCHAR(100) NOT NULL,
  justificativa_status VARCHAR(255),
  PRIMARY KEY(id),
  CONSTRAINT fk_adocoes_tutor_id foreign key(tutor_id) REFERENCES tutores(id),
  CONSTRAINT fk_adocoes_pet_id foreign key(pet_id) REFERENCES pets(id)
);
