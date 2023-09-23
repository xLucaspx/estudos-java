CREATE SCHEMA IF NOT EXISTS library;
USE library;

CREATE TABLE IF NOT EXISTS `format` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `format` VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    nationality VARCHAR(50) NOT NULL,
    books_owned INT DEFAULT 0
);

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

CREATE TABLE IF NOT EXISTS book_category (
    book_id INT,
    category_id INT,
    PRIMARY KEY (book_id , category_id),
    CONSTRAINT FK_book_code FOREIGN KEY (book_id)
        REFERENCES book (id),
    CONSTRAINT FK_category_code FOREIGN KEY (category_id)
        REFERENCES category (id)
);
