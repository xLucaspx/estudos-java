CREATE TABLE usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(75) NOT NULL UNIQUE,
	hash_senha VARCHAR(128) NOT NULL
);
