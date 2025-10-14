# 02. Excepciones mas comunes.

En esta clase se abordarán las siguientes temáticas:

- **Excepciones Comunes en Java**
    - NullPointerException
    - ArrayIndexOutOfBoundsException
    - IllegalArgumentException
    - NumberFormatException
    - IOException (FileNotFoundException)
    - ClassCastException
    - StringIndexOutOfBoundsException
    - ArithmeticException
    - NoSuchElementException
    - UnsupportedOperationException
    - IllegalStateException
    - InterruptedException
    - NegativeArraySizeException
    - NoSuchMethodException
    - ClassNotFoundException

---

### NullPointerException

Este ocurre cuando se intenta acceder a un objeto que es null mediante sus propiedades o métodos. Es una de las excepciones más frecuentes y suele indicar un error de programación.


```java
    public static void main(String[] args) {
        String texto = null;
        System.out.println(texto.length()); // Lanza NullPointerException   
    }
```

---

### ArrayIndexOutOfBoundsException:

Este ocurre cuando se intenta acceder a un elemento de un array con un índice fuera de rango.


```java
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[10]); // Lanza ArrayIndexOutOfBoundsException 
    }
```

---


### IllegalArgumentException:

Ocurre cuando se pasa un argumento inválido a un método.


```java
    public static void main(String[] args) {
        setEdad(-5);
    }

    public static void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        System.out.println("Edad establecida: " + edad);
    }
```

---


### NumberFormatException:

Ocurre cuando se intenta convertir una cadena a un número con un formato incorrecto.


```java
    public static void main(String[] args) {
        int numero = Integer.parseInt("abc"); // Lanza NumberFormatException
    }
```

---

### IOException (FileNotFoundException):

Esta excepción es una subclase de IOException, y ocurre especificamente cuando se intenta acceder a un archivo que no se encuentra en el sistema.

```java
    public static void main(String[] args) throws IOException {
        File archivo = new File("archivo_que_no_existe.txt");
        FileReader lector = new FileReader(archivo); // Lanza FileNotFoundException
        lector.close();
    }
```

---

### ClassCastException:

Ocurre cuando intentas convertir un objeto a una clase de la que no es una instancia.

```java
    public static void main(String[] args) {
        Object obj = "Hola";
        Integer num = (Integer) obj; // Lanza ClassCastException
    }
```

---

### StringIndexOutOfBoundsException

Ocurre si se intenta acceder a un índice fuera del rango de una cadena de caracteres (String).

```java
     public static void main(String[] args) {
        String texto = "Hola";
        char letra = texto.charAt(10);  // Lanza StringIndexOutOfBoundsException
    }
```

---


### ArithmeticException

Se produce una operación aritmética inválida, como dividir por cero.

```java
    public static void main(String[] args) {
        int resultado = 10 / 0; // Lanza ArithmeticException
    }
```

---

### NoSuchElementException

Se intenta acceder al Scanner que fue creado con una cadena vacía, y next() no encuentra ningún token.

```java
    public static void main(String[] args) {
        Scanner scanner = new Scanner("");
        scanner.nextInt(); // Lanza NoSuchElementException
    }
```

---


### UnsupportedOperationException

Se intenta realizar una operación no soportada en una colección.

```java
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Uno", "Dos", "Tres");
        lista = Collections.unmodifiableList(lista);  		// Ejecutamos el método para que no se pueda modificar mas la lista anterior
        lista.add("Cuatro"); 				// Lanza UnsupportedOperationException
    }
```

---


### IllegalStateException

Se intenta realizar una operación en un objeto que no está en un estado válido.

```java
    public static void main(String[] args) {
         Scanner scanner = new Scanner("Hola");
         scanner.close();
         scanner.next(); // Lanza IllegalStateException
    }
```

---


### InterruptedException

Un hilo es interrumpido mientras está en espera, durmiendo o bloqueado.

```java
     public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().interrupt(); //Creamos un Hilo, pero marcamos el hilo como interrumpido

        // Esto lanza InterruptedException inmediatamente porque el hilo ya está interrumpido
        Thread.sleep(1000);
    }
```

---


### NegativeArraySizeException

Se intenta crear un array con un tamaño negativo.

```java
    public static void main(String[] args) {
        int[] numeros = new int[-1]; // Lanza NegativeArraySizeException
    }
```

---


### NoSuchMethodException

Se intenta acceder a un método que no existe en una clase.

```java
     public static void main(String[] args) throws NoSuchMethodException {
        Method metodo = String.class.getMethod("metodoInexistente");   // Lanza NoSuchMethodException
    }
```

---


### ClassNotFoundException

Se intenta cargar una clase que no se encuentra en el classpath.

```java
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("ClaseInexistente"); // Lanza ClassNotFoundException
    }
```

---