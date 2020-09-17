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
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
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
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE process(
   id INT AUTO_INCREMENT,
   description TEXT NOT NULL,
   number_process TEXT NOT NULL,
   court_number TEXT NOT NULL,
   matter TEXT NOT NULL,
   process_type TEXT NOT NULL,
   process_type_sub TEXT NOT NULL,
   admission_date DATE NOT NULL,
   preliminary_audience_date DATE NOT NULL,
   supplementary_audience_date DATE NOT NULL,
   appeal_date DATE NOT NULL,
   casacion_date DATE NOT NULL,
   execution_sentence_date DATE NOT NULL,
   state TEXT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE person_demandant(
   id INT AUTO_INCREMENT,
   id_process INT NOT NULL,
   id_person INT NOT NULL,
   FOREIGN KEY (id_process) REFERENCES process(id),
   FOREIGN KEY (id_person) REFERENCES persons(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE person_defendant(
   id INT AUTO_INCREMENT,
   id_process INT NOT NULL,
   id_person INT NOT NULL,
   FOREIGN KEY (id_process) REFERENCES process(id),
   FOREIGN KEY (id_person) REFERENCES persons(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE previous_character(
   id INT AUTO_INCREMENT,
   id_process INT NOT NULL,
   notification_date DATE NOT NULL,
   description TEXT NOT NULL,
   state TEXT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (id_process) REFERENCES process(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE matter(
   id INT AUTO_INCREMENT,
   name TEXT NOT NULL,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE process_type(
   id INT AUTO_INCREMENT,
   id_matter INT NOT NULL,
   name TEXT NOT NULL,
   FOREIGN KEY (id_matter) REFERENCES matter(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE sub_process_type(
   id INT AUTO_INCREMENT,
   id_process_type INT NOT NULL,
   name TEXT NOT NULL,
   FOREIGN KEY (id_process_type) REFERENCES process_type(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
