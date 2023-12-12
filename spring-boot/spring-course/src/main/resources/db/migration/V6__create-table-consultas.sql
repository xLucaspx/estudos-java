CREATE TABLE consultas (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_medico INT NOT NULL,
	id_paciente INT NOT NULL,
	data DATETIME NOT NULL,
	CONSTRAINT FK_consultas_medicos FOREIGN KEY (id_medico) REFERENCES medicos(id),
	CONSTRAINT FK_consultas_pacientes FOREIGN KEY (id_paciente) REFERENCES pacientes(id)
);
