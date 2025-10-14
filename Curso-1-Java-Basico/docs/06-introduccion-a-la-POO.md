# 06. Introducción a la POO

<br>

## Programación Orientada a Objeto - Temas a tratar

En esta clase se abordarán las siguientes temáticas:

- ¿Qué es la POO?
  
- Clases, Objetos e instancias
  
- Atributos y métodos
  
- Constructores, Getters y Setters

<br>

---
---

<br>

## ¿Qué es la POO?

La **Programación Orientada a Objetos (POO)** en Java es un paradigma de programación que se basa en la idea de que el mundo real puede ser modelado como una colección de objetos que interactúan entre sí.

En la POO, un objeto es una entidad que encapsula datos (atributos) y comportamientos (métodos) relacionados a un elemento/objeto que realmente puede existir en la vida real. Este paradigma se utiliza para organizar y diseñar programas de una manera más estructurada y modular.

<br>

---
---

<br>

## Clases, Objetos (atributos y métodos) e instancias

### Clases

<br>

- Una **clase** en Java puede ser visto como un plano o una plantilla que describe cómo deben ser los objetos. Por ejemplo, si tuviéramos a una PERSONA que quisiéramos representar en una aplicación, la plantilla con los datos necesarios de esa persona sería una clase.
    
- Para crear una clase nos tenemos que hacer las siguientes preguntas respecto a lo que queremos representar:
    - ¿Qué características tiene el objeto de la vida real que quiero representar? (propiedades)
    - ¿Qué hace o puede hacer ese objeto de la vida real? (comportamientos)

Ejemplo de una clase:

```java
 public class Persona {

   //atributos de la clase
   private int id;
   private String nombre;
   private int edad;
   private String direccion;
   private String numeroTelefono;

 //métodos de la clase
 public void caminar () {
   //lo que hace el método...
 }

 // otros métodos....
 }
```

<br>

### Objetos

- Un **objeto** es una instancia concreta basada en una clase. Es la representación de un objeto real que se crea a partir de un plano/plantilla (la clase). Un objeto tiene sus propios atributos y sus propios comportamientos o métodos, que son definidos por lo que se establece en la clase.
    
- Una **instancia** es un _objeto específico creado a partir de una clase_, es decir, en palabras simples "cuando creas un objeto a partir de una clase, estás creando una instancia de esa clase".

<br>

En resumen, una clase es un plano, un objeto es una cosa real basada en ese plano, y una instancia es una versión específica de ese objeto.

<br>

### Constructores, Getters y Setters

- Los métodos establecen los comportamientos que pueden tener los objetos, es decir, responden a la pregunta **¿Qué puede hacer el objeto?**.
    
- En conceptos de programación, los métodos representan funciones (devuelven un valor) y procedimientos (hacen una acción sin devolver valor como resultado)
    
- Todas las clases tienen 3 tipos de métodos con los que SIEMPRE deben contar:

<br>

#### **Constructores**
    
- Son métodos especiales dentro de una clase que se utilizan para inicializar los objetos creados. Pueden ser de dos tipos: con parámetros y vacíos.

**Ejemplo constructor vacío**
        
```java
 public Persona () {
 
}
```

**Ejemplo Constructor con parámetros**

```java
public Persona(int id, String nombre, int edad, String direccion, String numeroTelefono) {
this.id = id;
this.nombre = nombre;
this.edad = edad;
this.direccion = direccion;
this.numeroTelefono = numeroTelefono;
}
```

<br>

#### **Getters**
    
- Métodos que permiten obtener los valores de los atributos de cada objeto

```java
public int getId() {
   return id;
}

public String getNombre() {
   return nombre;
}

public int getEdad() {
   return edad;
}

public String getDireccion() {
   return direccion;
}

public String getNumeroTelefono() {
   return numeroTelefono;
}
```

<br>

#### **Setters**

Métodos que permiten "setear" (establecer) valores a los atributos de cada objeto.

```java
public void setId(int id) {
   this.id = id;
}

public void setNombre(String nombre) {
   this.nombre = nombre;
}

public void setEdad(int edad) {
   this.edad = edad;
}

public void setDireccion(String direccion) {
   this.direccion = direccion;
}

public void setNumeroTelefono(String numeroTelefono) {
   this.numeroTelefono = numeroTelefono;
}
```

- **Toda clase está compuesta entonces por:**
    - Atributos
    - Constructores
    - Getter
    - Setters

<br>

### ¿Cómo instanciar una clase?

Existen diferentes formas de instanciar una clase, todo depende de la situación y de qué manera o en qué momentos almacenaremos o asignaremos datos al objeto creado. Recordemos que "instanciar" una clase significa básicamente crear un objeto y para ello utilizamos los constructores.

Suponiendo el mismo ejemplo de la clase persona ¡Veamos dos formas de hacerlo!

<br>

#### **Instanciar mediante el constructor por parámetros**

```java
Persona persona = new Persona(2, "María", 25, "456 Calle Secundaria", "555-987-6543");
```

Se crea una instancia de la clase "Persona" utilizando el constructor con parámetros, lo que simplifica la asignación de los valores de los atributos en una sola línea

<br>

#### **Instanciar mediante constructor vacío**

```java
Persona persona1 = new Persona(); // Se crea un objeto vacío

/*cuando tengamos los datos (en cualquier momento de la ejecución del programa)
los asignamos mediante los métodos setters*/
persona1.setId(1);
persona1.setNombre("Juan");
persona1.setEdad(30);
persona1.setDireccion("123 Calle Principal");
persona1.setNumeroTelefono("555-123-4567");
```

<br>

---
---

<br>

## Material complementario

- [¿Qué es la POO?](https://youtu.be/tcza2FEz4u4?si=2yczk41jf7TfbpTh)
    
- [¿Por qué surge la POO?](https://youtu.be/pHVdGbVK7Cw?si=G2oDZYSS45frxefO)
    
- [Clases, Objetos y Abstracción](https://youtu.be/__xVG4tyv7A?si=VUG7hj8TemHL2H08)
    
- [¿Qué son las clases?¿Cómo crear una?](https://youtu.be/q9gZ9fjKIC0?si=68k0-UOyyygmVkek)
    
- [¿Qué es y cómo crear un método?](https://youtu.be/pXX3c8BloY0?si=l6s8WYe4wSdC5NXC)
    
- [Construcción de Objetos](https://youtu.be/l8NmSp7Dz-0?si=T_kKbq01f9vkoFl0)
    
- [Métodos Constructores y Objetos](https://youtu.be/fdfXkiuVHp4?si=7Z6WK-kiQG5oIryF)
    
- [Getters y Setters](https://youtu.be/gXvnHialu0s?si=-xMbZ5mGmI0UCs4N)

---
> [⬅️ Anterior: Estructuras de control avanzadas](05-estructuras-de-control-avanzadas.md) | 📂 [Volver al índice](./README.md) | [Siguiente: Propiedades de la POO ➡](07-propiedades-de-la-POO.md)
