# 05. Estructuras de Control avanzadas

Las estructuras de control son herramientas fundamentales en la programación que permiten alterar el flujo secuencial de la ejecución de un programa. En otras palabras, deciden qué partes del código se ejecutan y en qué orden.

<br>

## Beneficios de las Estructuras de Control

- **Flexibilidad**: Permiten crear programas que responden a diferentes situaciones y condiciones.
  
- **Lógica Compleja**: Facilitan la implementación de algoritmos y lógica compleja.
  
- **Eficiencia**: Ayudan a evitar la repetición innecesaria de código.
  
- **Legibilidad**: Cuando se usan correctamente, mejoran la claridad y comprensión del código.

<br>

---
---

<br>

## Estructuras de Control sin llaves

En Java, cuando una estructura de control (como `if`, `else`, `for`, `while`) controla una única sentencia, las llaves `{}` son opcionales. Sin embargo, esta práctica puede llevar a errores y disminuir la legibilidad del código.

<br>

### Ejemplo con `if-else`

```java
int edad = 18;

if (edad >= 18)
    System.out.println("Es mayor de edad.");
else
    System.out.println("Es menor de edad.");
```

<br>

### Explicación

- Si la condición `edad >= 18` es verdadera, se ejecuta la sentencia `System.out.println("Es mayor de edad.");`.
  
- Si la condición es falsa, se ejecuta la sentencia `System.out.println("Es menor de edad.");`.
  
- Como solo hay una sentencia por cada condición, las llaves son omitidas.

<br>

### Peligros de omitir llaves

- **Errores Lógicos**: Si se añade una segunda sentencia sin llaves, esta se ejecutará siempre, independientemente de la condición.
  
- **Dificultad de Mantenimiento**: El código se vuelve más difícil de leer y modificar.

<br>

### Recomendación

Aunque Java permite omitir las llaves en ciertos casos, se recomienda siempre utilizarlas para evitar errores y mejorar la claridad del código.

<br>

---
---

<br>

## Operadores Ternarios

El operador ternario es un operador condicional abreviado que permite escribir una expresión `if-else` en una sola línea. Se compone de tres operandos: una condición, un valor si la condición es verdadera y un valor si la condición es falsa.

```java
condición ? valor_si_verdadero : valor_si_falso;
```

<br>

### Beneficios

- **Concisión**: Permite escribir código más corto y legible en situaciones donde se necesita una decisión binaria simple.
  
- **Claridad**: En algunos casos, puede hacer que el código sea más fácil de entender al expresar la lógica condicional de forma compacta.

<br>

### Ejemplo

```java
public class OperadorTernario {

    public static void main(String[] args) {
        int edad = 20;
        String mensaje = (edad >= 18) ? "Es mayor de edad" : "Es menor de edad";
        System.out.println(mensaje);

        int numero = 10;
        String parImpar = (numero % 2 == 0) ? "Par" : "Impar";
        System.out.println("El número es: " + parImpar);
    }
}
```

<br>

### Explicación

- En el primer caso, la variable `mensaje` se asigna con el valor "Es mayor de edad" si la edad es mayor o igual a 18, y "Es menor de edad" en caso contrario.
  
- En el segundo caso, la variable `parImpar` se asigna con el valor "Par" si el `numero` es divisible entre 2, y "Impar" en caso contrario.

<br>

### Cuándo usarlo

El operador ternario es útil para decisiones binarias simples y asignaciones de valores condicionales. Sin embargo, para lógica condicional más compleja, es preferible utilizar la estructura `if-else` tradicional para mejorar la legibilidad del código.

<br>

### Puntos clave

- El operador ternario devuelve un valor, por lo que se puede utilizar en asignaciones y otras expresiones.
  
- Es importante utilizarlo con moderación y asegurarse de que el código siga siendo legible.

<br>

---
---

<br>

# Bucle For-Each y Casteo en Java

<br>

## Bucle For-Each

El bucle for-each, también conocido como bucle "for mejorado", es una estructura de control que permite iterar a través de los elementos de un array o una colección (como listas, conjuntos, etc.) de forma simplificada.

<br>

### Sintaxis

