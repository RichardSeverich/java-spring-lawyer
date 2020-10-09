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

-- INER JOINS
SELECT nombreColumna(s)
FROM tabla1
INNER JOIN tabla2
ON tabla1.nombreColumna=table2.nombreColumna;

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

-- AUTHENTICATION
SELECT * FROM users WHERE username = 'admin' AND password = 'admin123';