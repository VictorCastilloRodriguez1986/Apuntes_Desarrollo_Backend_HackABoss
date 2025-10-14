-- Active: 1698742717167@@127.0.0.1@3306@repaso_join
-- DROP DATABASE IF EXISTS repaso_join; -- Borramos la base de datos si existe

CREATE DATABASE IF NOT EXISTS repaso_join; -- Crear la DDBB si no existe

USE repaso_join;

-- Eliminar tablas en orden inverso al de creación
DROP TABLE IF EXISTS empleados, departamentos;

-- Creamos la tabla de departamentos
CREATE TABLE IF NOT EXISTS departamentos (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL
);

-- Creamos la tabla de empleados
CREATE TABLE IF NOT EXISTS empleados (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
	idDepartamento INT UNSIGNED,
	FOREIGN KEY (idDepartamento) REFERENCES departamentos (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO departamentos (nombre)
VALUES ('Ventas'), ('Académico'), ('Marketing'), ('Talento');

INSERT INTO empleados (nombre, idDepartamento)
VALUES ('Sara', 1), ('Andrea', 2), ('Juan', 2), ('Rafa', 3), ('Laura', null);


-- Inner Join
SELECT * FROM empleados E
JOIN departamentos D ON E.idDepartamento = D.id;
-- Laura no aparece porque no tiene departamento asociado y Talento no aparece porque no tiene ningun empleado

-- Left Join
SELECT * FROM empleados E
LEFT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestra todo de la tabla empleados aunque no tengan departamento asociado pero no veremos Talento

SELECT E.nombre, D.nombre  FROM empleados E
LEFT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestran los nombres de todos los empleados aunque no tengan departamento asociado y el nombre del departamento al que pertenecen
-- En caso de que no pertenezcan a ningun departamento se nos muestra null

SELECT E.nombre AS 'Empleado', IFNULL(D.nombre, 'Sin departamento') AS 'Departamento'  FROM empleados E
LEFT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestran los nombres de todos los empleados aunque no tengan departamento asociado y el nombre del departamento al que pertenecen
-- Las 2 entidades tienen el atributo nombre por lo que a la hora de ver el resultado he renombrado las columnas para que no haya ambigüedad
-- Con IFNULL le decimos que si el valor del atributo nombre de la tabla departamentos es null que nos muestre el texto que le pasamos como segundo parámetro

-- Right Join
SELECT * FROM empleados E
RIGHT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestra todo de la tabla departamentos aunque no tengan empleado asociado pero no veremos a Laura

SELECT E.nombre, D.nombre  FROM empleados E
RIGHT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestran los nombres de todos los departamentos aunque no tengan empleados asociado y el nombre del departamento al que pertenecen
-- En caso de que no tenga a ningun empleado se nos muestra null

SELECT IFNULL(E.nombre, 'Sin Empleados') AS 'Empleado' , D.nombre AS 'Departamento'  FROM empleados E
RIGHT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestran los nombres de todos los departamentos aunque no tengan empleados asociado y el nombre del departamento al que pertenecen
-- Las 2 entidades tienen el atributo nombre por lo que a la hora de ver el resultado he renombrado las columnas para que no haya ambigüedad
-- Con IFNULL le decimos que si el valor del atributo nombre de la tabla empleados es null que nos muestre el texto que le pasamos como segundo parámetro

SELECT E.nombre AS 'Empleado', IFNULL(D.nombre, 'Sin departamento') AS 'Departamento'  FROM empleados E
LEFT JOIN departamentos D ON E.idDepartamento = D.id;
-- Se nos muestran los nombres de todos los empleados aunque no tengan departamento asociado y el nombre del departamento al que pertenecen
-- Las 2 entidades tienen el atributo nombre por lo que a la hora de ver el resultado he renombrado las columnas para que no haya ambigüedad
-- Con IFNULL le decimos que si el valor del atributo nombre de la tabla departamento es null que nos muestre el texto que le pasamos como segundo parámetro 'Sin Departamento'

