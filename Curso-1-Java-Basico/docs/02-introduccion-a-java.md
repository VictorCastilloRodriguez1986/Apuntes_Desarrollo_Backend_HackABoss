# 02. Introducción a Java - Temas a tratar

En esta clase se deberán abordar las siguientes temáticas:  

- **Introducción a Java**
    - ¿Qué es Java?
    - Versiones de Java: Java SE vs Java EE
	

> **💡Nota:** Esta primera parte puedes encontrarla en el tema "02. Primeros pasos en Java" dentro del Curso 0
	

<br>

- **Java como Lenguaje**
    - Sintaxis básica
    - Tipos de Datos
    - Variables
    - Operadores
    - Operaciones de lectura y escritura (Scanner y `System.out.println`)
	

> **💡Nota:** Esta segunda parte la abordaremos a continuación

<br>

---
---

<br>

## Sintaxis básica

### Variables y Tipos de datos

Como en todo lenguaje de programación, en Java, las variables son contenedores en memoria que se utilizan para almacenar datos. Cada variable tiene un tipo de dato específico que, justamente, determina o establece qué pueden guardar/almacenar dentro cada una de estas variables.

Los tipos de datos en Java se dividen en dos categorías principales: **tipos de datos primitivos** y **tipos de datos de referencia**.

<br>

### Tipos de datos primitivos

Los tipos de datos primitivos representan valores simples y se almacenan directamente en la memoria. Entre los más importantes se encuentran:

- **byte:** Un tipo de dato de 8 bits que puede almacenar valores enteros en el rango de -128 a 127.
    
- **short:** Un tipo de dato de 16 bits que puede almacenar valores enteros en un rango más amplio que byte.
    
- **int:** Un tipo de dato de 32 bits que puede almacenar valores enteros en un rango aún más amplio.
    
- **long:** Un tipo de dato de 64 bits que se utiliza para almacenar valores enteros muy grandes.
    
- **float:** Un tipo de dato de 32 bits que se utiliza para representar números de punto flotante con precisión limitada.
    
- **double:** Un tipo de dato de 64 bits que se utiliza para representar números de punto flotante con mayor precisión.
    
- **char:** Un tipo de dato de 16 bits que se utiliza para almacenar un único carácter Unicode.
    
- **boolean:** Un tipo de dato que representa valores booleanos, es decir, true o false.

<br>

### Tipos de datos de referencia

Los tipos de datos referencia, indican que vamos a trabajar con instancias de clases, no con tipos primitivos. De esta manera, una variable de tipo referencia establece una conexión hacia un objeto, y a través de esta conexión podemos acceder a sus métodos y atributos (estos conceptos los veremos más adelante).

Algunos ejemplos de tipos de datos de referencia en Java son:

- **String:** Se utiliza para almacenar cadenas de caracteres.
    
- **Clases personalizadas:** Puedes crear tus propias clases para representar datos personalizados.
    
- **Colecciones**: Se utilizan para almacenar colecciones de elementos del mismo tipo.
    
- **Interfaces:** Se utilizan para definir métodos/funciones que deben ser implementados por las clases que los utilizan.
    
- **Tipos de datos enumerados (enum):** Se utilizan para definir un conjunto de valores constantes.

<br>

### Declaración e inicialización de variables

Para declarar una variable en Java, debes especificar su tipo de dato y un nombre. Es importante recordar que las variables deben **declararse antes de ser utilizadas**, y los tipos de datos deben **coincidir con los valores que se les asignan**.

La inicialización de valores se realiza generalmente mediante el símbolo de asignación "=" donde por lo general los tipos de datos primitivos se inicializan con un valor por defecto, mientras que las variables de referencia se inicializan con `null` si no se les asigna un valor. ¡Veamos un ejemplo de código!

```java
  int edad = 35;
  double altura = 1.80;
  char letra =’a’;
  boolean bandera = false;
  String cadena = “Hola mundo”;
```
	

> ⚠️ **IMPORTANTE: No olvides estas características de la sintaxis de Java**
> - Fuertemente tipado
> - Todas las líneas terminan en `;`
> - Las estructuras comienzan y terminan con llaves `{}`
> - Reglas para nombres de variables

<br>

---
---

<br>

## Operadores clásicos

<br>

En Java, los operadores son símbolos especiales que se utilizan para realizar operaciones entre variables y valores. Se utilizan, generalmente, en expresiones para realizar cálculos, comparaciones y otras tareas. Los principales tipos de operadores en Java son:

- **Operadores aritméticos:** Se utilizan para realizar operaciones matemáticas en números.
	  
    `+`: Suma dos números.
    
    `-`: Resta dos números.
    
    `*`: Multiplica dos números.
    
    `/`: Divide un número entre otro.
    
    `%`: Calcula el residuo de la división (operador módulo).

<br>

- **Operadores de asignación:** Se utilizan para asignar valores a variables.
	  
    `=`: Asigna un valor a una variable.
    
    `+=`, `-=`, `*=`, `/=`, `%=`: Realizan una operación aritmética y luego asignan el resultado a una variable.
    
    **Por ejemplo:**

```java
int suma = 35 + 2;
double division = 20 / 6 ;
int resta = 120 - 43;
double multiplicacion = 1.50 * 2;
```

<br>

