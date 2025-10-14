# 10. Clases Utilitarias

<br>

## Métodos Estáticos

### ¿Qué son los métodos estáticos?

- Son métodos asociados a la clase y no a instancias.
  
- Se definen con la palabra clave `static`.
  
- No pueden acceder a atributos de instancia directamente.

<br>

### Ejemplo

```java
class Util {
    public static int sumar(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        int resultado = Util.sumar(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}
```  

<br>

---
---

<br>

## Ventajas de los Métodos Estáticos

-  Se pueden llamar sin crear instancias.  

- Son útiles para operaciones generales.  

- Mejoran la eficiencia y reutilización del código.  

> ⚠ **Limitación:** No pueden acceder a atributos o métodos no estáticos de la clase.  

<br>

---
---

<br>

## Clases Utilitarias

### ¿Qué es una clase utilitaria?

- Son clases diseñadas para contener solo métodos `static`.
  
- Se usan para funciones de ayuda, cálculos, validaciones, etc.
  
- Generalmente, su constructor es privado para evitar instancias.

<br>

### Ejemplo

```java
class MathUtil {
    private MathUtil() {} // Evita instancias

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
```

<br>

---
---

<br>

## Ejemplos de Clases Utilitarias

-  **`Math`** (Java Standard)  
   - Métodos: `Math.sqrt()`, `Math.pow()`, `Math.random()`  

-  **`Collections`** (Manejo de listas)  
   - Métodos: `Collections.sort()`, `Collections.reverse()`  

-  **Nuestra propia clase utilitaria**  
   - Agrupa funciones específicas según necesidades del proyecto.  

<br>

---
---

<br>

## Menú de Opciones con `switch`

### ¿Qué es un menú con `switch`?

- Permite ejecutar diferentes acciones según la opción ingresada.
  
- Se usa `Scanner` para leer la entrada del usuario.

<br>

### Ejemplo de código

```java
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Saludar");
        System.out.println("2. Mostrar fecha");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                ClaseUtilitaria.metodoEstatico("¡Hola, bienvenido!");
                break;
            case 2:
                ClaseUtilitaria.otroMetodoEstatico("¡Hola, bienvenido!");
                break;
            case 3:
                ClaseUtilitaria.otroMetodoEstatico("¡Hola, bienvenido!");
                break;
            default:
                ClaseUtilitaria.otroMetodoEstatico("¡Hola, bienvenido!");
        }
        scanner.close();
    }
}
```  

<br>

## Explicación del `switch`

<br>

### ¿Cómo funciona?

- Se evalúa la opción ingresada.
  
- Se ejecuta el `case` correspondiente.
  
- `break` evita que el código siga ejecutándose.

- `default` maneja entradas no reconocidas.

<br>

### ¿Dónde se usa?

- Menús de opciones en consola.
  
- Programas con múltiples comandos.
  
- Interfaces gráficas con múltiples botones.

---
> [⬅️ Anterior: Collections en Java](09-collections-en-java.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Introducción a JPA ➡](11-introduccion-a-jpa.md)
