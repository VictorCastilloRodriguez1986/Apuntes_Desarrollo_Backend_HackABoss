# 18. Patrones de Diseño Estructurales

En esta clase se abordarán las siguientes temáticas:

- Patrones de Diseño Estructurales
    - Adapter
    - Facade
    - Decorator

<br>

## Patrones de Diseño Estructurales

Los patrones de diseño estructurales son un conjunto de patrones que se centran en la composición de clases y objetos para formar estructuras más grandes. Estos patrones están relacionados con la composición de clases y objetos para crear interfaces más grandes, sistemas más complejos y facilitar la adaptabilidad de un sistema.

Son patrones que explican cómo ensamblar objetos y clases en estructuras más grandes, permitiendo a la vez, la flexibilidad y eficiencia de estas estructuras.

Entre los más conocidos se encuentran:

- **Adapter**    
- **Bridge**
- **Composite**
- **Decorator**
- **Facade**
- **Flyweight**
- **Proxy**

<br>

### Patrón Adapter

Es un patrón de diseño estructural que permite la colaboración entre objetos con interfaces incompatibles. Crea un objeto especial llamado adaptador que convierte la interfaz de un objeto, de forma tal que otro objeto pueda comprenderla.

Proporciona una interfaz que permite que dos interfaces incompatibles trabajen juntas. Se utiliza para que clases con interfaces incompatibles puedan colaborar.

En el patrón de diseño Adapter, el adaptador permite que la interfaz de una clase sea utilizada como si fuera otra interfaz. Esto es útil cuando tienes dos interfaces incompatibles y necesitas que trabajen juntas.

<br>

#### Ejemplo

Supongamos que tienes una interfaz `Temperature` que representa la temperatura en grados Celsius:

```java
public interface Temperature {
    double getCelsius();
}
```

Ahora, imagina que necesitas trabajar con una biblioteca externa que utiliza una interfaz diferente para representar la temperatura en grados Fahrenheit:

```java
public interface FahrenheitTemperature {
    double getFahrenheit();
}
```

Pero en tu código, quieres utilizar la interfaz `Temperature` para representar la temperatura en grados Celsius. Aquí es donde entra en juego el adaptador:

```java
// Implementación de la interfaz Temperature
public class CelsiusTemperature implements Temperature {
    private double celsius;

    public CelsiusTemperature(double celsius) {
        this.celsius = celsius;
    }

    @Override
    public double getCelsius() {
        return celsius;
    }
}

// Adaptador que permite utilizar FahrenheitTemperature como si fuera Temperature
public class FahrenheitAdapter implements Temperature {
    private FahrenheitTemperature fahrenheitTemperature;

    public FahrenheitAdapter(FahrenheitTemperature fahrenheitTemperature) {
        this.fahrenheitTemperature = fahrenheitTemperature;
    }

    @Override
    public double getCelsius() {
        // Realiza la conversión de Fahrenheit a Celsius
        double fahrenheit = fahrenheitTemperature.getFahrenheit();
        return (fahrenheit - 32) * 5 / 9;
    }
}
```

En este ejemplo, `CelsiusTemperature` implementa la interfaz `Temperature` y representa la temperatura en grados Celsius. El `FahrenheitAdapter` actúa como un adaptador, permitiendo que un objeto que implementa la interfaz `FahrenheitTemperature` sea utilizado como si fuera un objeto `Temperature`. La adaptación se realiza convirtiendo la temperatura de Fahrenheit a Celsius.

Ahora, puedes usar el adaptador para trabajar con la interfaz `Temperature` incluso cuando tienes un objeto que implementa `FahrenheitTemperature`:

```java
public class Main {
    public static void main(String[] args) {
        FahrenheitTemperature fahrenheitTemperature = new SomeExternalLibraryTemperature();
        Temperature adaptedTemperature = new FahrenheitAdapter(fahrenheitTemperature);

        System.out.println("Temperature in Celsius: " + adaptedTemperature.getCelsius());
    }
}
```

Este es un ejemplo simplificado, pero ilustra cómo el adaptador permite que dos interfaces incompatibles (`Temperature` y `FahrenheitTemperature`) trabajen juntas de manera armoniosa.

<br>

### Patrón Bridge

El patrón de diseño Bridge es un patrón estructural que separa la abstracción de su implementación, permitiendo que ambas evolucionen de manera independiente. Este patrón proporciona una solución más flexible y desacoplada al problema de tener una jerarquía de clases que puede crecer de manera exponencial.

Permite dividir una clase grande, o un grupo de clases estrechamente relacionadas, en dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.

**Elementos del patrón Bridge:**

