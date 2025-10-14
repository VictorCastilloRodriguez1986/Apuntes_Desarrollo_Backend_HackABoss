# DDBB(Database) SQL

## DDBB(Database o Base de Datos)

Una base de datos es un sistema organizado para almacenar, gestionar y recuperar información de manera eficiente. Las bases de datos pueden ser relacionales, no relacionales, jerárquicas, entre otras. En este contexto, nos centraremos en las bases de datos relacionales, que utilizan tablas para organizar los datos.

---

## Porque usar DDBB

Antiguamente, los datos se almacenaban en archivos de texto, lo que dificultaba la gestión y recuperación de información.
Con la llegado de los ordenadores, se comenzaron a utilizar archivos digitales, pero seguían siendo difíciles de manejar.

- **`Redundancia`**: Los datos se duplicaban en múltiples archivos por lo que se desperdiciaba espacio.
- **`Inconsistencia`**: Se podía almacenal la información de manera diferente en distintos archivos, lo que generaba confusión.
- **`Dificultad de acceso`**: Buscar información específica en archivos grandes era complicado y lento.
- **`Seguridad`**: Los archivos eran vulnerables a pérdidas o daños, lo que podía resultar en la pérdida de datos importantes.
- **`Escalabilidad`**: A medida que la cantidad de datos crecía, se volvía más difícil gestionarlos de manera eficiente.

Con la evolución de la tecnología, surgieron las bases de datos, que permiten una gestión más eficiente y estructurada de los datos.

- **`Redundancia`**: Se almacena la información una sola vez, lo que ahorra espacio y evita duplicaciones innecesarias.
- **`Inconsistencia`**: Los datos se almacenan de manera uniforme, lo que garantiza la coherencia y precisión de la información.
- **`Dificultad de acceso`**: Las bases de datos permiten realizar consultas rápidas y eficientes para recuperar información específica.
- **`Seguridad`**: Las bases de datos ofrecen mecanismos de seguridad para proteger la información, como copias de seguridad y control de acceso.
- **`Escalabilidad`**: Las bases de datos pueden crecer y adaptarse a las necesidades cambiantes de una organización, permitiendo agregar más datos sin perder rendimiento.

---

## SQL (Structured Query Language o Lenguaje de Consulta Estructurado)

SQL es un lenguaje de programación utilizado para gestionar bases de datos relacionales. Permite realizar operaciones como la creación, modificación y consulta de datos almacenados en tablas. A continuación, se presentan algunos conceptos y ejemplos básicos de SQL.

---

## Elementos de SQL

- **`Tabla`**(Entidad): Cada tabla tiene un nombre único. Es una estructura que almacenan datos en filas y columnas.
- **`Fila`**(Registro): Son las entradas individuales en una tabla, representando un registro específico.
- **`Columna`**(Atributo): Son los atributos o campos de una tabla, que almacenan un valor. Cada columna tiene un nombre y un tipo de dato asociado.

  - **`Simple`**: Un tipo de dato que almacena un único valor, como un número o una cadena de texto.
  - **`Compuesto`**: Un tipo de dato que se puede descomponer en varios valores, como una dirección que incluye calle, ciudad y código postal.
  - **`Multivaluado`**: Un tipo de dato que permite almacenar múltiples valores en una sola columna, como numeros de teléfono asociados a un contacto.
  - **`Derivado`**: Un tipo de dato que se obtiene a partir de otros tipos de datos, como calcular la edad a partir de una fecha de nacimiento.

  Hay tipos de columnas especiales:

  - **`Clave Primaria`**: Es un identificador único para cada fila en una tabla. No puede haber dos filas con el mismo valor en la clave primaria.
  - **`Clave Foránea`**: Es una columna que establece una relación entre dos tablas, haciendo referencia a la clave primaria de otra tabla. Esto permite vincular datos relacionados entre diferentes tablas.
  - **`Fecha de Creación`**: Es una columna que almacena la fecha y hora en que se creó un registro en la tabla.
  - **`Fecha de Modificación`**: Es una columna que almacena la fecha y hora en que se modificó por última vez un registro en la tabla.

    A la **`fecha de creación`** y **`fecha de modificación`** se les conoce como datos de auditoría, ya que permiten rastrear cuándo se creó o modificó un registro.

- **`Valor`**: Es el contenido de una celda en una tabla. Cada valor tiene un tipo de dato asociado.
- **`Tipo de Dato`**: Especifica el tipo de información que puede almacenar una columna, como entero, cadena de texto, fecha, etc.
- **`Relación`**: Es una conexión entre dos tablas basada en una clave foránea. Permite vincular datos relacionados entre diferentes tablas.
- **`Consulta`**: Es una solicitud para recuperar datos de una o más tablas. Se utiliza el comando `SELECT` para realizar consultas.

