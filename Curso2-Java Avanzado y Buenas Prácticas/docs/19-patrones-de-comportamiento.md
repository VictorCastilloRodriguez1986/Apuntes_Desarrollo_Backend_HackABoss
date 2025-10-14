# 19. Patrones de Diseño de Comportamiento

En esta clase se abordarán las siguientes temáticas:

- Patrones de Diseño de Comportamiento
    - Command
    - Iterator
    - Mediator
    - Observer 

<br>

## Patrones de Diseño de Comportamiento

Los patrones de diseño de comportamiento se centran en cómo las clases y objetos interactúan y comunican entre sí. Estos patrones definen algoritmos y patrones de comunicación entre objetos para resolver problemas específicos en el diseño de software.

Tratan con **algoritmos prearmados** y la **asignación de responsabilidades** que puede existir entre objetos. Encapsulan procesos que deben ejecutarse dentro de una funcionalidad de la aplicación, como por ejemplo interpretar un lenguaje, completar una petición, moverse a través de una secuencia o implementar un algoritmo.

Entre los más conocidos se encuentran:
- **Chain of Responsibility**
- **Command**
- **Iterator**
- **Mediator**
- **Observer**
- **entre otros…**

¡Veamos algunos de ellos!

<br>

### Patrón Chain of Responsability

El patrón de diseño Chain of Responsibility, también conocido como "Cadena de Responsabilidad" en español, es un patrón de comportamiento que permite que varios objetos manejen una solicitud sin que el cliente que la realiza conozca qué objeto específico la manejará. La solicitud viaja a lo largo de una cadena de objetos, y cada objeto decide si manejar la solicitud o pasarla al siguiente objeto en la cadena.

Permite pasar solicitudes a lo largo de una cadena de manejadores. Al recibir una solicitud, cada manejador decide si la procesa o si la pasa al siguiente manejador de la cadena.

**Elementos del patrón Chain of Responsibility:**

1. **Handler (Manejador):** Define una interfaz para manejar solicitudes y opcionalmente implementa un enlace al siguiente manejador en la cadena.
    
2. **ConcreteHandler (Manejador Concreto):** Implementa la interfaz del manejador y decide si puede manejar la solicitud. Si puede, la maneja; de lo contrario, pasa la solicitud al siguiente manejador en la cadena.
    
3. **Client (Cliente):** Inicia la solicitud y la envía al primer manejador en la cadena.
    
<br>

#### Ejemplo

Supongamos que tenemos un sistema de aprobación de solicitudes y queremos implementar un enfoque en cadena para que diferentes autoridades puedan aprobar solicitudes de diferentes montos.

```java
// Handler: Interfaz para manejar solicitudes
interface Approver {
    void processRequest(Request request);
}

// ConcreteHandler: Implementa la interfaz y decide si puede manejar la solicitud o pasa al siguiente
class Manager implements Approver {
    private Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processRequest(Request request) {
        if (request.getAmount() <= 1000) {
            System.out.println("Manager approves request with amount: " + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("No one can handle the request.");
        }
    }
}

// Otro ConcreteHandler
class Director implements Approver {
    private Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processRequest(Request request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Director approves request with amount: " + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("No one can handle the request.");
        }
    }
}

// Clase que representa la solicitud
class Request {
    private double amount;

    public Request(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
```

Si ejecutamos desde un método Main sería algo como esto:

```java
// Cliente: Inicia la solicitud y la envía al primer manejador en la cadena
public class ApprovalChainClient {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();

        // Configuración de la cadena de aprobación
        manager.setNextApprover(director);

        // Cliente inicia la solicitud
        Request request1 = new Request(800);
        manager.processRequest(request1);

        Request request2 = new Request(3500);
        manager.processRequest(request2);

        Request request3 = new Request(10000);
        manager.processRequest(request3);
    }
}
```

En este ejemplo, `Approver` es la interfaz que define el método `processRequest` para manejar solicitudes. `Manager` y `Director` son manejadores concretos que implementan esta interfaz y toman decisiones sobre si pueden manejar una solicitud o la pasan al siguiente en la cadena.