1. **Abstracción (Abstraction):** Define la interfaz abstracta y mantiene una referencia a una implementación. Puede contener métodos abstractos y concretos.
    
2. **Implementación (Implementor):** Define la interfaz para las clases de implementación concretas. Generalmente, contiene solo métodos abstractos.
    
3. **Refinamiento de Abstracción (Refined Abstraction):** Extiende la abstracción y agrega funcionalidad específica.
    
4. **Implementación Concreta (Concrete Implementor):** Proporciona implementaciones concretas de la interfaz de implementación.

<br>

#### Ejemplo

Supongamos que estamos construyendo un sistema de formas geométricas y queremos manejar diferentes tipos de implementaciones para dibujar esas formas (p. ej., dibujar en una ventana de aplicación o en una interfaz web). Aquí está un ejemplo simple utilizando el patrón Bridge:

```java
// Implementación: Interfaz para los dibujantes concretos
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Implementación Concreta A: Dibuja en una ventana de aplicación
class WindowsDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Dibujando círculo en la ventana de la aplicación en (" + x + ", " + y + ") con radio " + radius);
    }
}

// Implementación Concreta B: Dibuja en una interfaz web
class WebDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Dibujando círculo en la interfaz web en (" + x + ", " + y + ") con radio " + radius);
    }
}

// Abstracción: Forma abstracta
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw(); // Método abstracto
}

// Refinamiento de Abstracción: Círculo
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}
```

Ahora, puedes usar estas clases de la siguiente manera:

```java
public class Main {
    public static void main(String[] args) {
        // Implementación concreta A (dibujo en ventana de aplicación)
        DrawingAPI windowsAPI = new WindowsDrawingAPI();

        // Abstracción + Implementación concreta A
        Shape circleInWindows = new Circle(10, 20, 30, windowsAPI);
        circleInWindows.draw();

        // Implementación concreta B (dibujo en interfaz web)
        DrawingAPI webAPI = new WebDrawingAPI();

        // Abstracción + Implementación concreta B
        Shape circleOnWeb = new Circle(50, 60, 70, webAPI);
        circleOnWeb.draw();
    }
}
```

Este ejemplo muestra cómo el patrón Bridge separa la abstracción (`Shape`) de su implementación (`DrawingAPI`). Puedes cambiar fácilmente la implementación sin afectar las formas, y viceversa. Es una forma de manejar mejor la variabilidad y de evitar una explosión combinatoria en una jerarquía de clases.

<br>

### Patrón Composite

El patrón de diseño Composite es un patrón estructural que permite a los clientes tratar tanto a objetos individuales como a composiciones de objetos de manera uniforme. Este patrón compone objetos en estructuras de árbol para representar jerarquías de parte/todo.

Permite componer objetos en estructuras de árbol y trabajar con ellas como si fueran objetos individuales. El uso de este patrón **sólo tiene sentido** cuando el modelo central de la aplicación puede representarse en forma de árbol.

**Elementos del patrón Composite:**

1. **Componente (Component):** Declara la interfaz común para todos los objetos, tanto hojas como composites.
    
2. **Hoja (Leaf):** Representa los objetos individuales que no tienen hijos. Implementa la interfaz definida por el componente.
    
3. **Composite:** Define el comportamiento para los objetos que tienen hijos. Almacena componentes hijos y los gestiona. Implementa la interfaz definida por el componente.

<br>

#### Ejemplo

Supongamos que queremos representar una estructura de árbol para manejar empleados en una organización. Cada empleado puede ser un individuo (hoja) o un grupo de empleados (composite).

```java
// Componente: Interfaz común para todos los objetos (tanto hojas como composites)
interface Employee {
    void showDetails();
}

// Hoja: Representa un empleado individual
class IndividualEmployee implements Employee {
    private String name;

    public IndividualEmployee(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Individual Employee: " + name);
    }
}

// Composite: Representa un grupo de empleados
class GroupEmployee implements Employee {
    private String groupName;
    private List<Employee> members = new ArrayList<>();

    public GroupEmployee(String groupName) {
        this.groupName = groupName;
    }

    public void addMember(Employee member) {
        members.add(member);
    }

    @Override
    public void showDetails() {
        System.out.println("Group Employee: " + groupName);
        System.out.println("Members:");
        for (Employee member : members) {
            member.showDetails();
        }
    }
}
```

Ahora, puedes construir una jerarquía de empleados usando tanto hojas como composites:

