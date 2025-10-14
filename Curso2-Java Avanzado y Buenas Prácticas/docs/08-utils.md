# 08. Utilidades comunes propias de Java (Utils)

Java proporciona un conjunto robusto de utilidades en su biblioteca estándar que facilitan el desarrollo de aplicaciones. Estas utilidades, a menudo agrupadas en clases de utilidad, abarcan desde manipulación de cadenas hasta manejo de fechas, operaciones matemáticas y más. Estas clases se encuentran en el paquete `java.util` y otros paquetes relacionados.

<br>

### Clase java.util.Arrays

La clase Arrays proporciona métodos estáticos para trabajar con matrices (_arrays_) en Java. Algunas operaciones comunes incluyen:

<br>

#### Ordenación de Matrices

```java
int[] numeros = {4, 2, 8, 1, 6, 3, 7};
Arrays.sort(numeros);
```

<br>

#### Búsqueda en Matrices

```java
int indice = Arrays.binarySearch(numeros, 6);
```

<br>

#### Conversión a Cadena

```java
String cadena = Arrays.toString(numeros);
```

<br>

### Clase java.util.Collections

La clase Collections proporciona métodos estáticos para operaciones en colecciones, como listas, conjuntos y mapas. Algunas operaciones comunes incluyen:

<br>

#### Ordenación de Colecciones

```java
List<String> nombres = Arrays.asList("Ana", "Carlos", "David");
Collections.sort(nombres);
```

<br>

#### Búsqueda en Colecciones

```java
int indice = Collections.binarySearch(nombres, "Carlos");
```

<br>

#### Inversión de Colecciones

```java
Collections.reverse(nombres);
```

<br>

### Clase java.util.StringJoiner

La clase `StringJoiner` facilita la construcción de cadenas concatenando elementos con un delimitador. Por ejemplo:

```java
StringJoiner sj = new StringJoiner(", ", "[", "]");
sj.add("Manzana").add("Banana").add("Cereza");
String resultado = sj.toString();
// Resultado: "[Manzana, Banana, Cereza]"
```

<br>

### Clase java.util.StringTokenizer

La clase StringTokenizer se utiliza para dividir una cadena en "tokens" utilizando un delimitador específico. Por ejemplo:

```java
StringTokenizer tokenizer = new StringTokenizer("Java es un lenguaje de programación", " ");
while (tokenizer.hasMoreTokens()) {
    String token = tokenizer.nextToken();
    // Hacer algo con cada token
}
```

<br>

### Clase java.util.Date y java.util.Calendar

Las clases Date y Calendar se utilizan para trabajar con fechas y horas en Java. Sin embargo, se recomienda el uso de las nuevas clases introducidas en Java 8 en el paquete `java.time`, como `LocalDate` y `LocalDateTime`, que ofrecen una API más moderna y segura.

<br>

### Clase java.util.Random

La clase Random se utiliza para generar números aleatorios. Proporciona métodos para obtener números enteros, números en punto flotante y otros tipos. Por ejemplo:

```java
Random random = new Random();
int numeroAleatorio = random.nextInt(100);  // Genera un número aleatorio entre 0 (inclusive) y 100 (exclusive)
```

<br>

### Clase java.util.Scanner

La clase Scanner se utiliza para analizar datos de entrada desde diferentes fuentes, como la entrada estándar o un archivo. Por ejemplo:

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Ingrese su nombre: ");
String nombre = scanner.nextLine();
System.out.println("Hola, " + nombre + "!");
```

<br>

### Clase java.util.regex

El paquete `java.util.regex` proporciona clases para el manejo de expresiones regulares. Puedes utilizar la clase `Pattern` para compilar expresiones regulares y `Matcher` para realizar operaciones de coincidencia. Por ejemplo:

```java
Pattern patron = Pattern.compile("[0-9]+");
Matcher matcher = patron.matcher("12345");
boolean esNumero = matcher.matches();  // Devuelve true
```

<br>

### Clase java.util.Properties

La clase Properties se utiliza para gestionar propiedades del sistema o configuraciones de la aplicación en forma de pares clave-valor. Por ejemplo:

```java
Properties propiedades = new Properties();
propiedades.setProperty("database.url", "jdbc:mysql://localhost:3306/mi_database");
propiedades.setProperty("usuario", "admin");
// ... Más configuraciones
```

Estas tareas cubren algunas de las utilidades adicionales que Java proporciona para tareas comunes. Puedes explorar más en la documentación oficial de Java para obtener información detallada sobre cada una de estas clases y cómo utilizarlas eficientemente en tus aplicaciones.

<br>

## Ejemplo práctico Integrador de Utils

Supongamos que tienes una lista de comentarios de usuarios y deseas realizar algunas operaciones en ellos, como contar las palabras más frecuentes y aplicar un filtro para censurar ciertas palabras u operaciones comunes de texto. Utilizaremos algunas clases de utilidades de Java para esto:

```java
import java.util.*;

public class ProcesadorComentarios {