La cadena se configura en el cliente (`ApprovalChainClient`), que inicia la solicitud y la envía al primer manejador en la cadena. Si ese manejador no puede manejar la solicitud, la pasa al siguiente en la cadena. Este proceso continúa hasta que la solicitud es manejada o no hay más manejadores en la cadena.

<br>

### Patrón Command

El patrón de diseño Command es un patrón de comportamiento que encapsula una solicitud como un objeto, permitiendo parametrizar a los clientes con distintas solicitudes, encolar operaciones y permitir deshacer operaciones. De esta manera, separa al objeto que realiza la solicitud (el cliente) del objeto que sabe cómo llevar a cabo esa solicitud (el receptor).

Permite convertir una solicitud en un objeto independiente que contiene toda la información sobre la misma. Esta transformación permite parametrizar los métodos con diferentes solicitudes, retrasar o poner en cola la ejecución a una solicitud y soportar operaciones que no se pueden realizar.

**Elementos del patrón Command:**

1. **Command (Comando):** Define una interfaz para ejecutar una operación.
    
2. **ConcreteCommand (Comando Concreto):** Implementa la interfaz Command y almacena la información necesaria para ejecutar la operación. Mantiene una referencia al objeto Receptor.
    
3. **Receiver (Receptor):** Sabe cómo llevar a cabo la operación asociada con el comando.
    
4. **Invoker (Invocador):** Solicita que se lleve a cabo una operación y mantiene una referencia al comando asociado.
    
5. **Client (Cliente):** Crea comandos concretos y los asocia con sus receptores.
    
<br>

#### Ejemplo

Supongamos que queremos implementar un control remoto que pueda manejar diferentes dispositivos electrónicos, como luces y ventiladores.

```java
// Command: Interfaz para ejecutar una operación
interface Command {
    void execute();
}

// ConcreteCommand: Implementa la interfaz Command y almacena la información necesaria
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Receiver: Sabe cómo llevar a cabo la operación
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker: Solicita que se lleve a cabo una operación
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

Al ejecutar con main sería algo como:

```java
// Cliente: Crea comandos concretos y los asocia con sus receptores
public class CommandPatternExample {
    public static void main(String[] args) {
        // Cliente crea un receptor (Light)
        Light light = new Light();

        // Cliente crea comandos concretos asociados con el receptor
        Command lightOnCommand = new LightOnCommand(light);

        // Cliente crea un invocador (RemoteControl) y asocia un comando con él
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);

        // Cliente usa el invocador para solicitar que se lleve a cabo la operación
        remoteControl.pressButton();
    }
}
```

En este ejemplo, `Command` es la interfaz que define el método `execute`. `LightOnCommand` es una implementación concreta de `Command` que conoce cómo encender una luz (`Light`). `RemoteControl` es el invocador que solicita la ejecución de la operación, y `Light` es el receptor que sabe cómo realizar la operación específica.

El patrón Command permite la flexibilidad de configurar y parametrizar objetos invocadores con diferentes comandos, además de permitir encolar y deshacer operaciones fácilmente. Este patrón es especialmente útil cuando se desea desacoplar al objeto que solicita una operación del objeto que la lleva a cabo

<br>

### Patrón Iterator

El patrón de diseño Iterator es un patrón de comportamiento que proporciona una manera de acceder secuencialmente a los elementos de un objeto agregado (como una lista) sin exponer los detalles internos de su estructura. Este patrón permite recorrer una colección de objetos de manera uniforme sin conocer la implementación subyacente de la colección.

Permite recorrer elementos de una colección sin exponer su representación subyacente (lista, pila, árbol, etc.). La idea central del patrón Iterator es extraer el comportamiento de recorrido de una colección y colocarlo en un objeto independiente llamado iterador.

**Elementos del patrón Iterator:**

1. **Iterador (Iterator):** Define una interfaz para acceder y recorrer elementos de una colección.
    
2. **ConcreteIterator (Iterador Concreto):** Implementa la interfaz del Iterador y mantiene la posición actual en la colección.
    
3. **Agregado (Agregado):** Define una interfaz para crear un iterador.
    
4. **ConcreteAgregado (Agregado Concreto):** Implementa la interfaz del Agregado y devuelve una instancia de su iterador concreto.
    
<br>

#### Ejemplo

Supongamos que queremos implementar un iterador para recorrer una lista de empleados en una empresa.

```java
// Iterador: Interfaz para acceder y recorrer elementos de una colección
interface Iterator {
    boolean hasNext();
    Object next();
}

