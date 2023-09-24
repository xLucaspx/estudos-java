# Book management system

Um leitor assíduo que possui um grande número de peças literárias em diversos formatos deseja um sistema onde possa armazenar informações da sua coleção, como por exemplo: título, autor, número de páginas, categoria, data da compra, preço de custo, etc.

O cliente também deseja a opção de marcar se já leu aquela peça e armazenar uma resenha contendo sua opinião. Outro requisito é armazenar informações dos autores, como a nacionalidade e quantos livros daquele autor existem na coleção do cliente.

## Database

In this project we're going to use MySQL for the database. To create and use the database, use the following commands:

```sql
CREATE SCHEMA IF NOT EXISTS library;
USE library;
```

### Table: format

The `format` table is meant for storing the variation of the piece, eg.: paperback, hardcover, ebook, etc.

```sql
CREATE TABLE IF NOT EXISTS `format` (
  id INT PRIMARY KEY AUTO_INCREMENT,
  `format` VARCHAR(20) NOT NULL
);
```

### Table: category

The `category` table is meant for storing all the different categories; the books may have between one and three categories.

```sql
CREATE TABLE IF NOT EXISTS category (
  id INT PRIMARY KEY AUTO_INCREMENT,
  category VARCHAR(50) NOT NULL
);
```

### Table: author

The `author` table is meant to store informations about the author as well as how many of his books are stored in the collection.

```sql
CREATE TABLE IF NOT EXISTS author (
  id INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  nationality VARCHAR(50) NOT NULL,
  books_owned INT DEFAULT 0
);
```

### Table: book

The `book` table is obviously meant to keep informations about the books.

```sql
CREATE TABLE IF NOT EXISTS book (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  isbn VARCHAR(13) NOT NULL,
  pages INT NOT NULL,
  `read` BOOLEAN DEFAULT false,
  author_id INT NOT NULL,
  format_id INT NOT NULL,
  puchase_date DATE DEFAULT null,
  price FLOAT(3, 2) NOT NULL,
  review TEXT DEFAULT null,
  CONSTRAINT FK_author_code FOREIGN KEY (author_id)
      REFERENCES author(id),
  CONSTRAINT FK_format_code FOREIGN KEY (format_id)
      REFERENCES `format`(id)
);
```

### Table: book_category

This table is meant for the `book`and `category` tables relationship. Remember: books may have between one and three categories.

```sql
CREATE TABLE IF NOT EXISTS book_category (
  book_id INT,
  category_id INT,
  PRIMARY KEY (book_id , category_id),
  CONSTRAINT FK_book_code FOREIGN KEY (book_id)
      REFERENCES book (id),
  CONSTRAINT FK_category_code FOREIGN KEY (category_id)
      REFERENCES category (id)
);
```

## International Standard Book Number (ISBN)

The International Standard Book Number (ISBN) is a numeric commercial book identifier that is intended to be unique. An ISBN is assigned to each separate edition and variation (except reprintings) of a publication; for example, an e-book, a paperback and a hardcover edition of the same book will each have a different ISBN.

The ISBN is ten digits long if assigned before 2007, and thirteen digits long if assigned on or after 1 January 2007. If you were assigned 10-digit ISBNs, you can convert them to the 13-digit format at the converter found on the ISBN website.

### Links and references for ISBN

- [ISBN Converter](https://www.isbn.org/ISBN_converter);
- [ISBN and ISSN Systems: General Information and Resources](https://libguides.ala.org/isbn-issn#:~:text=ISBN%20General%20Information,whether%20printed%2C%20audio%20or%20electronic.);
- [ISBN - Wikipedia](https://en.wikipedia.org/wiki/ISBN).

## Tasks

[ ] Create SQL procedure to update `author`.`books_owned`.

## Design and screens

### Home

### Register Auhtor

### Register Category

### Register Book

### Authors Table

### Categories Table

### Books Table
