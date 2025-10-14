# 04. Estructuras de control

<br>

## Estructuras de control - Temas a tratar

En esta clase se deberán abordar las siguientes temáticas:  

- Estructuras Condicionales
  
- Estructuras Repetitivas
  
- Vectores y Matrices

<br>

---
---

<br>

## Estructuras condicionales

En Java, las estructuras condicionales permiten que un programa tome decisiones basadas en condiciones específicas. A continuación, entraremos en detalle con cada una de las más utilizadas.

<br>

### Estructura IF (si)

`if` en Java es una estructura de control que permite tomar decisiones o ejecutar ciertos bloques de código dependiendo del cumplimiento o no de una determinada condición, es decir, si la misma es verdadera.

`if`, traducido al español, significa "si", por lo que puedes plantearte la línea de código como "SI se cumple una condición HARÉ ESTO".

Supongamos que estás diseñando el sistema para permitir el acceso o no a un juego en un parque de diversiones dependiendo de la estatura de la persona que quiera subirse. SOLO si la persona cumple con cierta estatura recibirá un mensaje que le dirá que puede acceder. Por ejemplo:

```java
  double estatura = 1.67;

  if (estatura >= 1.50) {
    System.out.println("Puede subir al juego");
  }
```

<br>

### Estructura If + else (Si + Sino)

`else` en Java es una estructura que se utiliza como complemento del `if` para manejar situaciones en las que la condición del "if" no se cumpla, es decir sea falsa.

El else permite establecer un camino alternativo o mostrar un bloque de código distinto al que muestra el if. Else, en inglés, significa SINO, por lo que podemos plantear la combinación del IF y el ELSE de la siguiente manera: "SI se cumple una condición HARÉ ESTO, SINO se cumple, HARÉ ESTO OTRO".

Continuando con el mismo ejemplo, supongamos que para aquellas personas que no superen la estatura de seguridad para el juego, también se les deba informar mediante un mensaje la situación y explicando el por qué. Lo podríamos hacer de la siguiente manera:

```java
  double estatura = 1.67;

  if (estatura >= 1.50) {
    System.out.println("Puede subir al juego");
  }
  else {
    System.out.println("No puede subir al juego. No supera la estatura de seguridad mínima solicitada");
  }
```

<br>

### Condicionales múltiples: If + else + if + else

`if` y `else` pueden usarse de forma combinada. Es posible anidar estructuras `if` dentro de otras estructuras `if`, como así también, dentro de otras estructuras `else`. Este caso, donde existe una combinación entre varias estructuras suele ser conocida como **"estructuras selectivas/condicionales múltiples"**.

Siguiendo con el ejemplo del parque de diversiones, supongamos 2 casos más.

- Uno donde la persona de estatura > 1.50 debe ser al mismo tiempo también < a 1.95 dado que si mide demás puede ser peligroso para el juego.
    
- Otro donde a la persona < 1.50 si, su edad es < a 12 años, sugerirle juegos infantiles a los que pueda subir con su estatura, y donde su edad supere los 12 años, sugerirle una lista de juegos que no exija estatura y sea para su edad.

```java
  double estatura = 1.67;
  double edad = 14;

  if (estatura >= 1.50) {
    if (estatura <= 1.95) {
      System.out.println("Puede subir al juego");
    }
    else {
      System.out.println("Si bien cumple con la estatura mínima para el juego, supera la estatura máxima");
    }
  }
  else {
    if (edad <= 12){
      System.out.println("No puede subir al juego. No supera la estatura de seguridad mínima solicitada");
      System.out.println(" Sin embargo puedes acceder a los siguientes juegos infantiles: Calesita, Paseo de Cisnes y Tren de la alegría");
    }
    else {
      System.out.println("No puede subir al juego. No supera la estatura de seguridad mínima solicitada");
      System.out.println(" Sin embargo puedes acceder a los siguientes juegos: Noria, Casa embrujada y Montaña de Agua");    
    }
  }
```