```java
public class Main {
    public static void main(String[] args) {
        // Empleados individuales
        Employee individual1 = new IndividualEmployee("John Doe");
        Employee individual2 = new IndividualEmployee("Jane Doe");

        // Grupo de empleados
        GroupEmployee group1 = new GroupEmployee("Engineering Team");
        group1.addMember(individual1);
        group1.addMember(individual2);

        // Otro empleado individual
        Employee individual3 = new IndividualEmployee("Alice Smith");

        // Grupo que contiene a otros grupos y empleados individuales
        GroupEmployee group2 = new GroupEmployee("Company");
        group2.addMember(group1);
        group2.addMember(individual3);

        // Mostrar detalles de todos los empleados
        group2.showDetails();
    }
}
```

En este ejemplo, `Employee` es el componente que define la interfaz común. `IndividualEmployee` es una hoja que representa un empleado individual, y `GroupEmployee` es un composite que representa un grupo de empleados que puede incluir tanto individuos como subgrupos.

El patrón Composite permite tratar de manera uniforme tanto a hojas como a composites, lo que facilita la creación de estructuras jerárquicas y su manipulación. Esto es especialmente útil cuando necesitas trabajar con una estructura de árbol y quieres tratar todos los nodos de la misma manera, independientemente de si son nodos hoja o nodos compuestos.

<br>

### Patrón Decorator

El patrón de diseño Decorator es un patrón estructural que permite agregar comportamientos o responsabilidades adicionales a objetos de manera dinámica y flexible. Este patrón se logra mediante la creación de una serie de clases decoradoras que envuelven un componente original. Cada decorador agrega su propia funcionalidad y luego pasa la llamada al componente original.

Permite añadir funcionalidades a objetos colocando estos dentro de otros que cumplen la función de ser “encapsuladores especiales” que contienen estas funcionalidades especiales. Se utiliza cuando es necesario alterar la funcionalidad de un objeto.

**Elementos del patrón Decorator:**

1. **Componente (Component):** Define la interfaz común para los objetos que pueden recibir responsabilidades adicionales. Puede ser una interfaz o una clase abstracta.
    
2. **Componente Concreto (Concrete Component):** Es la implementación concreta del componente. Define un objeto al cual se pueden agregar responsabilidades adicionales.
    
3. **Decorador (Decorator):** Mantiene una referencia al componente y sigue la interfaz del componente. Puede ser una clase abstracta.
    
4. **Decorador Concreto (Concrete Decorator):** Agrega responsabilidades adicionales al componente. Puede llamarse recursivamente para pasar la llamada al siguiente decorador en la cadena.
    
<br>

#### Ejemplo

Supongamos que tienes una interfaz `Coffee` que representa un café básico y dos decoradores, `MilkDecorator` y `SugarDecorator`, que agregan leche y azúcar respectivamente.

```java
// Componente: Interfaz común para los objetos que pueden recibir responsabilidades adicionales
interface Coffee {
    String getDescription();
    double getCost();
}

// Componente Concreto: Implementación concreta del componente
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0; // Precio base
    }
}

// Decorador: Clase abstracta que mantiene una referencia al componente y sigue su interfaz
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Decorador Concreto: Agrega leche al café
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Costo adicional por leche
    }
}

// Decorador Concreto: Agrega azúcar al café
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2; // Costo adicional por azúcar
    }
}
```

Ahora, puedes usar estos decoradores para personalizar tu café:

```java
public class Main {
    public static void main(String[] args) {
        // Café simple
        Coffee coffee = new SimpleCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());

        // Café con leche
        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());

        // Café con leche y azúcar
        Coffee milkSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("\nDescription: " + milkSugarCoffee.getDescription());
        System.out.println("Cost: $" + milkSugarCoffee.getCost());
    }
}
```

En este ejemplo, `SimpleCoffee` es el componente original. `MilkDecorator` y `SugarDecorator` son decoradores concretos que agregan leche y azúcar al café, respectivamente. Puedes combinar estos decoradores de manera flexible para obtener diferentes variaciones de café con diferentes costos y descripciones.

<br>

### Patrón Facade

El patrón de diseño Facade es un patrón estructural que proporciona una interfaz simplificada y unificada a un conjunto de interfaces en un subsistema más grande. La idea principal del patrón Facade es proporcionar una interfaz única y más fácil de usar que envuelva un conjunto de interfaces más complejas dentro de un sistema.

Proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases. Se utiliza cuando es necesario integrar una aplicación con una biblioteca sofisticada con decenas de funciones, de la cual sólo se necesita usar una pequeña parte.

**Elementos del patrón Facade:**

1. **Fachada (Facade):** Proporciona una interfaz unificada y simplificada a un conjunto de interfaces más grandes en un subsistema. Este componente conoce qué clases del subsistema son responsables de una solicitud específica.
    