---

## Tipos de datos más comunes en SQL

- **`CHAR(n)`**: Cadena de caracteres de longitud fija, donde `n` es el número máximo de caracteres.
- **`VARCHAR(n)`**: Cadena de caracteres de longitud variable, donde `n` es el número máximo de caracteres.
- **`TEXT`**: Cadena de caracteres de longitud variable sin un límite específico.
- **`ENUM`**: Enumeración, un tipo de dato que permite definir un conjunto de valores posibles para una columna. Por ejemplo, `ENUM('activo', 'inactivo', 'pendiente')`.
- **`INT`**: Entero, un número entero sin decimales.
- **`FLOAT`**: Número de punto flotante, un número con decimales.
- **`DOUBLE`**: Número de punto flotante de doble precisión, un número con decimales de mayor precisión que `FLOAT`.
- **`DECIMAL(p, s)`**: Número decimal con precisión `p` y escala `s`, donde `p` es el número total de dígitos y `s` es el número de dígitos a la derecha del punto decimal.
- **`DATE`**: Fecha, almacena una fecha en formato `YYYY-MM-DD`.
- **`TIME`**: Hora, almacena una hora en formato `HH:MM:SS`.
- **`DATETIME`**: Fecha y hora, almacena una combinación de fecha y hora en formato `YYYY-MM-DD HH:MM:SS`.
- **`TIMESTAMP`**: Marca de tiempo, almacena una fecha y hora con zona horaria.
- **`BOOLEAN`**: Aunque MySQL no tiene un tipo de dato nativo para booleanos, puedes usar BOOLEAN, que es un sinónimo de TINYINT(1). Se utiliza 0 para false y 1 para true.

---

## Tipos de Relaciones

Las relaciones entre tablas en una base de datos relacional se pueden clasificar en tres tipos principales:

- **`Uno a Uno`**: Cada registro de una tabla se relaciona con un solo registro de otra tabla. Por ejemplo, un profesor puede tener un único documento de identidad asociado a él.
- **`Uno a Muchos`**: Una fila en una tabla A puede estar relacionada con múltiples filas en una tabla B, pero cada fila en la tabla B está relacionada con una única fila en la tabla A. Por ejemplo, un profesor puede tener múltiples números de teléfono asociados a él.
- **`Muchos a Muchos`**: Múltiples filas en una tabla A pueden estar relacionadas con múltiples filas en una tabla B. Para representar esta relación, se utiliza una tabla intermedia que contiene claves foráneas de ambas tablas. Por ejemplo, un profesor puede impartir múltiples asignaturas, y cada asignatura puede ser impartida por múltiples profesores.
- **`Reflexiva`**: Una relación donde una tabla se relaciona consigo misma. Por ejemplo, un profesor puede tener un jefe que también es un profesor registrado en la misma tabla.

---

## Ejemplo de Base de Datos Relacional

A continuación se muestra un conjunto de tablas que ilustran cada tipo de relación explicada anteriormente, aplicadas a un sistema de gestión de profesores y asignaturas en una institución educativa.

profesores
├─ 1:1 ─ 1 profesor → 1 documentoIdentidad
├─ 1:N ─ 1 profesor → N telefonos, 1 telefono → 1 profesor
├─ N:M ─ 1 profesor → N asignaturas, 1 asignatura → N profesores
└─ 1:N ─ 1 profesorJefe → N profesores, 1 profesor → 1 profesorJefe

**`profesores`**

| id  | nombre | primerApellido | segundoApellido | sexo   | fechaNacimiento | correo                    | jefeDepartamento |
| --- | ------ | -------------- | --------------- | ------ | --------------- | ------------------------- | ---------------- |
| 1   | Juan   | Pérez          | Gómez           | Hombre | 1980-01-01      | <juan.perez@example.com>  | null             |
| 2   | Ana    | Gómez          | Ruiz            | Mujer  | 1985-02-02      | <ana.gomez@example.com>   | 1                |
| 3   | Carlos | Ruiz           | García          | Hombre | 1990-03-03      | <carlos.ruiz@example.com> | 1                |
| 4   | María  | López          | Fernández       | Mujer  | 1995-04-04      | <maria.lopez@example.com> | 2                |

**`documentos_identidad`**

