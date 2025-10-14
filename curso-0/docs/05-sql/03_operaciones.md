# Operaciones en Bases de Datos Relacionales

Para poder trabajar con bases de datos, además de seleccionar correctamente el SGBD teniendo en cuenta nuestras necesidades, también debemos de contar con un **Servidor de Bases de Datos**.

Generalmente cuando trabajamos en la nube o en un sistema que ya se encuentra productivo, contamos con un servidor justamente en la nube o físico (dependiendo de la situación) dedicado exclusivamente para la gestión de las bases de datos; sin embargo, si trabajamos de forma local, es usual que debamos configurar servidores locales de bases de datos para poder hacer las pruebas y planteos necesarios de nuestra base de datos para después poder llevarlo a un ambiente productivo.

Para esto, existen programas que nos permiten simular estos servidores de bases de datos de forma local; si bien existen varios, te dejamos a continuación un tutorial paso a paso de uno de los más utilizados:

<br>

### XAMPP Server (válido para Linux, Windows y Mac OS)

[![](./resources/instalar-xampp-screenshot.png)](https://youtu.be/pwTbAKRiRvA)

> [Descargar XAMPP](https://www.apachefriends.org/download.html)

<br>

## Introducción a SQL (_Structured Query Language_)

**SQL** o **Lenguaje de Consultas Estructurado** (por sus siglas en inglés), es un lenguaje que nos permite crear "consultas" para obtener determinados datos o información que se encuentran dentro de una base de datos.

Las consultas SQL permiten principalmente realizar operaciones de alta, baja, modificación y/o lectura/recuperación de datos, para ello, hace uso de diferentes estructuras y palabras clave en su sintaxis.

<br>

## Comandos Básicos de SQL

### CREATE DATABASE (Creación de Base de Datos)

El comando **CREATE DATABASE** se usa para crear una nueva base de datos en un sistema de gestión de bases de datos, como MySQL.

```sql
CREATE DATABASE mi_basedatos;
```

<br>

## Operaciones con Tablas en SQL

### CREATE TABLE (Creación de Tablas)

El comando **CREATE TABLE** en SQL se utiliza para crear una nueva tabla dentro de una base de datos.

```sql
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    email VARCHAR(100),
    fecha_nacimiento DATE
);
```

<br>

### INSERT INTO (Inserción de Registros)

El comando **INSERT INTO** en SQL se utiliza para insertar nuevos registros en una tabla existente.

```sql
INSERT INTO usuarios (nombre, email, fecha_nacimiento)
VALUES ('Juan Pérez', 'juan@example.com', '1990-05-15');
```

<br>

## Consultas en SQL

### SELECT (Lectura de Datos)

La instrucción **SQL SELECT** se utiliza para recuperar datos de una base de datos.

```sql
SELECT * FROM empleados;
```

<br>

### WHERE (Filtrado de Datos)

La cláusula **WHERE** permite aplicar condiciones a una consulta para obtener registros específicos.

```sql
SELECT * FROM empleados WHERE puesto = 'Desarrollador de Software';
```

<br>

## Modificación y Eliminación de Datos en SQL

### UPDATE (Modificación de Registros)

El comando **UPDATE** se utiliza para modificar los datos existentes en una tabla.

```sql
UPDATE usuarios SET email = 'nuevo_correo@example.com' WHERE nombre = 'Juan Pérez';
```

<br>

### DELETE (Eliminación de Registros)

El comando **DELETE** se utiliza para eliminar registros de una tabla.

```sql
DELETE FROM usuarios WHERE nombre = 'Juan Pérez';
```

---
⬅ [Anterior: Relaciones](02_relaciones.md) | 📂 [Volver al índice](../README.md) 