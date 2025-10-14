# Ejercicios - Día 3 - Ejercicios de funciones en Java Básico

A continuación, encontrarás tres ejercicios que te ayudarán a practicar la creación de funciones en Java. Algunos métodos retornarán valores, mientras que otros solo imprimirán mensajes en la terminal.

---

## Ejercicio 1: Suma de dos números

Crea una función llamada `sumarNumeros` que reciba dos números enteros como parámetros y retorne la suma de ambos.

- La función debe recibir dos parámetros enteros.

- Debe retornar un número entero.

- Imprime el resultado en la función `main`, llamando a `sumarNumeros` con diferentes valores.

**Ejemplo de uso:**

```java
int resultado = sumarNumeros(5, 3);
```

---

## Ejercicio 2: Mostrar un mensaje personalizado

Crea una función llamada `mostrarMensaje` que reciba un nombre como parámetro y muestre en pantalla un saludo personalizado. Esta función no debe retornar ningún valor.

- La función debe recibir un parámetro de tipo `String`.

- Debe imprimir un mensaje en consola con el siguiente formato:

  ```txt
  Hola, [nombre], bienvenido a Java!
  ```

- La función no debe retornar ningún valor.

**Ejemplo de uso:**

```java
mostrarMensaje("Carlos");
```

**Salida esperada:**

```bash
Hola, Carlos, bienvenido a Java!
```

---

## Ejercicio 3: Concatenación con distinción de mayúsculas y minúsculas

Crea una función en Java que reciba dos cadenas como parámetros: una en mayúsculas y otra en minúsculas, y las concatene en un orden específico.

- Escribe una función en Java llamada `concatenarCadenas` que reciba dos parámetros de tipo `String`: `cadenaMayusculas` y `cadenaMinusculas`.

- La función debe concatenar las dos cadenas de la siguiente manera: primero la cadena en minúsculas, seguida de un espacio, y luego la cadena en mayúsculas.

- La función debe retornar la cadena resultante de la concatenación.

- En el método `main`, llama a la función `concatenarCadenas` con dos cadenas de ejemplo: una en mayúsculas y otra en minúsculas.

- Imprime el resultado de la concatenación en la consola.

**Ejemplo:**

Si `cadenaMayusculas` es "HOLA" y `cadenaMinusculas` es "mundo", la función debe retornar "mundo HOLA".

**Salida esperada:**

```bash
hola MUNDO
```
