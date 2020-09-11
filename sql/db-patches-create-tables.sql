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

CREATE TABLE persons(
   id INT AUTO_INCREMENT,
   dni VARCHAR(7) NOT NULL UNIQUE,
   name VARCHAR(30) NOT NULL,
   father_last_name VARCHAR(30) NOT NULL,
   mother_last_name VARCHAR(30) NOT NULL,
   birth_date DATE NOT NULL,
   telephone TEXT NOT NULL,
   address TEXT NOT NULL,
   email TEXT,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE person_demandant(
   id INT AUTO_INCREMENT,
   id_process INT NOT NULL,
   id_person INT NOT NULL,
   FOREIGN KEY (id_process) REFERENCES process(id),
   FOREIGN KEY (id_person) REFERENCES persons(id)
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE person_defendant(
   id INT AUTO_INCREMENT,
   id_process INT NOT NULL,
   id_person INT NOT NULL,
   FOREIGN KEY (id_process) REFERENCES process(id),
   FOREIGN KEY (id_person) REFERENCES persons(id)
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;