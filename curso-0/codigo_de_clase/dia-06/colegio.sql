-- Active: 1698742717167@@127.0.0.1@3306@colegio
-- Crear la base de datos colegio si no existe
Create DATABASE IF NOT EXISTS colegio;

-- Usar la base de datos colegio
USE colegio;

-- Eliminar tablas en orden inverso al de creación
DROP TABLE IF EXISTS profesores_asignaturas, asignaturas, telefonos, documentos_identidad, profesores;

-- Crear la tabla de profesores
CREATE TABLE IF NOT EXISTS profesores (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  primerApellido VARCHAR(50) NOT NULL,
  segundoApellido VARCHAR(50) NOT NULL,
  sexo ENUM('Hombre', 'Mujer', 'Otro') NOT NULL,
  fechaNacimiento DATE NOT NULL,
  correo VARCHAR(100) NOT NULL UNIQUE,
  jefeDepartamentoId INT UNSIGNED,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (jefeDepartamentoId) REFERENCES profesores(id) ON DELETE SET NULL
);

-- Crear la tabla documentos de identidad
CREATE TABLE IF NOT EXISTS documentos_identidad (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  tipo VARCHAR(20) NOT NULL,
  numero VARCHAR(20) NOT NULL UNIQUE,
  profesorId INT UNSIGNED NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (profesorId) REFERENCES profesores(id) ON DELETE CASCADE
);

-- Crear la tabla de telefonos
CREATE TABLE IF NOT EXISTS telefonos (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  numero VARCHAR(15) NOT NULL,
  tipo ENUM('móvil', 'fijo') NOT NULL,
  profesorId INT UNSIGNED NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (profesorId) REFERENCES profesores(id) ON DELETE CASCADE
);

-- Crear la tabla de asignaturas
CREATE TABLE IF NOT EXISTS asignaturas (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL UNIQUE,
  horas TINYINT UNSIGNED NOT NULL,
  creditos TINYINT UNSIGNED NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear la tabla de profesores_asignaturas
CREATE TABLE IF NOT EXISTS profesores_asignaturas (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  profesorId INT UNSIGNED NOT NULL,
  asignaturaId INT UNSIGNED NOT NULL,
  UNIQUE (profesorId, asignaturaId),
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (profesorId) REFERENCES profesores(id) ON DELETE CASCADE,
  FOREIGN KEY (asignaturaId) REFERENCES asignaturas(id) ON DELETE CASCADE
);


-- Insertar profesores
INSERT INTO profesores (nombre, primerApellido, segundoApellido, sexo, fechaNacimiento, correo, jefeDepartamentoId) VALUES
('Juan', 'Pérez', 'Gómez', 'Hombre', '1980-01-01', 'juan.perez@example.com', NULL),
('Ana', 'Gómez', 'Ruiz', 'Mujer', '1985-02-02', 'ana.gomez@example.com', 1),
('Carlos', 'Ruiz', 'García', 'Hombre', '1990-03-03', 'carlos.ruiz@example.com', 1),
('María', 'López', 'Fernández', 'Mujer', '1995-04-04', 'maria.lopez@example.com', 2);

-- Insertar documentos de identidad
INSERT INTO documentos_identidad (tipo, numero, profesorId) VALUES
('DNI', '12345678A', 1),
('NIE', 'Y1234567B', 2),
('Pasaporte', 'X1234567C', 3),
('DNI', '87654321D', 4);

-- Insertar teléfonos
INSERT INTO telefonos (numero, tipo, profesorId) VALUES
('123456789', 'móvil', 1),
('981654321', 'fijo', 1),
('456789123', 'móvil', 2),
('981654987', 'fijo', 3),
('789123456', 'móvil', 4),
('981321789', 'fijo', 4);

-- Insertar asignaturas
INSERT INTO asignaturas (nombre, horas, creditos) VALUES
('Matemáticas', 4, 6),
('Historia', 3, 4),
('Programación', 5, 8);

-- Insertar relación profesores_asignaturas
INSERT INTO profesores_asignaturas (profesorId, asignaturaId) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 2),
(3, 3),
(4, 1);

-- Consultas de ejemplo
-- 1. Obtener todo de todos los profesores
SELECT *
  FROM profesores;

-- 2. Obtener todo de todos los documentos_identidad
SELECT *
  FROM documentos_identidad;

-- 3. Obtener todo de todos los telefonos
SELECT *
  FROM telefonos;

-- 4. Obtener todo de todas las asignaturas

SELECT *
  FROM asignaturas;

-- 5. Obtener todo de todas las relaciones profesores_asignaturas
SELECT *
  FROM profesores_asignaturas;

-- Consultas con JOINs

-- 1. Obtener todo de los profesores que son jefes
SELECT DISTINCT *
  FROM profesores
  WHERE id IN (SELECT jefeDepartamentoId FROM profesores WHERE jefeDepartamentoId IS NOT NULL);
SELECT DISTINCT P.*
  FROM profesores P
  JOIN profesores PJ ON P.id = PJ.jefeDepartamentoId;

-- 2. Obtener nombre y apellidos de los profesores con sus documentos de identidad
SELECT P.nombre, P.primerApellido, P.segundoApellido, D.tipo, D.numero
  FROM profesores P
  LEFT JOIN documentos_identidad D ON P.id = D.profesorId;

-- 3. Obtener nombre y apellidos de los profesores con sus teléfonos
SELECT P.nombre, P.primerApellido, P.segundoApellido, T.numero, T.tipo
  FROM profesores P
  LEFT JOIN telefonos T ON P.id = T.profesorId;

-- 4. Obtener nombre y apellidos de los profesores con sus asignaturas
SELECT P.nombre, P.primerApellido, P.segundoApellido, A.nombre AS asignatura
  FROM profesores P
  LEFT JOIN profesores_asignaturas PA ON P.id = PA.profesorId
  LEFT JOIN asignaturas A ON PA.asignaturaId = A.id
  ORDER BY A.nombre;

-- Modificaciones de datos
-- 1. Actualizar el correo de un profesor
UPDATE profesores
  SET nombre= 'Jose', correo = 'jose.perez@example.com'
  WHERE id = 1;

-- 2. Eliminar un profesor y sus documentos de identidad y teléfonos asociados
DELETE FROM profesores
  WHERE id = 2;