// ConcreteIterator: Implementa la interfaz del Iterador y mantiene la posición actual en la colección
class EmployeeIterator implements Iterator {
    private EmployeeList employeeList;
    private int position;

    public EmployeeIterator(EmployeeList employeeList) {
        this.employeeList = employeeList;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < employeeList.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return employeeList.getEmployee(position++);
        } else {
            return null;
        }
    }
}

// Agregado: Define una interfaz para crear un iterador
interface Aggregate {
    Iterator createIterator();
}

// ConcreteAgregado: Implementa la interfaz del Agregado y devuelve una instancia de su iterador concreto
class EmployeeList implements Aggregate {
    private Employee[] employees;
    private int size;

    public EmployeeList(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        }
    }

    public Employee getEmployee(int index) {
        if (index < size) {
            return employees[index];
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator createIterator() {
        return new EmployeeIterator(this);
    }
}

// Clase que representa a un empleado
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Si ejecutamos un main:

```java
// Cliente: Utiliza el iterador para recorrer la lista de empleados
public class IteratorPatternExample {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList(5);
        employeeList.addEmployee(new Employee("John"));
        employeeList.addEmployee(new Employee("Jane"));
        employeeList.addEmployee(new Employee("Bob"));

        Iterator iterator = employeeList.createIterator();

        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            System.out.println("Employee: " + employee.getName());
        }
    }
}
```

En este ejemplo, `Iterator` es la interfaz que define los métodos `hasNext` y `next` para acceder y recorrer elementos de la colección. `ConcreteIterator` es una implementación concreta de `Iterator` que mantiene la posición actual en la colección. `Aggregate` es la interfaz que define el método `createIterator` para crear un iterador. `ConcreteAggregate` es una implementación concreta de `Aggregate` que devuelve una instancia de su iterador concreto (`ConcreteIterator`). La colección (`EmployeeList`) implementa la interfaz `Aggregate` y utiliza su iterador para permitir el acceso secuencial a los elementos de la lista.

El patrón Iterator facilita la implementación de iteradores para diferentes tipos de colecciones y permite recorrer colecciones de manera uniforme sin preocuparse por la estructura interna de la colección.

<br>

### Patrón Mediator

El patrón de diseño Mediator es un patrón de comportamiento que define un objeto mediador que coordina la comunicación entre objetos que interactúan, evitando así que esos objetos se comuniquen directamente entre sí. En lugar de que los objetos se comuniquen directamente, se comunican a través del objeto mediador. Esto reduce las dependencias entre los objetos y promueve un acoplamiento más débil.

Permite reducir las dependencias caóticas entre objetos. El patrón restringe las comunicaciones directas entre los objetos, forzándolos a colaborar únicamente a través de un objeto mediador.

**Elementos del patrón Mediator:**

1. **Mediator (Mediador):** Define una interfaz para la comunicación entre objetos colegas.
    
2. **ConcreteMediator (Mediador Concreto):** Implementa la interfaz del mediador y coordina la comunicación entre los objetos colegas.
    
3. **Colleague (Colega):** Define una interfaz para la comunicación con otros colegas a través del mediador.
    
4. **ConcreteColleague (Colega Concreto):** Implementa la interfaz de Colleague y se comunica con otros colegas a través del mediador.
    
<br>

#### Ejemplo

Supongamos que queremos implementar un sistema de chat donde los usuarios pueden enviar mensajes entre ellos. Vamos a usar el patrón Mediator para facilitar la comunicación entre los usuarios.

```java
// Mediator: Interfaz para la comunicación entre objetos colegas
interface ChatMediator {
    void sendMessage(String message, User user);
}

// ConcreteMediator: Implementa la interfaz del mediador y coordina la comunicación entre los objetos colegas
class ChatMediatorImpl implements ChatMediator {
    @Override
    public void sendMessage(String message, User user) {
        System.out.println(user.getName() + " envía el mensaje: " + message);
    }
}

// Colleague: Define una interfaz para la comunicación con otros colegas a través del mediador
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);

    public String getName() {
        return name;
    }
}

// ConcreteColleague: Implementa la interfaz de Colleague y se comunica con otros colegas a través del mediador
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " recibe el mensaje: " + message);
    }
}
```

Desde un main ejecutaríamos de esta manera:

```java
// Cliente: Utiliza el mediador para facilitar la comunicación entre los colegas
public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User user1 = new ChatUser(chatMediator, "User1");
        User user2 = new ChatUser(chatMediator, "User2");
        User user3 = new ChatUser(chatMediator, "User3");

        chatMediator.sendMessage("¡Hola a todos!", user1);

        user2.sendMessage("Hola, User1. ¿Cómo estás?");
        user3.sendMessage("¡Hola a todos! Estoy bien, gracias.");

        user1.receiveMessage("Hola, User2. Estoy bien, gracias también.");
    }
}
```

En este ejemplo, `ChatMediator` es la interfaz que define el método `sendMessage` para la comunicación entre objetos colegas. `ChatMediatorImpl` es una implementación concreta del mediador que coordina la comunicación entre los usuarios (`ChatUser`).

Cada `ChatUser` es un colega que se comunica a través del mediador. Cuando un usuario envía un mensaje, el mediador se encarga de transmitir ese mensaje a los demás usuarios. Esto reduce las dependencias entre los usuarios y facilita la extensión del sistema para agregar nuevos usuarios o funcionalidades de comunicación. El mediador actúa como un punto central de coordinación para la comunicación entre objetos.

<br>

### Patrón Observer

El patrón de diseño Observer, también conocido como patrón de observador o patrón de eventos, es un patrón de comportamiento que define una relación de uno a muchos entre objetos, de manera que cuando un objeto cambia de estado, todos sus dependientes son notificados y actualizados automáticamente. Este patrón se utiliza para implementar la propagación de cambios y la suscripción a eventos.

Permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando.

>💡**Una analogía de la vida real:** _Si te subscribís a un diario o una revista, ya no necesitás ir al kiosco a comprobar si el siguiente número está disponible. En lugar de eso, el notificador envía nuevos números directamente a tu buzón justo después de la publicación, o incluso antes._

**Elementos del patrón Observer:**

1. **Sujeto (Subject):** Define una interfaz para agregar, eliminar y notificar observadores.
    
2. **Observador (Observer):** Define una interfaz de actualización que los observadores deben implementar para recibir notificaciones del sujeto.
    
3. **Observador Concreto (Concrete Observer):** Implementa la interfaz de observador para recibir notificaciones y realizar acciones específicas en respuesta a cambios en el sujeto.
    
4. **Sujeto Concreto (Concrete Subject):** Implementa la interfaz de sujeto y mantiene una lista de observadores. Notifica a los observadores sobre cambios en su estado.
    
<br>

#### Ejemplo

Supongamos que tenemos un sistema donde un objeto `WeatherStation` recopila datos meteorológicos, y varios objetos `Display` desean mostrar estos datos en tiempo real.

```java
// Sujeto: Define una interfaz para agregar, eliminar y notificar observadores
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Observador: Define una interfaz de actualización
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

// Sujeto Concreto: Implementa la interfaz de sujeto y mantiene una lista de observadores
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Observador Concreto: Implementa la interfaz de observador para recibir notificaciones y realizar acciones específicas
class Display implements Observer {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + " - Temperature: " + temperature +
                " Humidity: " + humidity + " Pressure: " + pressure);
    }
}
```

Desde el main ejecutaríamos algo similar a esto para realizar una prueba:

```java
// Cliente: Utiliza el patrón Observer
public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Se crean dos displays como observadores
        Observer display1 = new Display("Display1");
        Observer display2 = new Display("Display2");

        // Se añaden los observadores al sujeto (WeatherStation)
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        // Se actualizan los datos meteorológicos, lo que notificará a los observadores
        weatherStation.setWeatherData(25.0f, 60.0f, 1012.0f);
    }
}
```

En este ejemplo, `WeatherStation` es el sujeto concreto que recopila datos meteorológicos y notifica a los observadores (displays) cuando hay cambios. Los displays son observadores concretos que implementan la interfaz `Observer` y actualizan su información cuando reciben notificaciones del sujeto. Este patrón permite agregar fácilmente nuevos observadores o extender el sistema sin modificar el sujeto, cumpliendo con el principio de diseño abierto/cerrado.

<br>

## 📝 Ejercicios prácticos

A continuación te encontrarás con 3 escenarios distintos de la vida real donde es posible aplicar patrones de diseño tanto estructurales como de comportamiento.

Determina qué patrón de diseño se podría adaptar para cada escenario, justifica el por qué de tu elección y, en caso de que te animes, propon una posible implementación a nivel UML (gráfico) o código.

<br>

### Escenario N 1: **Sistema de control de versiones**

_Estás diseñando un sistema de control de versiones para un equipo de desarrollo de software. El sistema debe gestionar la colaboración en el código fuente, rastrear cambios, y permitir la fusión de ramas. Además, debe notificar a los desarrolladores cuando hay conflictos y facilitar la revisión de código._

¿Qué patrón/es de diseño elegirías? ¿Por qué?

#### Resolución

- **Patrón/es de Diseño Sugerido/s:** Observer y Command
    
- **Justificación:** El patrón Observer podría ser utilizado para notificar a los desarrolladores sobre cambios en el código fuente. Cada desarrollador interesado sería un observador que recibe notificaciones cuando hay cambios relevantes. El patrón Command podría ser útil para manejar las operaciones relacionadas con el control de versiones, permitiendo que diferentes comandos (como `CommitCommand`, `MergeCommand`, etc.) se ejecuten de manera uniforme.

<br>

### Escenario Nº 2: **Sistema de construcción de casas**

_Estás trabajando en un sistema para una empresa constructora que construye casas personalizadas. Cada cliente puede elegir entre diferentes diseños, materiales de construcción y opciones de personalización. El sistema debe ser capaz de manejar la construcción de múltiples casas simultáneamente, con diferentes equipos de construcción trabajando en diferentes proyectos._

¿Qué patrón/es de diseño elegirías? ¿Por qué?

#### Resolución

- **Patrón/es de Diseño Sugerido/s:** Builder y Observer
    
- **Justificación:** El patrón Builder sería adecuado para este escenario. Podrías tener una clase `ConstructorDeCasas` que actúa como el director del proceso de construcción y diferentes constructores (`ConstructorEconomico`, `ConstructorDeLujo`, etc.) que implementan una interfaz común (`ConstructorDeCasa`). Cada constructor se encargaría de construir una casa con características específicas. El patrón Observer podría ser utilizado para notificar a los clientes sobre el progreso de la construcción de sus casas.
    
<br>

### Escenario Nº 3: **Sistema de gestión de tareas en un Proyecto de desarrollo de software**

_Estás diseñando un sistema de gestión de tareas para un equipo de desarrollo de software. Cada tarea puede tener diferentes estados (por ejemplo, pendiente, en progreso, completada) y asignaciones a miembros del equipo. Además, algunas tareas pueden depender de otras, y el sistema debe permitir la asignación de prioridades._

¿Qué patrón/es de diseño elegirías? ¿Por qué?

#### Resolución

- **Patrón/es de Diseño Sugerido/s:** Observer y Chain of Responsibility
    
- **Justificación:** El patrón Observer podría ser utilizado para notificar a los miembros del equipo sobre cambios en el estado de las tareas. Cada miembro del equipo interesado sería un observador que recibe notificaciones. El patrón Chain of Responsibility podría ser aplicado para manejar la cadena de responsabilidad de las tareas. Cada tarea podría ser un nodo en la cadena, y al cambiar su estado, la notificación podría propagarse a través de la cadena de tareas dependientes. Esto facilitaría la gestión de dependencias entre tareas y la actualización del equipo sobre el progreso del proyecto.

---
[⬅️ Volver al índice](./README.md)