```java
for (tipo elemento : coleccion) {
    // Bloque de código a ejecutar para cada elemento
}
```

- **tipo**: El tipo de dato de los elementos en la colección.
  
- **elemento**: Una variable que representa el elemento actual en cada iteración.
  
- **coleccion**: El array o la colección que se va a recorrer.

<br>

### Beneficios

- **Simplicidad**: Simplifica la iteración a través de colecciones, eliminando la necesidad de manejar índices.

- **Legibilidad**: Mejora la legibilidad del código, especialmente cuando se trabaja con colecciones.

- **Menos errores**: Reduce la posibilidad de errores relacionados con índices fuera de rango.

<br>

### Ejemplo

```java
public class ForEach {
    public static void main(String[] args) {
        // Ejemplo con un array de enteros
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println("Números:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Ejemplo con una lista de cadenas
        String[] nombres = {"Ana", "Juan", "María"};
        System.out.println("\nNombres:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
```

<br>

### Cuándo usarlo

- El bucle for-each es ideal cuando se necesita recorrer todos los elementos de una colección sin necesidad de conocer los índices.
  
- No se recomienda usar este bucle cuando se necesita modificar los elementos de la colección durante la iteración o cuando se necesita acceder a los índices de los elementos.

<br>

### Puntos clave

- El bucle for-each es una forma más concisa y legible de iterar a través de colecciones en comparación con el bucle for tradicional.
  
- No se puede utilizar el bucle for-each para recorrer colecciones en orden inverso.

<br>

---
---

<br>

## Casteo en Java

El **casteo** en Java es el proceso de convertir un tipo de dato en otro. Se utiliza cuando necesitas tratar un valor de un tipo como si fuera de otro tipo. Java distingue entre dos tipos de casteo:

<br>

### Tipos de Casteo

1. **Casteo implícito (widening)**: 
   - Ocurre automáticamente cuando se convierte un tipo de dato más pequeño a uno más grande (por ejemplo, de `int` a `long`).
   - No hay pérdida de información.

2. **Casteo explícito (narrowing)**: 
   - Requiere que el programador indique explícitamente la conversión, ya que puede haber pérdida de información (por ejemplo, de `double` a `int`).

<br>

### Posibles errores

- **`ClassCastException`**: Ocurre cuando se intenta castear un objeto a una clase de la que no es instancia. Por ejemplo, intentar castear un objeto `String` a un objeto `Integer`.
  
- **`NumberFormatException`**: Ocurre al intentar convertir una cadena a un tipo numérico (como `int` o `double`) si la cadena no tiene el formato adecuado.
  
- **Pérdida de precisión**: Al castear de un tipo de dato más grande a uno más pequeño, se puede perder información. Por ejemplo, al castear un `double` a un `int`, se pierden los decimales.

<br>

### Ejemplo de Casteo

```java
public class CasteoEjemplo {
    public static void main(String[] args) {
        // Casteo implícito (widening)
        int numeroEntero = 100;
        double numeroDouble = numeroEntero; // Conversión automática
        System.out.println("Número double: " + numeroDouble);

        // Casteo explícito (narrowing)
        double numeroDecimal = 3.14;
        int numeroTruncado = (int) numeroDecimal; // Conversión manual
        System.out.println("Número truncado: " + numeroTruncado);

        // Convertir un número a String
        int numero = 123;
        String numeroTexto = String.valueOf(numero);
        System.out.println("Número en texto: " + numeroTexto);

        // Convertir un String a int
        String texto = "456";
        int numeroConvertido = Integer.parseInt(texto);
        System.out.println("Número convertido: " + numeroConvertido);
    }
}
```

<br>

### Resumen

- **Casteo implícito**: Se realiza automáticamente cuando no hay pérdida de datos.
  
- **Casteo explícito**: Se realiza manualmente y puede implicar pérdida de datos.
  
- **Conversión entre String y números**: Se usa `String.valueOf()` para convertir números a texto y `Integer.parseInt()` para convertir texto a números.

---
> [⬅️ Anterior: Estructuras de control](04-estructuras-de-control.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Introducción a la POO ➡](06-introduccion-a-la-POO.md)
