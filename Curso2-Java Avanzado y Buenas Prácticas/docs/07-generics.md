# 07. Genéricos en Java

En esta clase se abordarán las siguientes temáticas:

**Utils y Generics en Java**
- Generics en Java
- Ventajas de usar Generics
- Comodines (_Wildcards_)
- Uso avanzado de Generics
- Genéricos con JPA

<br>

## Generics en Java

Los **Generics (o genéricos)** en Java son una característica poderosa que permite a los desarrolladores escribir código más flexible y reutilizable. La idea fundamental detrás de los Generics es proporcionar una manera de crear clases, interfaces y métodos que operen con tipos específicos, pero que permitan a los usuarios decidir qué tipo de datos se utilizarán. Esto mejora la seguridad y la legibilidad del código al tiempo que fomenta la reutilización.

<br>

## Ventajas de usar Generics

1. **Seguridad de Tipos (_Type Safety_):** Los Generics ofrecen seguridad de tipos en tiempo de compilación, lo que significa que los errores de tipo se detectan antes de que el programa se ejecute.
    
2. **Reutilización de Código:** Permite escribir código que puede trabajar con diferentes tipos de datos, promoviendo la reutilización sin tener que duplicar la lógica del código.
    
3. **Abstracción de Datos:** Permite crear estructuras y algoritmos que son independientes del tipo de datos, proporcionando una mayor abstracción.

<br>

## Clases y métodos genéricos

```java
public class Caja<T> {
    private T contenido;

    public void ponerContenido(T contenido) {
        this.contenido = contenido;
    }

    public T obtenerContenido() {
        return contenido;
    }
}

// Uso de la clase genérica
Caja<String> cajaDeCadenas = new Caja<>();
cajaDeCadenas.ponerContenido("Hola, soy una cadena");
String contenido = cajaDeCadenas.obtenerContenido();
```

<br>

## Comodines (_Wildcards_)

Los comodines en Generics permiten escribir código que puede trabajar con tipos desconocidos. Hay dos tipos de comodines: el comodín sin restricciones (`<?>`) y el comodín con restricciones (`<? extends Tipo>` y `<? super Tipo>`).

<br>

### Comodín sin restricciones

```java
public void imprimirLista(List<?> lista) {
    for (Object elemento : lista) {
        System.out.println(elemento);
    }
}
```

<br>

### Comodín con restricciones

```java
public <T extends Comparable<T>> T encontrarMaximo(List<T> lista) {
    T maximo = lista.get(0);
    for (T elemento : lista) {
        if (elemento.compareTo(maximo) > 0) {
            maximo = elemento;
        }
    }
    return maximo;
}
```

<br>

### Bounded Type Parameters

```java
public class Caja<T extends Fruta> {
    private T contenido;

    // ...
}
```

<br>

## Uso avanzado de Generics

### Métodos genéricos con parámetros de tipo

```java
public <K, V> boolean compararPares(Pair<K, V> p1, Pair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
}
```

<br>

### Uso de Generics en Interfaces

```java
public interface Contenedor<T> {
    void agregar(T elemento);
    T obtener(int indice);
}
```

Los Generics en Java proporcionan una forma poderosa y segura de trabajar con tipos de datos de manera flexible y reutilizable. Al entender y aplicar adecuadamente esta característica, los desarrolladores pueden escribir código más robusto y fácilmente adaptable a diferentes situaciones. Recuerda que la correcta aplicación de Generics puede conducir a un código más limpio, menos propenso a errores y más fácil de entender y mantener. ¡Aprovecha al máximo esta herramienta en tu desarrollo en Java!

<br>

## Ejemplo práctico de Generics

Imagina que estás desarrollando un sistema de gestión de inventario para una tienda en línea que vende diferentes tipos de productos, como electrónicos, ropa y libros. Utilizar Generics puede ser beneficioso en este escenario para manejar de manera eficiente el inventario diverso.

**¡Veamos cómo hacerlo!**

Supongamos que tienes una clase `Producto` que representa un artículo en el inventario:

```java
public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
}
```