2. **Subsistema (Subsystem):** Está formado por un conjunto de interfaces y clases que realizan las tareas del sistema. El subsistema no conoce la existencia de la fachada y trabaja de manera independiente.

<br>

#### Ejemplos

Supongamos que tienes un sistema complejo de componentes para encender y apagar varios dispositivos electrónicos, como la televisión, el sistema de sonido y las luces. Puedes utilizar una fachada para simplificar el proceso y proporcionar una interfaz única para el control de todos los dispositivos.

```java
// Subsistema: Clase que representa la televisión
class TV {
    public void turnOn() {
        System.out.println("Encendiendo la televisión");
    }

    public void turnOff() {
        System.out.println("Apagando la televisión");
    }
}

// Subsistema: Clase que representa el sistema de sonido
class SoundSystem {
    public void turnOn() {
        System.out.println("Encendiendo el sistema de sonido");
    }

    public void turnOff() {
        System.out.println("Apagando el sistema de sonido");
    }
}

// Subsistema: Clase que representa las luces
class Lights {
    public void turnOn() {
        System.out.println("Encendiendo las luces");
    }

    public void turnOff() {
        System.out.println("Apagando las luces");
    }
}

// Fachada: Proporciona una interfaz unificada para controlar los subsistemas
class HomeTheaterFacade {
    private TV tv;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(TV tv, SoundSystem soundSystem, Lights lights) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie() {
        System.out.println("Preparando para ver una película...");
        tv.turnOn();
        soundSystem.turnOn();
        lights.turnOff();
    }

    public void endMovie() {
        System.out.println("Finalizando la película...");
        tv.turnOff();
        soundSystem.turnOff();
        lights.turnOn();
    }
}
```

Ahora, puedes utilizar la fachada `HomeTheaterFacade` para simplificar las operaciones del sistema y proporcionar una interfaz única:

```java
public class Main {
    public static void main(String[] args) {
        // Crear subsistemas
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        // Crear fachada
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, soundSystem, lights);

        // Utilizar la fachada para ver una película
        homeTheater.watchMovie();

        // Utilizar la fachada para finalizar la película
        homeTheater.endMovie();
    }
}
```

En este ejemplo, `HomeTheaterFacade` proporciona métodos `watchMovie` y `endMovie` que simplifican la secuencia de operaciones necesarias para encender y apagar diferentes dispositivos al ver una película. Los detalles internos de cómo se enciende y apaga cada dispositivo se encapsulan en el subsistema correspondiente, y el cliente solo necesita interactuar con la fachada para lograr el resultado deseado. Esto mejora la simplicidad y legibilidad del código, especialmente cuando el sistema es complejo y tiene muchas interacciones entre diferentes componentes.

<br>

### Patrón **Flyweight**

El patrón de diseño Flyweight es un patrón estructural que se utiliza para minimizar el uso de memoria o recursos en situaciones en las que se manejan grandes cantidades de objetos idénticos o similares. Este patrón logra esto compartiendo eficientemente instancias comunes entre múltiples objetos, en lugar de tener una instancia separada para cada objeto.

Permite mantener más objetos dentro de la cantidad disponible de RAM, compartiendo las partes comunes del estado entre varios de ellos en lugar de mantener toda la información en cada uno por separado. Es utilizado cuando se tienen escasos recursos en los dispositivos que ejecutarán la aplicación o para optimizar recursos.

**Elementos del patrón Flyweight:**

1. **Flyweight (Peso Ligero):** Define una interfaz mediante la cual las instancias flyweight pueden recibir y actuar sobre información extrínseca. Las instancias flyweight deben ser compartidas y, por lo general, son inmutables.
    
2. **ConcreteFlyweight (Peso Ligero Concreto):** Implementa la interfaz Flyweight y almacena el estado intrínseco (compartido) de la instancia flyweight.
    
3. **FlyweightFactory (Factoría de Peso Ligero):** Gestiona y crea instancias flyweight. A menudo, mantiene un pool de instancias flyweight para que pueda reutilizarlas.
    
4. **Cliente:** Utiliza instancias flyweight y, opcionalmente, proporciona información extrínseca a las instancias flyweight.
    
<br>

#### Ejemplo

Supongamos que estamos creando un editor de texto y queremos manejar las letras del alfabeto como objetos flyweight. En lugar de crear una instancia separada para cada letra, compartiremos instancias flyweight para reducir el uso de memoria.

