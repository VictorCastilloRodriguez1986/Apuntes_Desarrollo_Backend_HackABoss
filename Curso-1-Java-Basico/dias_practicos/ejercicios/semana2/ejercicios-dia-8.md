# Ejercicios de Java - Nivel Medio

A continuación, encontrarás cuatro ejercicios que te ayudarán a practicar conceptos intermedios en Java. Cada uno utiliza una estructura diferente para resolver problemas más avanzados en programación.
	

## Ejercicio 1: Creación de una Interfaz e Implementación

Crea una interfaz llamada `Vehiculo` con los métodos `acelerar()` y `frenar()`. 

Luego, crea una clase `Auto` que implemente esta interfaz.

### Requisitos:

- La interfaz `Vehiculo` debe definir los métodos `acelerar()` y `frenar()`.

- La clase `Auto` debe implementar estos métodos e imprimir un mensaje cuando se llamen.

- En el método `main`, crea un objeto de tipo `Auto` y llama a los métodos implementados.


**Ejemplo de uso:**

```java
Auto miAuto = new Auto();
miAuto.acelerar();
miAuto.frenar();
```

<br>

## Ejercicio 2: Creación de una Enumeración

Crea una enumeración `TipoPago` con los valores `EFECTIVO`, `TARJETA_CREDITO` y `TARJETA_DEBITO`. 

Luego, crea una clase `Pago` que tenga un atributo de tipo `TipoPago` y un método que imprima el tipo de pago seleccionado.
	

### Requisitos:

- La enumeración `TipoPago` debe contener al menos tres valores.

- La clase `Pago` debe tener un atributo de tipo `TipoPago`.

- Debe existir un método en la clase `Pago` que imprima el tipo de pago seleccionado.
	

**Ejemplo de uso:**

```java
Pago pago = new Pago(TipoPago.EFECTIVO);
pago.mostrarTipoPago();
```

**Salida esperada:**

```bash
El tipo de pago seleccionado es: EFECTIVO
```

<br>

## Ejercicio 3: Uso de una Clase Abstracta

Crea una clase abstracta `Animal` con un método abstracto `hacerSonido()`. 

Luego, crea una clase `Perro` que extienda de `Animal` e implemente dicho método.

### Requisitos:

- La clase `Animal` debe ser abstracta y contener el método `hacerSonido()`.

- La clase `Perro` debe heredar de `Animal` e implementar el método `hacerSonido()`.

- En el método `main`, crea un objeto de `Perro` y llama al método `hacerSonido()`.
	

**Ejemplo de uso:**

```java
Perro miPerro = new Perro();
miPerro.hacerSonido();
```
	

**Salida esperada:**

```
El perro ladra: Guau Guau!
```

<br>

## Ejercicio 4: Creación de una Clase dentro de otra Clase

Crea una clase `Persona` que tenga una clase interna `Direccion`. 

La clase `Direccion` debe tener atributos como `calle` y `ciudad`. Luego, en `Persona`, crea un método que imprima la dirección completa.

### Requisitos:

- La clase `Persona` debe contener una clase interna `Direccion`.

- La clase `Direccion` debe tener atributos como `calle` y `ciudad`.

- La clase `Persona` debe tener un método que cree una instancia de `Direccion` e imprima la dirección completa.
	

**Ejemplo de uso:**

```java
Persona persona = new Persona("Juan", "Calle 123", "Buenos Aires");
persona.mostrarDireccion();
```
	

**Salida esperada:**

```
Juan vive en Calle 123, Buenos Aires.
```

