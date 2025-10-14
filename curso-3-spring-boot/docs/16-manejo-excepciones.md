## Temas a tratar

En esta clase se abordarán las siguientes temáticas:


- **Control Centralizado de Excepciones**
- **Anotaciones de Spring**
    - @ControllerAdvice
    - @ExceptionHandler
    - ¿Cómo funciona?
    - Beneficios de usar @ControllerAdvice

---

## Control Centralizado de Excepciones en Spring Boot con @ControllerAdvice

### Introducción

En aplicaciones Spring Boot, manejar errores de forma consistente y clara es clave para una buena experiencia del desarrollador y del usuario. Spring proporciona herramientas como `@ControllerAdvice` y `@ExceptionHandler` para implementar un control centralizado de excepciones.

---

## @ControllerAdvice y @ExceptionHandler

### ¿Qué es @ControllerAdvice?

`@ControllerAdvice` es una anotación en Spring Framework que permite definir una clase que contenga métodos de manejo de excepciones y/o métodos de inicialización de modelos que se aplican globalmente a todos los controladores en tu aplicación. Es una herramienta poderosa para centralizar la gestión de errores y presentar respuestas consistentes a tus clientes cuando ocurren problemas.

### ¿Qué es @ExceptionHandler?

Se usa dentro de un `@ControllerAdvice` (o un `@RestController`) para manejar una excepción específica y devolver una respuesta personalizada.

### ¿Cómo funciona?

Cuando una excepción se lanza en un controlador de Spring Boot, el flujo de ejecución normal se detiene. Spring necesita una manera de interceptar esta excepción y transformarla en una respuesta HTTP significativa. Aquí es donde `@ControllerAdvice`entra en juego, en combinación con @ExceptionHandler.

- Interceptación Global: `@ControllerAdvice`actúa como un interceptor global para las excepciones. Cuando lo anotas en una clase, Spring la detecta automáticamente y la registra como un componente que puede manejar excepciones en cualquier controlador de la aplicación.
- Métodos @ExceptionHandler: Dentro de la clase @ControllerAdvice, defines métodos individuales que están anotados con @ExceptionHandler. Cada uno de estos métodos está diseñado para manejar un tipo específico de excepción.

    - Cuando se lanza una excepción en cualquier controlador, Spring busca un método @ExceptionHandler en cualquier `@ControllerAdvice`que esté configurado para manejar ese tipo particular de excepción (o una de sus superclases).
    - Si encuentra una coincidencia, ese método @ExceptionHandler se ejecuta.

- Transformación de la Respuesta: El método @ExceptionHandler tiene la responsabilidad de procesar la excepción y construir una respuesta HTTP apropiada. Esto típicamente implica:
    - Crear un objeto de respuesta (por ejemplo, un JSON) que contenga detalles sobre el error (código de error, mensaje descriptivo, etc.).

    - Establecer el código de estado HTTP adecuado (por ejemplo, 400 Bad Request, 404 Not Found, 500 Internal Server Error).
    - Devolver el objeto de respuesta.

### Beneficios de usar `@ControllerAdvice`
- Centralización: En lugar de duplicar el código de manejo de excepciones en cada controlador, puedes centralizar toda la lógica en una o varias clases @ControllerAdvice. Esto hace que tu código sea más limpio y fácil de mantener.

- Consistencia: Garantiza que todas las respuestas de error tengan un formato y una estructura consistentes, lo que mejora la experiencia del desarrollador del cliente que consume tu API.
- Separación de Preocupaciones: Separa la lógica de negocio de la lógica de manejo de errores, lo que mejora la modularidad del código.

- Reusabilidad: Los métodos @ExceptionHandler pueden ser reutilizados para manejar el mismo tipo de excepción en diferentes controladores.

- Flexibilidad: Puedes tener múltiples clases `@ControllerAdvice`para manejar diferentes categorías de excepciones (por ejemplo, una para errores de validación, otra para errores de negocio, etc.).
---

## Ejemplo: Sistema de Autos

### Clase Auto

```java
public class Auto {
    private Long id;
    private String marca;
    private String modelo;

    // getters, setters y constructor
}
```

### Excepción Personalizada

```java
public class AutoNotFoundException extends RuntimeException {
    public AutoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
```

### Controlador AutoController

```java
@RestController
@RequestMapping("/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/{id}")
    public Auto obtenerAuto(@PathVariable Long id) {
        return autoService.buscarPorId(id);
    }
}
```

### Servicio AutoService

```java
@Service
public class AutoService {
   
    public Auto buscarPorId(Long id) {

       //Logíca para validar si existe un id o no
        if (repository.findById(id) == null) {
            throw new AutoNotFoundException("Auto con ID " + id + " no encontrado");
        }
        return autos.get(id);
    }
}
```

### Clase de Control Centralizado

En este punto te recomendamos crear un paquete de excepciones donde tendrá tus excepciones y el controlador.

```java
@ControllerAdvice
public class ManejadorExcepciones {

    //Excepción Propia
    @ExceptionHandler(AutoNotFoundException.class)
    public ResponseEntity<String> manejarAutoNoEncontrado(AutoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Excepción Generales Java
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionesGenerales(Exception ex) {
        return new ResponseEntity<>("Error interno: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

## ¿Dónde arrojar las excepciones?

Las excepciones deben arrojarse principalmente en el **Service**, ya que es la capa donde se ejecuta la lógica del negocio. El Controller solo invoca y responde.

---

## Práctica Guiada

### Objetivo

Tomar un proyecto existente que no tenga manejo centralizado de excepciones y agregar `@ControllerAdvice` y excepciones personalizadas.

### Pasos

1. **Identificar puntos de fallo** en los servicios existentes (por ejemplo, búsqueda por ID).
2. **Crear excepciones personalizadas** para representar errores del dominio (por ejemplo, `ProductoNoEncontradoException`, `UsuarioInvalidoException`).
3. **Crear una clase con `@ControllerAdvice`**.
4. **Agregar métodos con `@ExceptionHandler`** para cada excepción personalizada.
5. **Agregar un handler genérico** para excepciones de Java no controladas.
6. **Modificar los servicios** para lanzar las excepciones personalizadas cuando corresponda.
7. **Probar la API** usando Postman o curl para validar las respuestas de error.

### Ejemplo de estructura final

```
/src
 └── exception
     ├── AutoNotFoundException.java
     └── ManejadorExcepciones.java
 └── controller
     └── AutoController.java
 └── service
     └── AutoService.java
 └── model
     └── Auto.java
```

---

## Conclusión

El control centralizado de excepciones mejora la legibilidad, mantenibilidad y profesionalismo del código. Usar `@ControllerAdvice` y `@ExceptionHandler` permite manejar errores de forma elegante y consistente en toda la aplicación.