>💡**Nota:** _El código se podría optimizar en este ejercicio logrando que se evalúe más de una condición dentro de un mismo if sin la necesidad de crear dos if diferentes._

<br>

### Estructura Switch

El `switch` en Java es una estructura de control que se utiliza para tomar decisiones basadas en el valor de una expresión o variable. Permite ejecutar diferentes bloques de código dependiendo del valor de la expresión. Es especialmente útil cuando tienes múltiples opciones y quieres realizar una acción diferente para cada opción.

Por ejemplo:

```java
int destino = 2;  // Cambia el valor para probar diferentes destinos

double costoEnvio;

switch (destino) {
    case 1:
        costoEnvio = 5.0; // Costo para el destino 1
        break;
    case 2:
        costoEnvio = 7.5; // Costo para el destino 2
        break;
    case 3:
        costoEnvio = 6.0; // Costo para el destino 3
        break;
    case 4:
        costoEnvio = 8.0; // Costo para el destino 4
        break;
    default:
        costoEnvio = 0.0; // Destino desconocido, costo cero
}

System.out.println("El costo de envío a destino " + destino + " es: $" + costoEnvio);
```

<br>

---
---

<br>

## Estructuras repetitivas

### Conceptos previos que debemos conocer

Antes de entrar con todo en el tema de las estructuras repetitivas, es importante que conozcamos una serie de conceptos claves para el correcto uso de las mismas.

- **Ciclo o Bucle:** Un ciclo o bucle es una estructura de control que permite la repetición de un conjunto de instrucciones un número determinado de veces o hasta que se cumpla una condición específica. Los bucles son fundamentales para la automatización de tareas repetitivas en programación.
    
- **Bucle controlado por contador:** Una estructura repetitiva controlada por contador es un tipo de bucle en el que se especifica el número de veces que se ejecutarán las instrucciones repetitivas. Generalmente, se utiliza una variable contador para llevar un registro de cuántas veces se ha ejecutado el bucle.
    
- **Bucle controlado por centinela/bandera:** Una estructura repetitiva controlada por centinela o bandera es un tipo de bucle en el que la repetición continúa mientras una condición específica, representada por una variable booleana (la "bandera" o "centinela"), es verdadera. Cuando la condición se vuelve falsa, el bucle se detiene.
    

Puedes ver estos conceptos un poco más en detalle en el siguiente video complementario:

