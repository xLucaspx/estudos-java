-- Create database and tables:
CREATE SCHEMA `book_management`;
USE `book_management`;

CREATE TABLE `publisher` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `genre` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `author` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `nationality` VARCHAR(50) NOT NULL
);

CREATE TABLE `book` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(75) NOT NULL,
  `isbn_10` VARCHAR(10),
  `isbn_13` VARCHAR(13) NOT NULL,
  `pages` INT NOT NULL,
  `read` BOOLEAN NOT NULL DEFAULT false,
  `format` ENUM('Hardcover', 'Paperback', 'Ebook', 'Box') NOT NULL,
  `author_id` INT NOT NULL,
  `publisher_id` INT NOT NULL,
  `purchase_date` DATE,
  `price` FLOAT(5, 2) NOT NULL,
  `review` TEXT,
  CONSTRAINT FK_author_code FOREIGN KEY (author_id)
      REFERENCES author(id),
  CONSTRAINT FK_publisher_code FOREIGN KEY (publisher_id)
      REFERENCES publisher(id)
);

CREATE TABLE `book_genre` (
  `book_id` INT,
  `genre_id` INT,
  PRIMARY KEY (`book_id` , `genre_id`),
  CONSTRAINT FK_book_code FOREIGN KEY (book_id)
      REFERENCES book (id) ON DELETE CASCADE,
  CONSTRAINT FK_genre_code FOREIGN KEY (genre_id)
      REFERENCES genre (id)
);

-- Create functions:
DELIMITER $$

CREATE FUNCTION countBooksByRead(readStatus BOOLEAN)
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(`id`) FROM `book` WHERE `read` = readStatus);
END $$

CREATE FUNCTION countBooksByFormat(formatCode INT)
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(`id`) FROM `book` WHERE `format` = formatCode);
END $$

CREATE FUNCTION countBooksByAuthor(authorId INT)
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(`id`) FROM `book` WHERE `author_id` = authorId);
END $$

CREATE FUNCTION countBooksByPublisher(publisherId INT)
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(`id`) FROM `book` WHERE `publisher_id` = publisherId);
END $$

CREATE FUNCTION countBooksByGenre(genreId INT)
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(`book_id`) FROM `book_genre` WHERE `genre_id` = genreId);
END $$

DELIMITER ;
