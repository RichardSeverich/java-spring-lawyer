-- CREATE DATA BASES
CREATE DATABASE lawyer;

-- DELETE DATA BASES
DROP DATABASE lawyer;

-- SELECT ALL DATA: show all rows.
SELECT * FROM users;

-- DELETE ALL DATA: delete all rows
TRUNCATE TABLE users;

-- DELETE TABLE: detele the table.
DROP TABLE users;

-- WHERE CONDITIONAL

SELECT previous_character.*
FROM previous_character
WHERE previous_character.id_process = 1001;

SELECT * FROM process_type
WHERE process_type.id_matter = 1002;

SELECT * FROM sub_process_type
WHERE sub_process_type.id_process_type = 1002;

-- INER JOINS
SELECT nombreColumna(s)
FROM tabla1
INNER JOIN tabla2
ON tabla1.nombreColumna = table2.nombreColumna;

SELECT *
FROM persons
INNER JOIN person_defendant
ON persons.id=person_defendant.id_person;

-- INER JOINS WHERE CONDITIONAL
SELECT persons.*
FROM persons
INNER JOIN person_defendant
ON persons.id=person_defendant.id_person
WHERE person_defendant.id_process = 1001;

SELECT persons.*
FROM persons
INNER JOIN person_demandant
ON persons.id=person_demandant.id_person
WHERE person_demandant.id_process = 1001;

-- AUTHENTICATION
SELECT * FROM users WHERE username = 'admin' AND password = 'admin123';