    public static void main(String[] args) {
        // Lista de comentarios de usuarios
        List<String> comentarios = Arrays.asList(
                "Este producto es genial. ¡Lo recomiendo!",
                "No estoy satisfecho con el servicio al cliente.",
                "Increíble oferta. ¡Compré dos!",
                "El envío fue rápido y el producto llegó en perfecto estado.",
                "No recomendaría este producto a nadie."
        );

        // Contar palabras más frecuentes
        Map<String, Integer> frecuenciaPalabras = contarPalabras(comentarios);
        System.out.println("Palabras más frecuentes:");
        frecuenciaPalabras.forEach((palabra, frecuencia) -> System.out.println(palabra + ": " + frecuencia));

        // Censurar ciertas palabras
        List<String> palabrasCensuradas = Arrays.asList("genial", "recomendaría", "rápido", "perfecto");
        List<String> comentariosCensurados = censurarPalabras(comentarios, palabrasCensuradas);
        System.out.println("\nComentarios censurados:");
        comentariosCensurados.forEach(System.out::println);
    }

    // Utilizando la clase java.util.StringTokenizer para contar palabras
    private static Map<String, Integer> contarPalabras(List<String> comentarios) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        for (String comentario : comentarios) {
            StringTokenizer tokenizer = new StringTokenizer(comentario.toLowerCase(), " .,!?");
            while (tokenizer.hasMoreTokens()) {
                String palabra = tokenizer.nextToken();
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }

        // Ordenar por frecuencia descendente
        return sortByValueDescending(frecuenciaPalabras);
    }

    // Utilizando la clase java.util.Collections para ordenar un Map por valores de forma descendente
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map) {
        List<Map.Entry<K, V>> listaEntradas = new ArrayList<>(map.entrySet());
        listaEntradas.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        Map<K, V> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<K, V> entrada : listaEntradas) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }

        return mapaOrdenado;
    }

    // Utilizando la clase java.util.StringJoiner para censurar palabras
    private static List<String> censurarPalabras(List<String> comentarios, List<String> palabrasCensuradas) {
        List<String> comentariosCensurados = new ArrayList<>();

        for (String comentario : comentarios) {
            StringJoiner joiner = new StringJoiner(" ");
            StringTokenizer tokenizer = new StringTokenizer(comentario, " ");
            while (tokenizer.hasMoreTokens()) {
                String palabra = tokenizer.nextToken();
                if (palabrasCensuradas.contains(palabra.toLowerCase())) {
                    // Censurar la palabra
                    joiner.add("*censurado*");
                } else {
                    joiner.add(palabra);
                }
            }
            comentariosCensurados.add(joiner.toString());
        }

        return comentariosCensurados;
    }
}
```

En este ejemplo:

- Se utiliza `StringTokenizer` para contar las palabras más frecuentes en los comentarios.
    
- Se utiliza `StringJoiner` para censurar palabras específicas en los comentarios.
    
- Se utiliza `Collections.reverseOrder` para ordenar un mapa por sus valores de forma descendente.

<br>

## Consumer, supplier, predicate y operators

Estos son conceptos clave en el paquete `java.util.function` de Java, que se introdujeron con Java 8 como parte de las expresiones lambda y las funciones de orden superior. Veamos un poco cada uno de ellos:

<br>

### Consumer

- La interfaz _Consumer_ representa una operación que toma un argumento de tipo T y no devuelve ningún resultado.
    
- Método que utiliza: `void accept(T t)`: Realiza la operación en el argumento dado.

<br>

#### Ejemplo

```java
Consumer<String> imprimirMensaje = mensaje -> System.out.println(mensaje);
imprimirMensaje.accept("Hola, mundo!");
```

<br>

### Supplier

- La interfaz _Supplier_ representa un proveedor de resultados de tipo T.
    
- Método que utiliza: `T get()`: Devuelve un resultado de tipo T.
    
<br>

#### Ejemplo

```java
Supplier<Double> obtenerNumeroAleatorio = () -> Math.random();
double numeroAleatorio = obtenerNumeroAleatorio.get();
```

<br>

### Predicate

- La interfaz Predicate representa una condición que se evalúa en un objeto de tipo T.
    
- Método que utiliza: `boolean test(T t)`: Evalúa la condición en el objeto dado y devuelve true o false.

<br>

#### Ejemplo

```java
Predicate<Integer> esPar = numero -> numero % 2 == 0;
boolean resultado = esPar.test(4);  // Devuelve true
```

<br>

### Operator

- La interfaz UnaryOperator representa una operación que toma un solo argumento de tipo T y devuelve un resultado de tipo T.
    
- Método que utiliza: `T apply(T t)`: Realiza la operación en el argumento dado y devuelve el resultado.

<br>

#### Ejemplo

```java
UnaryOperator<Integer> duplicar = numero -> numero * 2;
int resultado = duplicar.apply(5);  // Devuelve 10
```

Estas interfaces funcionales proporcionan una manera concisa y flexible de expresar comportamientos en forma de funciones, lo que resulta útil en situaciones como el uso de Streams, programación funcional y expresiones lambda en Java.

---
[⬅️ Volver al índice](./README.md)