| id  | tipo      | numero    | profesorId |
| --- | --------- | --------- | ---------- |
| 1   | DNI       | 12345678A | 1          |
| 2   | NIE       | Y1234567B | 2          |
| 3   | Pasaporte | ZAB123456 | 3          |
| 4   | DNI       | 87654321D | 4          |

**`telefonos`**

| id  | numero    | tipo  | profesorId |
| --- | --------- | ----- | ---------- |
| 1   | 623456789 | móvil | 1          |
| 2   | 981654321 | fijo  | 1          |
| 3   | 656789123 | móvil | 2          |
| 4   | 981654987 | fijo  | 3          |
| 5   | 789123456 | móvil | 4          |
| 6   | 981321789 | fijo  | 4          |

**`asignaturas`**

| id  | nombre       | horas | creditos |
| --- | ------------ | ----- | -------- |
| 1   | Matemáticas  | 4     | 6        |
| 2   | Historia     | 3     | 4        |
| 3   | Programación | 5     | 8        |

**`profesores_asignaturas`**

| id  | profesorId | asignaturaId |
| --- | ---------- | ------------ |
| 1   | 1          | 1            |
| 2   | 1          | 2            |
| 3   | 2          | 1            |
| 4   | 2          | 3            |
| 5   | 3          | 2            |
| 6   | 3          | 3            |
| 7   | 4          | 1            |

---

## Acciones CRUD

Las acciones CRUD son las operaciones básicas que se pueden realizar en una base de datos:

- **`Create`**(Crear): Crear nuevos registros en una tabla.
- **`Read`**(Leer): Consultar y recuperar datos de una tabla.
- **`Update`**(Actualizar): Modificar registros existentes en una tabla.
- **`Delete`**(Eliminar): Eliminar registros existentes de una tabla.

  Puede ser que a alguien le suene el término ABML(Alta, Baja, Modificación y Lectura) o ABM(Alta, Baja y Modificación), que son sinónimos de las acciones CRUD.

---

## Consultas SQL Básicas

### Crear y Borrar una DDBB

```sql
-- Crear una base de datos
CREATE DATABASE nombre_DDBB;

-- Crear una base de datos si no existe
CREATE DATABASE IF NOT EXISTS nombre_DDBB;

-- Borrar una base de datos
DROP DATABASE nombre_DDBB;

-- Borrar una base de datos si existe
DROP DATABASE IF EXISTS nombre_DDBB;
```

### Crear y Borrar una Tabla

```sql
-- Crear una tabla
CREATE TABLE nombre_de_la_tabla (
    columna1 tipo_de_dato,
    columna2 tipo_de_dato,
    ...
);

-- Crear una tabla si no existe
CREATE TABLE IF NOT EXISTS nombre_de_la_tabla (
    columna1 tipo_de_dato,
    columna2 tipo_de_dato,
    ...
);

-- Borrar una tabla
DROP TABLE nombre_de_la_tabla;

-- Borrar una tabla si existe
DROP TABLE IF EXISTS nombre_de_la_tabla;
```

### Insertar Datos. Crear

```sql
-- Insertar un único registro
INSERT INTO nombre_de_la_tabla (columna1, columna2, ...)
VALUES (valor1, valor2, ...);

-- Insertar múltiples registros
INSERT INTO nombre_de_la_tabla (columna1, columna2, ...)
VALUES (valor1, valor2, ...), (valor1, valor2, ...);
```

### Consultar Datos. Leer

```sql
-- Consultar todos los datos de la tabla nombre_de_la_tabla
SELECT *
FROM nombre_de_la_tabla;

-- Consultar todos los datos de la tabla nombre_de_la_tabla donde se cumpla una condicion
SELECT *
FROM nombre_de_la_tabla
WHERE condicion;

-- Consultar los datos columna1, columna2, ... de la tabla nombre_de_la_tabla donde se cumpla una condicion
SELECT columna1, columna2, ...
FROM nombre_de_la_tabla
WHERE condicion;


-- Consultar los datos de la tabla nombre_de_la_tabla ordenados por columna1, se puede ordenar de forma ascendente (ASC) o descendente (DESC). Si no se especifica, por defecto es ASC
SELECT *
FROM nombre_de_la_tabla
ORDER BY columna1 ASC;
```

### Actualizar Datos. Actualizar

```sql
-- Actualizar un registro en la tabla nombre_de_la_tabla
UPDATE nombre_de_la_tabla
SET columna1 = valor1, columna2 = valor2, ...
WHERE condicion;
```

### Eliminar Datos. Borrar

```sql
-- Eliminar un registro de la tabla nombre_de_la_tabla
DELETE FROM nombre_de_la_tabla
WHERE condicion;
```