```java
// Flyweight: Interfaz que define el comportamiento de las letras
interface Letter {
    void display(String font);
}

// ConcreteFlyweight: Implementación concreta de una letra
class ConcreteLetter implements Letter {
    private char character;

    public ConcreteLetter(char character) {
        this.character = character;
    }

    @Override
    public void display(String font) {
        System.out.println("Character: " + character + ", Font: " + font);
    }
}

// FlyweightFactory: Gestiona y crea instancias flyweight
class LetterFactory {
    private static final Map<Character, Letter> letterPool = new HashMap<>();

    public static Letter getLetter(char character) {
        // Si la letra ya existe en el pool, la devuelve; de lo contrario, la crea y la agrega al pool
        return letterPool.computeIfAbsent(character, ConcreteLetter::new);
    }
}
```

Y si ejecutamos mediante un main:

```java
// Cliente: Utiliza instancias flyweight
public class TextEditor {
    public static void main(String[] args) {
        Letter letterA = LetterFactory.getLetter('A');
        Letter letterB = LetterFactory.getLetter('B');
        Letter letterA2 = LetterFactory.getLetter('A'); // La misma instancia de 'A' se reutiliza

        letterA.display("Arial");
        letterB.display("Times New Roman");
        letterA2.display("Verdana");
    }
}
```

En este ejemplo, `Letter` es la interfaz flyweight que define el comportamiento común de las letras. `ConcreteLetter` es la implementación concreta de una letra. `LetterFactory` es la factoría que gestiona las instancias flyweight y las reutiliza cuando sea posible.

Al ejecutar el código, se puede observar que la misma instancia flyweight de la letra 'A' se reutiliza para diferentes solicitudes, lo que demuestra la eficiencia en el uso de recursos que proporciona el patrón Flyweight.

<br>

### Patrón **Proxy**

El patrón de diseño Proxy es un patrón estructural que proporciona un sustituto o marcador de posición para otro objeto para controlar el acceso a él. Este patrón se utiliza para agregar una capa de control adicional, como verificación de permisos, registro, o carga diferida, sin cambiar la interfaz del objeto original.

El patrón proxy permite controlar el acceso a un objeto original, permitiendo hacer algo antes o después de que la solicitud llegue a éste objeto original.

>💡**Una analogía de la vida real:** _Una tarjeta de crédito/débito es un proxy de una cuenta bancaria, que, a su vez, es un proxy de un manojo de billetes. Ambos implementan la misma interfaz, por lo que pueden utilizarse para realizar un pago. El consumidor se siente genial porque no necesita llevar un montón de efectivo encima. El dueño de la tienda también está contento porque los ingresos de la transacción se añaden electrónicamente a la cuenta bancaria de la tienda sin el riesgo de perder el depósito o sufrir un robo de camino al banco._

**Elementos del patrón Proxy:**

1. **Sujeto (Subject):** Define la interfaz común para el RealSubject y el Proxy para que ambos sean intercambiables.
    
2. **RealSubject (Sujeto Real):** La clase que realiza la funcionalidad real. El Proxy actúa como un sustituto de esta clase.
    
3. **Proxy:** Mantiene una referencia al RealSubject y controla el acceso a él. Implementa la misma interfaz que el RealSubject para que sea intercambiable con él.
    
<br>

#### Ejemplo

Supongamos que tenemos una interfaz `Image` y una clase `RealImage` que carga y muestra imágenes desde el disco. Queremos agregar un proxy para controlar el acceso a las imágenes y cargarlas solo cuando sea necesario.

```java
// Sujeto: Interfaz común para RealSubject y Proxy
interface Image {
    void display();
}

// RealSubject: Clase que realiza la funcionalidad real (carga y muestra imágenes)
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy: Controla el acceso a RealSubject y realiza funciones adicionales (carga diferida)
class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Se crea el RealImage solo cuando se llama al método display
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
```

Ahora, puedes usar el proxy para controlar el acceso a las imágenes:

```java
public class Main {
    public static void main(String[] args) {
        // Usar el proxy para mostrar imágenes
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.jpg");

        // La carga real ocurre solo cuando se llama al método display
        image1.display(); // Se carga la imagen desde el disco
        image1.display(); // La imagen ya está cargada, se muestra directamente
        image2.display(); // Se carga la segunda imagen desde el disco
    }
}
```

En este ejemplo, `RealImage` realiza la funcionalidad real de cargar y mostrar imágenes, mientras que `ImageProxy` controla el acceso a `RealImage`. La carga real de la imagen solo ocurre cuando se llama al método `display` del proxy, proporcionando así carga diferida (lazy loading). Esto puede ser útil si la carga de imágenes es costosa y solo se desea realizar cuando es realmente necesario. Además, el proxy podría agregar funcionalidades adicionales, como verificación de permisos, registro, etc. sin afectar directamente a la clase `RealImage`.

---
[⬅️ Volver al índice](./README.md)