- **Operadores de comparación o relacionales:** Se utilizan para comparar valores y devuelven, como resultado, un valor booleano: **true** o **false**
	  
    `==`: Comprueba si dos valores son iguales.
    
    `!=`: Comprueba si dos valores son diferentes.
    
    `<`: Comprueba si un valor es menor que otro.
    
    `<=`: Comprueba si un valor es menor o igual que otro.
    
    `>`: Comprueba si un valor es mayor que otro.
    
    `>=`: Comprueba si un valor es mayor o igual que otro.
    
    `equals`: Función especial para comparar Strings

<br>

- **Operadores condicionales o lógicos:** Se utilizan para combinar expresiones booleanas.
	  
    `&&` (AND): Devuelve `true` si ambas expresiones son `true`.
    
    `||` (OR): Devuelve `true` si al menos una de las expresiones es `true`.
    
    `!` (NOT): Niega el valor de una expresión.

<br>

> **💡Nota:** Tanto operadores de comparación como lógicos los veremos en mayor detalle cuando abordemos estructuras condicionales o selectivas.

<br>

---
---

<br>

## Operadores de Lectura y Escritura

<br>

En **Java**, para la lectura y escritura de datos, se utilizan generalmente para la lectura de datos por teclado la clase `Scanner` y para mostrarlos por pantalla el método especial `System.out.println()`.

> **💡Nota:** Aún no vimos el concepto de "Clase", sin embargo, ¡Tranqui! Por el momento utilizaremos las características mencionadas sin profundizar en dicho concepto, pero más adelante abordaremos con todo el mismo.

<br>

### Lectura de datos con Scanner

La clase `Scanner` se utiliza para leer datos desde la entrada estándar (generalmente el teclado) o desde otros flujos de entrada. Para utilizar Scanner, primero debes importar la clase y luego crear una instancia de ella.

La clase Scanner utiliza diferentes métodos/funciones llamadas “next” dependiendo del tipo de dato que pretenden leer por teclado o el sistema de entrada elegido. A continuación especificamos algunos de ellos:

- **next():** Lee la siguiente cadena de caracteres hasta encontrar un espacio en blanco o un salto de línea. Devuelve la cadena leída.
    
- **nextLine():** Lee la siguiente línea completa de texto, incluyendo espacios en blanco y caracteres especiales. Devuelve la línea como una cadena de caracteres.
    
- **nextInt():** Lee el siguiente valor entero (número sin decimales) en la entrada. Si la entrada no es un número entero válido, se producirá una excepción.
    
- **nextDouble():** Lee el siguiente valor decimal (número con decimales) en la entrada. Si la entrada no es un número decimal válido, se producirá una excepción.
    
- **nextBoolean():** Lee el siguiente valor booleano (true o false) en la entrada. A menudo se utiliza para leer respuestas de sí/no.
    
- **nextByte():** Lee el siguiente valor como un byte.
    
- **nextShort():** Lee el siguiente valor como un short.
    
- **nextLong():** Lee el siguiente valor como un long.
    
- **nextFloat():** Lee el siguiente valor como un float

<br>

**Por ejemplo:**

```java
import java.util.Scanner; // Importamos la clase Scanner

public class LecturaConScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos una instancia de Scanner

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine(); // Leemos una línea de texto
        System.out.println("Hola, " + nombre);

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt(); // Leemos un número entero
        System.out.println("Tienes " + edad + " años.");

        scanner.close(); // Cierra el scanner cuando ya no se necesita. Esto es OPCIONAL
    }
}
```

<br>

### Escritura de datos con System.out.println()

La función `System.out.println()` se utiliza para escribir datos en la salida estándar (generalmente la consola). Puedes usar esta función para imprimir mensajes, resultados o cualquier otro tipo de información en la consola.

**Por ejemplo:**

```java
public class EscrituraConSystemOut {
    public static void main(String[] args) {
        
        int suma = 35 + 2;
        System.out.println (“El resultado de la suma es: ” + suma);
    }
}
```

<br>

---
---

<br>

## Material complementario

<br>

### Material teórico complementario

A continuación te dejamos material de referencia en formato video que creemos que puede serte de ayuda para reforzar los temas abordados en clase:

- [Introducción a Java y la JVM](https://youtu.be/E8weQyNVWug?si=EQ_u1cqn40HQFQsD)
    
- [¿Qué es Java y qué es necesario para programar en este lenguaje?](https://youtu.be/6q7wHs6cH6Y?si=goo41iLVXMcV-Xah)
    
- [Tipos de datos y Variables](https://youtu.be/l2mLP7P3jx4?si=5hJIcO0JvfL7FAet)
    
- [Operadores Aritméticos](https://youtu.be/s--BIoXW2AE?si=vuS1N0EbyQ3HVIjy)
    
- [Operadores en Java + Ejemplo](https://youtu.be/Fswl6scN9cY?si=l6gr-GXE3Qi_5ZVP)

<br>

### Ejercicios prácticos complementarios

¿Te has quedado con ganas de más? ¿Quieres probar hacer un ejercicio práctico? A continuación te dejamos una serie de propuestas de ejercicios prácticos que creemos que te pueden ser útiles para practicar.

- [Ejercicio Intercambio de Valores en Java](https://youtu.be/dGw8A4wuTHA?si=nssbroPzcovIlmQF)
    
- [Ejercicio Promedio de números](https://youtu.be/TGfyjTSCGVc?si=jPUG6jVDKWo5FF-s)

---
> [⬅️ Anterior: Bienvenida](01-bienvenida.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Funciones en Java ➡](03-funciones-en-java.md)
