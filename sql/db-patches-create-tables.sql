CREATE TABLE users(
   id INT AUTO_INCREMENT,
   username VARCHAR(10) NOT NULL UNIQUE,
   password VARCHAR(10) NOT NULL,
   dni VARCHAR(7) NOT NULL UNIQUE,
   name VARCHAR(30) NOT NULL,
   father_last_name VARCHAR(30) NOT NULL,
   mother_last_name VARCHAR(30) NOT NULL,
   birth_date DATE NOT NULL,
   telephone TEXT NOT NULL,
   address TEXT NOT NULL,
   email TEXT NOT NULL,
   type VARCHAR(6) NOT NULL,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE person(
   id INT AUTO_INCREMENT,
   dni VARCHAR(7) NOT NULL UNIQUE,
   name VARCHAR(30) NOT NULL,
   father_last_name VARCHAR(30) NOT NULL,
   mother_last_name VARCHAR(30) NOT NULL,
   birth_date DATE NOT NULL,
   telephone TEXT NOT NULL,
   address TEXT NOT NULL,
   email TEXT NOT,
)AUTO_INCREMENT=1000;
