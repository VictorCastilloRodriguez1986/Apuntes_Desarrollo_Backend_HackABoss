# 15. Relaciones en Java

En esta clase se abordarán las siguientes temáticas:

- Relaciones entre clases **Java**

**Tipos de datos para crear relaciones**
- Set
- Set en Objetos
- List
- List en Objetos

<br>

## Relaciones entre clases Java

En la programación orientada a objetos, las clases se relacionan de varias formas para modelar y organizar el comportamiento y la estructura de un sistema. En Java, estas relaciones se establecen principalmente a través de la herencia, la composición y la asociación mediante diferentes técnicas (Objetos, _Collections_, etc.).

**¡Veamos cada una de ellas!**

<br>

### Herencia

Ya conocemos la herencia, donde se permite que una clase adquiera propiedades (campos y métodos) de otra. En Java, se logra mediante la palabra clave `extends`. Una clase que hereda se denomina subclase o clase hija, y la clase de la cual se hereda se llama superclase o clase padre.

**Ejemplo:**

```java
// Superclase
class Vehiculo {
    // Atributos y métodos
}

// Subclase que hereda de Vehiculo
class Coche extends Vehiculo {
    // Atributos y métodos específicos del Coche
}
```

<br>

### **Relación 1 a 1**

En una relación 1 a 1, un objeto de una clase está asociado con exactamente un objeto de otra.

**Ejemplo:**

```java
class Persona {
    private String nombre;
    private Direccion direccion;

    // Constructor, getters y setters
}

class Direccion {
    private String calle;
    private String ciudad;
    // Otros atributos de dirección

    // Constructor, getters y setters
}
```

En este caso, la clase `Persona` tiene una única `Direccion`. Cada instancia de `Persona` está asociada con exactamente una instancia de `Direccion`.

<br>

### **Relación 1 a n**

En una relación 1 a n, un objeto de una clase está asociado con múltiples objetos de otra clase.

**Ejemplo:**

```java
class Departamento {
    private String nombre;
    // Otros atributos del departamento

    // Constructor, getters y setters
}

class Empleado {
    private String nombre;
    private Departamento departamento;

    // Constructor, getters y setters
}
```

En este caso, la clase `Departamento` puede tener múltiples instancias de la clase `Empleado`, pero cada instancia de `Empleado` está asociada con un único `Departamento`.

<br>

### **Relación n a n**

En una relación n a n, múltiples objetos de una clase están asociados con múltiples objetos de otra clase.

**Ejemplo:**

```java
class Estudiante {
    private String nombre;
    // Otros atributos del estudiante

    // Constructor, getters y setters
}

class Curso {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Curso() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Otros métodos para gestionar los estudiantes en el curso
}
```

En este ejemplo, la clase `Curso` tiene una lista de `Estudiante`. Varios estudiantes pueden estar asociados con varios cursos.

Estos son solo ejemplos simples de cómo podrían verse estas relaciones en Java utilizando objetos y colecciones. Dependiendo de las necesidades del sistema, estas relaciones podrían ser más complejas y requerirían una modelización más detallada.

Para ver un ejemplo práctico más a fondo de este tema, te dejamos a continuación un video teórico-práctico:

[![](./resources/relacion-entre-clases-screenshot.png)](https://youtu.be/XKk5k9OrAUg)

<br>

# Uso de Set y List en Java para Relacionar Objetos con Colecciones

En Java, las colecciones son estructuras de datos que permiten almacenar múltiples elementos. Dos de las colecciones más utilizadas son **Set** y **List**, y son especialmente útiles cuando necesitamos relacionar objetos con una colección de elementos.

<br>

## Set en Java

El **Set** es una colección que no permite elementos duplicados y no garantiza el orden de los elementos. Las implementaciones más comunes son:

- **HashSet:** No garantiza el orden de los elementos.
- **LinkedHashSet:** Mantiene el orden de inserción.
- **TreeSet:** Ordena los elementos de manera natural o mediante un comparador.

<br>

### Características principales:

- No permite duplicados.
- Permite almacenar elementos únicos.
- Puede contener objetos de cualquier tipo.

<br>

### Ejemplo 1: Uso de HashSet

```java

public class EjemploHashSet {
    public static void main(String[] args) {
        Set<String> frutas = new HashSet<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Manzana"); // Duplicado, no se agregará

        System.out.println("Frutas: " + frutas);
    }
}
```

**Salida:**

```
Frutas: [Banana, Manzana, Naranja]
```

<br>

### Ejemplo 2: Uso de Set en un Objeto Persona

```java

class Tarjeta {
    private String numero;
    public Tarjeta(String numero) { this.numero = numero; }
    public String getNumero() { return numero; }
}

class Persona {
    private String nombre;
    private Set<Tarjeta> tarjetas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.tarjetas = new HashSet<>();
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public Set<Tarjeta> getTarjetas() {
        return tarjetas;
    }
}

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Carlos");
        persona.agregarTarjeta(new Tarjeta("1234-5678-9101"));
        persona.agregarTarjeta(new Tarjeta("1111-2222-3333"));

        System.out.println("Tarjetas de " + persona.getTarjetas().size() + " persona(s).");
    }
}
```

<br>

## List en Java

Recordemos rapidamente que las **List** es una colección ordenada que permite elementos duplicados. Las implementaciones más comunes son:

- **ArrayList:** Implementación basada en un array redimensionable.
- **LinkedList:** Implementación basada en una lista doblemente enlazada.

<br>

### Características principales:

- Permite elementos duplicados.
- Los elementos están ordenados según su posición.
- Permite el acceso aleatorio a través de índices.

<br>

### Ejemplo 1: Uso de ArrayList

```java

public static void main(String[] args) {
    List<String> nombres = new ArrayList<>();
    nombres.add("Ana");
    nombres.add("Luis");
    nombres.add("Carlos");
    nombres.add("Ana"); // Permitido duplicado

    System.out.println("Lista de nombres: " + nombres);
}
```

**Salida:**

```
Lista de nombres: [Ana, Luis, Carlos, Ana]
```

<br>

### Ejemplo 2: Uso de List en un Objeto Persona

```java
import java.util.ArrayList;
import java.util.List;

class Tarjeta {
    private String numero;

    public Tarjeta(String numero) { 
        this.numero = numero; 
    }
    public String getNumero() { return numero; }
}

class Persona {

    private String nombre;
    private List<Tarjeta> tarjetas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.tarjetas = new ArrayList<>();
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Persona persona = new Persona("María");
        persona.agregarTarjeta(new Tarjeta("5555-6666-7777"));
        persona.agregarTarjeta(new Tarjeta("8888-9999-0000"));

        System.out.println("Tarjetas de " + persona.getTarjetas().size() + " persona(s).");
    }
}
```

<br>

## Conclusión

- Utiliza **Set** cuando necesitas garantizar la unicidad de los elementos.
- Utiliza **List** cuando necesitas conservar el orden de inserción o permitir duplicados.

¡Espero que estos conceptos y ejemplos sean útiles para tus estudiantes! Si necesitas más detalles o ejemplos específicos, ¡avísame!

---
[⬅️ Volver al índice](./README.md)
