# 06. Programación Funcional con Optionals en Java

En esta clase se abordarán las siguientes temáticas:

- **Programación Funcional con Optionals en Java**
    - Introducción a Optionals
    - Características clave de Optionals
    - Creación de Optionals
    - Operaciones comunes con Optionals

<br>

### Introducción a Optionals

`Optional` es una clase en Java que se utiliza para representar un valor que puede ser nulo. Su objetivo principal es evitar las excepciones `NullPointerException` al trabajar con valores que podrían ser nulos.

<br>

### Características clave de Optionals

1. **Presente o Ausente:** Un `Optional` puede contener un valor o estar vacío.
    
2. **Evita NPE:** Proporciona métodos seguros para acceder y operar sobre valores que podrían ser nulos.
    
3. **Encadenamiento Seguro:** Puedes encadenar operaciones sin preocuparte por valores nulos intermedios.

<br>

### Creación de Optionals

- **Creación de un Optional con Valor**

```java
Optional<String> optionalConValor = Optional.of("Este es un valor");
```

- **Creación de un Optional Vacío**

```java
Optional<String> optionalVacio = Optional.empty();
```

- **Creación de un Optional con posibilidad de Valor Nulo**

```java
String valorNullable = // obtener un valor, que podría ser nulo
Optional<String> optionalNullable = Optional.ofNullable(valorNullable);
```

<br>

### Operaciones comunes con Optionals

- `isPresent()`: Verifica si el _Optional_ contiene un valor.
    
- `ifPresent(Consumer consumer`): Ejecuta una acción si el _Optional_ contiene un valor.
    
- `orElse(T other)`: Devuelve el valor contenido o un valor predeterminado si está vacío.
    
- `orElseGet(Supplier<? extends T> other)`: Devuelve el valor contenido o el resultado de un proveedor si está vacío.
    
- `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Devuelve el valor contenido o lanza una excepción si está vacío.

<br>

### Ejemplo de uso de Streams y Optionals en conjunto

Supongamos que tenemos una lista de Personas y queremos encontrar el nombre de la primera persona cuya edad sea mayor que 25.

```java
List<Persona> personas = // Obtener la lista de personas
String nombrePrimeraPersonaMayorDe25 = personas.stream()
        .filter(p -> p.getEdad() > 25)
        .findFirst()
        .map(Persona::getNombre)
        .orElse("No hay ninguna persona mayor de 25 años");
```

En este ejemplo, `findFirst()` devuelve un _Optional_ que puede contener o no el resultado. Luego, utilizamos `map()` para obtener el nombre si está presente y, finalmente, usamos `orElse()` para proporcionar un valor predeterminado si no se encuentra ninguna persona mayor de 25 años.

<br>

## Videos explicativos

¡Complementemos nuestra información mediante videos explicativos!

[![](./resources/optional-1-screenshot.png)](https://youtu.be/aUGA7bUTG_0)

[![](./resources/optional-2-screenshot.png)](https://youtu.be/ZqvbRCdZx8M)

[![](./resources/optional-3-screenshot.png)](https://youtu.be/vX-JAs73O9o)

---
[⬅️ Volver al índice](./README.md)