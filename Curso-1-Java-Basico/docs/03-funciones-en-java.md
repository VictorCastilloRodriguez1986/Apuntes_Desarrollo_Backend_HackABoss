# 03. Funciones en Java

- **Funciones en Java**
    - ¿Qué es una función en Java?
    - Estructura de un método en Java
    - Beneficios de usar métodos
    - Tipos de Retorno
    - Sobrecarga de Métodos

> **💡Nota:** En Java, una función también se le denomina "método".

<br>

---
---

<br>

## ¿Qué es una función en Java?

 Un método es un bloque de código que realiza una tarea específica. Los métodos permiten organizar el código en unidades más pequeñas y reutilizables, lo que facilita la escritura, lectura y mantenimiento de programas.

<br>

---
---

<br>

## Estructura de un método en Java

- **Modificador**: Define el nivel de acceso del método (público, privado, protegido, etc.).
  
- **Tipo de retorno**: Especifica el tipo de valor que el método devuelve (si no devuelve nada, se usa `void`).
  
- **Nombre del método**: El nombre que identifica al método.
  
- **Parámetros**: Valores que se pasan al método para que los utilice (opcional).
  
- **Cuerpo del método**: El bloque de código que realiza la tarea del método.
  
- **`return`**: Devuelve un valor del tipo especificado (solo si el método no es `void`).

```java
[modificador] tipo_de_retorno nombre_del_método([parámetros]) {
    // Cuerpo del método
    // ...
    [return valor_de_retorno;]
}
```

<br>

---
---

<br>

## Beneficios de usar métodos

- **Reutilización de código**: Permiten escribir código una vez y utilizarlo en múltiples lugares.
  
- **Modularidad**: Dividen el programa en módulos más pequeños y manejables.
  
- **Legibilidad**: Mejoran la comprensión del código.
  
- **Mantenimiento**: Facilitan la corrección de errores y modificaciones.
  
- **Organización**: Permiten una estructura lógica en el código.

<br>

### Ejemplo

```java
public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        int suma = sumar(num1, num2);
        System.out.println("La suma es: " + suma);
    }
}
```

<br>

#### **Desglosando el ejemplo**

- El método `sumar` toma dos parámetros enteros y devuelve su suma.
  
- El método `main` es el punto de entrada del programa.
  
- Se llama a `sumar` y se muestra el resultado en la consola.

<br>

---
---

<br>

## Tipos de Retorno

### Funciones que retornan valores

Estas funciones realizan un cálculo y devuelven un resultado. Ejemplos:

- **Tipos primitivos:** `int`, `double`, `boolean`, etc.
  
- **Objetos:** `String`, clases personalizadas, `Arrays`, `List`, `Map`, `Set`.

<br>

### Funciones que no retornan valores (`void`)

Realizan una acción sin devolver un resultado, como imprimir en consola.

```java
public class EjemplosRetorno {

    public static int obtenerDoble(int numero) {
        return numero * 2;
    }

    public static double calcularPromedio(double num1, double num2) {
        return (num1 + num2) / 2;
    }

    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    public static String obtenerSaludo(String nombre) {
        return "Hola, " + nombre + "!";
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        System.out.println("El doble es: " + obtenerDoble(5));
        System.out.println("El promedio es: " + calcularPromedio(7.5, 9.0));
        System.out.println("¿Es mayor de edad? " + esMayorDeEdad(20));
        System.out.println(obtenerSaludo("Juan"));
        imprimirMensaje("Este es un mensaje.");
    }
}
```

<br>

---
---

<br>

## Sobrecarga de Métodos

La **sobrecarga de métodos** permite definir varios métodos con el mismo nombre, pero con diferente número o tipo de parámetros.

<br>

### Beneficios

- **Flexibilidad**: Permite reutilizar el mismo nombre para operaciones similares.
  
- **Conveniencia**: Mejora la legibilidad.
  
- **Código intuitivo**: Facilita la comprensión.

<br>

### Ejemplo

```java
public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println("Suma de dos enteros: " + calculadora.sumar(5, 10));
        System.out.println("Suma de tres enteros: " + calculadora.sumar(2, 4, 6));
        System.out.println("Suma de dos doubles: " + calculadora.sumar(3.5, 2.7));
    }
}
```

Este código ilustra cómo un mismo método `sumar` puede adaptarse a distintos tipos y cantidades de parámetros.

---
> [⬅️ Anterior: Introducción a Java](02-introduccion-a-java.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Estructuras de control ➡](04-estructuras-de-control.md)