[![](./resources/centinela-y-contador-screenshot.png)](https://youtu.be/ju2EypSdr1U)

<br>

### Estructura repetitiva: do while

El bucle `do-while` en Java es una estructura de control que se utiliza para repetir un bloque de código al menos una vez, y luego repetirlo mientras una condición sea verdadera.

- **Ejemplo:** Supongamos que deseas solicitar al usuario que ingrese números positivos, es decir, mayores que cero y que se termine la ejecución del bucle (se deje de pedir el ingreso de números) cuando alguno de los números ingresados sea un número negativo. Puedes usar un bucle do-while para lograrlo.

```java
import java.util.Scanner; 

public class EjemploDoWhile { 
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in); 
		int numeroIngresado; 
		
		do { 
			System.out.print("Ingresa un número positivo mayor que cero: ");
			numeroIngresado = scanner.nextInt();
		} while (numeroIngresado >= 0); 
		
		System.out.println("¡Has ingresado un número negativo: " + numeroIngresado + "!"); 
		System.out.println("FIN DE LA EJECUCIÓN"); } }
```

<br>

### Estructura repetitiva while

El bucle `while` en Java es una estructura de control que se utiliza para repetir un bloque de código mientras una condición especificada sea verdadera. Se ejecuta SOLO si se cumple la condición, a diferencia del doWhile el cual permite al menos un ingreso.

<br>

#### **Bucle while controlado por contador**

En un `bucle controlado por contador`, se ejecuta un bloque de código un número específico de veces, determinado por una variable llamada "contador".

- **Ejemplo:** Supongamos que deseas imprimir los números del 1 al 5 utilizando un bucle while controlado por contador:

```java
public class BucleControladoPorContador { 
	public static void main(String[] args) { 
		int contador = 1; 
		
		while (contador <= 5) { 
			System.out.println(contador); 
			contador++; 
		} 
	} 
}
```

<br>

#### **Bucle while controlado por centinela**

En un `bucle controlado por centinela`, se ejecuta un bloque de código repetidamente hasta que se cumple una condición específica que actúa como una "señal de parada".

Ejemplo: Supongamos que deseas leer nombres de personas hasta que el usuario ingrese "fin" como señal de parada

```java
import java.util.Scanner;

public class BucleControladoPorCentinela {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        boolean bandera = false;
        
        System.out.println("Ingresa nombres. Escribe 'fin' para detener.");
        
        while (bandera!=true) {
            System.out.print("Ingresa un nombre: ");
            nombre = scanner.next();
            
            if (nombre.equalsIgnoreCase("fin")) {
                bandera = true;
            }
            
            System.out.println("Hola, " + nombre + "!");
        }
        
        System.out.println("Fin del programa.");
    }
}
```

<br>

### **Estructura repetitiva for**

La estructura de control `for` en Java se utiliza para ejecutar un bloque de código un número específico de veces o para iterar sobre una secuencia de valores. Es una estructura de bucle versátil que consta de tres partes: inicialización, condición y expresión de incremento.

Funciona de la siguiente manera: primero, se establece una variable inicial, luego se verifica una condición. Si la condición es verdadera, se ejecuta un bloque de código y, finalmente, se actualiza la variable. Esto se repite hasta que la condición se vuelva falsa.

```java
for (int i = 0; i <5; i++) {
    System.out.println("Estoy en la vuelta Nº " + i);
}
```

>💡**Nota:** _La estructura for es, por excelencia, la más utilizada para recorrer vectores y matrices (arrays). Tema que veremos a continuación._

<br>

### Bucles Infinitos

Un `bucle infinito` es un tipo de ciclo que se produce en un programa en donde éste se ejecuta continuamente sin terminar. En otras palabras, las instrucciones dentro del bucle se repiten indefinidamente sin una condición que permita su salida.

Los bucles infinitos pueden causar problemas en un programa si no se gestionan adecuadamente, ya que pueden hacer que el mismo se ejecute de manera indefinida, ocasione un bloqueo o produzca un mal funcionamiento.

Veamos un ejemplo:

```java
int num = 5;
while (num < 10) {
    System.out.println("El número es: " + num);
    // El valor de 'num' nunca cambia, siempre será 5, lo que resulta en un bucle infinito
}
```

<br>

---
---

<br>

## Vectores y Matrices

<br>

### Vectores

Un vector, o arreglo unidimensional, es una serie ordenada de elementos del mismo tipo de dato que se pueden almacenar en diferentes "posiciones" (que podemos ver como cajas) dentro de una misma variable. Cada elemento o posición en el vector tiene una identificación única representada por un número llamado **índice**. Los vectores siempre empiezan su primera posición en 0 y la última en la cantidad de posiciones -1.

**Ejemplo visual de un vector**

```
  0   1   2   3   4
+---+---+---+---+---+
| 10| 20| 30| 40| 50|
+---+---+---+---+---+
```

**Ejemplo de código de un vector**

```java
public class EjemploVectores {
    public static void main(String[] args) {
        // Declaración e inicialización de un vector de números enteros
        int[] numeros = new int[5];

        // Asignación de valores a elementos individuales del vector
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        // Mostrar los valores del vector
        System.out.println("Valores en el vector:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento " + i + ": " + numeros[i]);
        }
    }
}
```

Puedes ver un ejemplo en video de cómo utilizar vectores en el siguiente video complementario: [Arreglos Unidimensionales en Java](https://youtu.be/AZc3hxMxl54?si=IQeik9zsc3mEB3DC)

<br>

### Matrices

Una matriz, o arreglo bidimensional, es una estructura que permite almacenar elementos o valores de un mismo tipo de dato en posiciones establecidas mediante dos índices: filas y columnas. La intersección entre una fila y una columna establece una posición de un vector.

**Ejemplo visual de una matriz**

```
+---+---+---+---+
| 90| 85| 78| 65|
+---+---+---+---+
| 15| 25| 92| 23|
+---+---+---+---+
| 35| 62| 45| 32|
+---+---+---+---+
| 31| 88| 92| 33|
+---+---+---+---+
```

**Ejemplo de código**

```java
public class CargarEdadesEnMatriz {
    public static void main(String[] args) {
        // Declaración e inicialización de la matriz de edades
        int[][] edades = new int[4][4];

        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese las edades
        System.out.println("Ingresa las edades para la matriz (4 filas x 4 columnas):");

        //carga de una matriz
        for (int fila=0; fila < 4; fila++) {
            for (int columna=0; columna < 4; columna++) {
                System.out.print("Ingresa la edad para la fila " + (fila + 1) + ", columna " + (columna + 1) + ": ");
                edades[fila][columna] = scanner.nextInt();
            }
        }
        // Recorrido/Muestra de una matriz
        System.out.println("Matriz de Edades:");
        for (int fila=0; fila < 4; fila++) {
            for (int columna=0; columna < 4; columna++) {
              System.out.println("Estoy en fila: " + fila + " columna: " + columna + " y se encuentra el valor: " + edades[fila][columna]);
            }
        }
```

Puedes ver un ejemplo en video de cómo utilizar vectores en el siguiente video complementario: [Matrices en Java](https://youtu.be/X8YFTykkGaQ?si=giXXbXiumltn3y28)

<br>

### Recorrido y carga de Arrays

Si bien en otros lenguajes de programación existen métodos específicos para el recorrido o carga de datos de arrays, en Java esto se lleva a cabo de diferente manera.

El recorrido de los arrays por "defecto" es de izquierda hacia la derecha y de arriba hacia abajo, es decir, recorriendo todas las columnas de una fila antes de pasar a la fila siguiente.

Si quieres ver un poco más sobre recorrido y carga de vectores y matrices en Java, te dejamos los siguientes videos de referencia:

- [Recorrido y carga de Vectores](https://youtu.be/DEK-tiJLa4Y?si=avXJc-cdnATKEeIi)
    
- [Recorrido y Carga de Matrices](https://youtu.be/Dpni7eA3Eiw?si=MAzfEtBqeT40irQG)

<br>

---
---

<br>

## Material complementario

### Ejercicios prácticos complementarios

¿Te has quedado con ganas de más? ¿Quieres probar hacer un ejercicio práctico? A continuación te dejamos una serie de propuestas de ejercicios prácticos que creemos que te pueden ser útiles para practicar.

- [Condicionales: Alumnos aprobados o desaprobados](https://youtu.be/VKfo9ginKvU?feature=shared)
    
- [Condicionales: Calcular sueldo de empleados](https://youtu.be/HqDDVjr4kvA?si=41Sw4GdVC48B-DIR)
    
- [Repetitivas: Mostrar números hasta límite](https://youtu.be/FDUZjsutPuY?si=ArhTK_-gvKZXQPTi)
    
- [Vectores: Carga y Recorrido de nombres](https://youtu.be/OaqXulu_yWo?si=KhPJKC50fVav6fO-)
    
- [Matrices: Sumar cada fila y columna](https://youtu.be/IyHrznsHnjY?feature=shared)

---
> [⬅️ Anterior: Funciones en Java](03-funciones-en-java.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Estructuras de control avanzadas ➡](05-estructuras-de-control-avanzadas.md)
