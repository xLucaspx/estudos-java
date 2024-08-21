# Book management system

Um leitor assíduo que possui um grande número de peças literárias em diversos formatos deseja um sistema onde possa armazenar informações da sua coleção, como por exemplo: título, autor, número de páginas, categoria, data da compra, preço de custo, etc. Para ele também é interessante guardar qual a editora e o formato de cada livro.
O cliente também deseja a opção de marcar se já leu aquela peça e armazenar uma resenha contendo sua opinião; outro requisito é armazenar informações dos autores, como a nacionalidade e quantos livros daquele autor existem na coleção do cliente.

## Database and tables

In this project we're going to use MySQL for the database. To create the database and the tables, use the following commands:

```sql
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
  `title` VARCHAR(50) NOT NULL,
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
```

The format column in the book table is an Enum that allows the following values:

| Enum        | Index |
| ----------- | ----- |
| `Hardcover` | 1     |
| `Paperback` | 2     |
| `Ebook`     | 3     |
| `Box`       | 4     |

### SQL Functions

We've created SQL functions to easily retrieve the number of books read or the amount of books owned that belongs to a certain criteria; are tyhey:

| Function              | Parameters                | Returns                                                                                 | Example                                                                           |
| --------------------- | ------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| countBooksByRead      | `BOOLEAN` _readStatus_    | the total of books with the read value corresponding to the _readStatus_ parameter      | `SELECT countBooksByRead(true) AS 'Total read books';`                            |
| countBooksByFormat    | `INT` _formatCode_        | the total of books with the format value corresponding to the _formatCode_ parameter    | `SELECT format, countBooksByFormat(format) AS 'total' FROM book GROUP BY format;` |
| countBooksByAuthor    | `INT` _authorId_          | the total of books owned by the author with the corresponding ID                        | `SELECT name, countBooksByAuthor(id) AS 'books owned' FROM author;`               |
| countBooksByPublisher | `INT` _publisherId_       | the total of books owned by the publisher with the corresponding ID                     | `SELECT name, countBooksByPublisher(id) AS 'books' FROM publisher;`               |
| countBooksByGenre     | `INT` _genreId_           | the total of books that are included in the corresponding genre                         | `SELECT name, countBooksByGenre(id) AS 'books owned' FROM genre;`                 |

To create these functions, run the following SQL script:

```sql
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
```

## International Standard Book Number (ISBN)

The International Standard Book Number (ISBN) is a numeric commercial book identifier that is intended to be unique. An ISBN is assigned to each separate edition and variation (except reprintings) of a publication; for example, an e-book, a paperback and a hardcover edition of the same book will each have a different ISBN.

The ISBN is ten digits long if assigned before 2007, and thirteen digits long if assigned on or after 1 January 2007. If you were assigned 10-digit ISBNs, you can convert them to the 13-digit format at the converter found on the ISBN website.

### Links and references for ISBN

- [ISBN Converter](https://www.isbn.org/ISBN_converter);
- [ISBN and ISSN Systems: General Information and Resources](https://libguides.ala.org/isbn-issn#:~:text=ISBN%20General%20Information,whether%20printed%2C%20audio%20or%20electronic.);
- [ISBN - Wikipedia](https://en.wikipedia.org/wiki/ISBN).

## Tasks

- [x] Add ISBN validation;
- [x] Convert ISBN-10 to ISBN-13;
- [ ] Implement filters in the views;
- [ ] Implement Dewey Decimal System (CDD and CDU).

## Design and screens

### Home

### Register Auhtor

### Register Category

### Register Book

### Authors Table

### Categories Table

### Books Table
