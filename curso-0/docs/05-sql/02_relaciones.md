# Relaciones entre Tablas

En las bases de datos relacionales, existen diferentes tipos de relaciones que permiten conectar y estructurar los datos de manera efectiva.

A continuación, se describen tres de los tipos más comunes de relaciones en bases de datos relacionales: la relación 1 a 1 (uno a uno), la relación 1 a N (uno a muchos) y la relación N a N (muchos a muchos).

<br>

## Relación 1 a 1 (Uno a Uno)

En una **relación uno a uno**, cada registro en la primera tabla se relaciona con exactamente un registro en la segunda tabla, y viceversa. Esto significa que no hay duplicados en la relación. Por ejemplo, una tabla de "Personas" podría estar relacionada uno a uno con una tabla de "Información de Contacto" donde cada persona tiene una única entrada en la tabla de información de contacto.

<br>

## Relación 1 a N (Uno a Muchos)

En una **relación uno a muchos**, un registro en la primera tabla se relaciona con uno o más registros en la segunda tabla, pero un registro en la segunda tabla se relaciona con un solo registro en la primera tabla. Por ejemplo, una tabla de "Departamentos" podría estar relacionada con una tabla de "Empleados", donde un departamento tiene muchos empleados, pero cada empleado pertenece a un solo departamento.

<br>

## Relación N a N (Muchos a Muchos)

En una **relación muchos a muchos**, varios registros en la primera tabla pueden estar relacionados con varios registros en la segunda tabla y viceversa. Para implementar una relación muchos a muchos, generalmente se requiere una tabla intermedia o de unión que relacione las dos tablas. Por ejemplo, una tabla de "Estudiantes" podría estar relacionada con una tabla de "Cursos", y una tabla intermedia "Inscripciones" registraría qué estudiantes están inscritos en qué cursos y viceversa. Esto permitiría, por ejemplo, que múltiples estudiantes estén inscritos en múltiples cursos.

A continuación podrás ver un video explicativo sobre estos tipos de relaciones y cómo se representan gráficamente a la hora de pensar el planteo de las tablas de una base de datos relacional.

[![](./resources/relaciones-screenshot.png)](https://youtu.be/AArIcStS0TU)

<br>

## Primary y Foreign Keys

Para poder relacionar dos tablas entre sí en una base de datos relacional, se utilizan dos conceptos fundamentales: las claves primarias **(primary keys)** y las claves foráneas **(foreign keys).** Estas son conceptos esenciales para establecer y mantener relaciones sólidas entre las tablas o entidades.

<br>

### Clave Primaria (Primary Key)

Una clave primaria es un campo o conjunto de campos en una tabla que tiene dos propósitos principales. En primer lugar, garantiza que cada registro en la tabla sea único, lo que evita duplicados. En segundo lugar, se utiliza para identificar de manera exclusiva cada registro en la tabla. Esto significa que proporciona una forma única de acceder a cada registro en la tabla sin ambigüedades.

En el contexto de las relaciones, la clave primaria de una tabla se utiliza para establecer vínculos con otras tablas. Cuando se crea una relación, la clave primaria de una tabla se convierte en la clave foránea en la tabla relacionada. Esto permite vincular registros en una tabla con registros en otra de manera coherente.

<br>

### Clave Foránea (Foreign Key)

Una clave foránea es un campo o conjunto de campos en una tabla que hace referencia a la clave primaria de otra tabla. Establece una relación entre las dos tablas al relacionar registros en una tabla con registros en la otra. La clave foránea actúa como un enlace o puente entre las tablas, permitiendo que los datos estén interconectados de manera significativa.

La clave foránea garantiza la integridad referencial, lo que significa que los datos en la tabla relacionada están vinculados de manera coherente a los datos en la tabla principal. Esto asegura que no se puedan crear relaciones huérfanas en la base de datos y que los datos relacionados se mantengan consistentes.

💡**Recordatorio Importante:** Por definición, siempre una clave foránea en una tabla es la clave primaria de otra.

Para ver estos dos conceptos en mayor profundidad, te dejamos a continuación un video explicativo de referencia:

[![](./resources/primary-foreign-key-screenshot.png)](https://youtu.be/tyyhIsDmVM0)

---
⬅ [Anterior: Bases de Datos Relacionales](01_bases_de_datos_relacionales.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Operaciones ➡](03_operaciones.md)