Luego, puedes crear una clase Inventario que utiliza Generics para gestionar el inventario de manera más general:

```java
import java.util.ArrayList;
import java.util.List;

public class Inventario<T extends Producto> {
    private List<T> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
        System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (T producto : productos) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    // Otros métodos relacionados con la gestión del inventario
}
```

Ahora, puedes usar la clase `Inventario` con diferentes tipos de productos. Por ejemplo:

```java
public class TiendaEnLinea {

    public static void main(String[] args) {
        // Crear inventario para electrónicos
        Inventario<Electronico> inventarioElectronico = new Inventario<>();
        inventarioElectronico.agregarProducto(new Electronico("Laptop", 1200.0, "MarcaX"));
        inventarioElectronico.agregarProducto(new Electronico("Smartphone", 800.0, "MarcaY"));

        // Crear inventario para ropa
        Inventario<Ropa> inventarioRopa = new Inventario<>();
        inventarioRopa.agregarProducto(new Ropa("Camiseta", 20.0, "M", "Algodón"));
        inventarioRopa.agregarProducto(new Ropa("Jeans", 50.0, "32", "Denim"));

        // Crear inventario para libros
        Inventario<Libro> inventarioLibros = new Inventario<>();
        inventarioLibros.agregarProducto(new Libro("Java 101", 29.99, "John Doe"));
        inventarioLibros.agregarProducto(new Libro("Historia del Arte", 39.99, "Jane Smith"));

        // Mostrar inventarios
        inventarioElectronico.mostrarInventario();
        inventarioRopa.mostrarInventario();
        inventarioLibros.mostrarInventario();
    }
}
```



En este ejemplo, Electronico, Ropa, y Libro son subclases de Producto. La clase `Inventario` se especializa con Generics para aceptar cualquier tipo de producto. Esto facilita la gestión de diferentes inventarios para diferentes categorías de productos, y el código es más genérico y reutilizable.

**¡Veamos un par videos teórico/prácticos para completar todo lo que hemos aprendido!**

[![](./resources/list-screenshot.png)](https://youtu.be/GKJl-4oNUWg)

[![](./resources/programacion-generica-screenshot.png)](https://youtu.be/MFu8a_LpnIc)

<br>

## Genéricos con JPA

Que podemos hacer también con los Genéricos en nuestras entidades? Podemos reutilizar nuestro código cambiando nuestros tipos de datos correspondiente a uno genérico.

```java
public class GenericoJPA<T> {

    private Class<T> entidadGenerica;

    public GenericoJPA(Class<T> entidadGenerica) {
        this.entidadGenerica = entidadGenerica;
    }

    public void createGeneric(T nuevaEntidad) {
        EntityManager em = ConfigJPA.getEntityManager();

        try{
            em.getTransaction().begin();
            //Guardar el registro en la tabla
            em.persist(nuevaEntidad);
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }

    public Optional<T> findOneGeneric(Integer idBuscado){
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return  Optional.ofNullable(em.find(this.entidadGenerica, idBuscado));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return  Optional.ofNullable(null);
    }

    public List<T> findAllGeneric(){
        EntityManager em = ConfigJPA.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.entidadGenerica);
        Root<T> root = cq.from(this.entidadGenerica);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public void updateGeneric(T actualizarElemento){
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(actualizarElemento);
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }

    public void deleteGeneric(Integer idEliminar){
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin();

            Optional<T> elementoEncontrado = Optional.ofNullable(em.find(this.entidadGenerica, idEliminar));

            if (elementoEncontrado.isPresent()){
                em.remove(elementoEncontrado.get());
            }else{
                System.out.println("El id " + idEliminar + " de la tabla " + this.entidadGenerica.getSimpleName() + " no existe");
            }
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
           em.close();
        }
    }

}
```

 Este código proporciona una capa de acceso a datos genérica y reutilizable para aplicaciones Java que utilizan JPA. Facilita la interacción con la base de datos al abstraer las operaciones CRUD y manejar transacciones y excepciones.

---
[⬅️ Volver al índice](./README.md)