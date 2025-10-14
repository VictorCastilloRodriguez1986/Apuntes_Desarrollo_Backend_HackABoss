# Introducción a las Bases de Datos Relacionales

Una base de datos es una **colección estructurada** y **organizada** de información o datos que se almacena de manera electrónica en un ordenador o servidor mediante un sistema **gestor de bases de datos (SGBD)**.

Las **bases de datos relacionales** se utilizan para organizar y almacenar datos en **tablas con filas y columnas**, donde cada fila representa un registro y cada columna representa un atributo o campo específico.

[![](./resources/base-de-datos-screenshot.png)](https://youtu.be/SKOiEXlFNeM)

<br>

## Sistema Gestor de Base de Datos (SGBD)

Un **Sistema Gestor de Bases de Datos (SGBD)** es un software diseñado para gestionar y administrar bases de datos. Su principal función es permitir el almacenamiento, organización, recuperación y manipulación eficiente de datos, además de proporcionar una interfaz para que los usuarios y aplicaciones interactúen con la base de datos sin preocuparse por los detalles internos de cómo se almacenan y gestionan la información.

Tanto en las bases de datos relacionales como no relacionales existen diferentes SGBD. En este caso, como vamos a centrarnos en las bases de datos RELACIONALES, trabajaremos con MySQL.

**MySQL** es un SGBD de código abierto ampliamente utilizado. Es conocido por su rendimiento, escalabilidad y facilidad de uso. Se utiliza en una amplia variedad de aplicaciones web y empresariales. Fue adquirido por Oracle Corporation, pero una versión comunitaria gratuita todavía está disponible bajo el nombre de "MariaDB".

![](./resources/logo-mysql.png)

<br>

## Componentes

Toda base de datos relacional está compuesta, principalmente, por los siguientes componentes:

1. **Tablas:** Los datos se organizan en tablas, que consisten en filas y columnas. Cada fila representa un registro individual, y cada columna contiene un atributo o campo de datos específico.
   
2. **Registros:** Cada fila en una tabla se llama registro y contiene información relacionada. Por ejemplo, en una base de datos de empleados, un registro podría representar a un empleado en particular y contener información como su nombre, dirección, número de identificación, salario, etc.
   
3. **Campos:** Las columnas en una tabla se llaman campos. Cada campo representa un tipo específico de información, como un nombre, una fecha o un número de teléfono.

A nivel conceptual, cada tabla se conoce como **ENTIDAD** y cada uno de sus campos son conocidos como **ATRIBUTOS**. En el siguiente video se explican a mayor detalle cada uno de estos conceptos:

[![](./resources/entidades-atributos-screenshot.png)](https://youtu.be/_acDisSc2UE)

---
⬅ [Anterior: Práctica II](../04-git/06_practica_II.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Relaciones ➡](02_relaciones.md)