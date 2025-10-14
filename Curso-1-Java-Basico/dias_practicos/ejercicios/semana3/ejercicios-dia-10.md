# Ejercicios de Java - Nivel Medio

A continuación, encontrarás dos ejercicios que te ayudarán a practicar conceptos intermedios en Java. Cada ejercicio utilizará estructuras distintas para resolver problemas más avanzados en programación.

## Ejercicio 1: Creación de Clases Utilitarias con Métodos Estáticos

Crea una clase utilitaria llamada `FechaUtil` que contenga métodos estáticos para calcular la diferencia en días entre dos fechas de ida y vuelta.

### Requisitos:

- La clase `FechaUtil` debe contener un método estático `calcularDiferenciaDias` que reciba dos fechas (`LocalDate`) y retorne la diferencia en días.
- En el `main`, se deben probar las fechas de ida y vuelta llamando al método de `FechaUtil` e imprimiendo el resultado.
- Tip: usa la clase Period.between(fecha1, fecha2); dentro del método `calcularDiferenciaDias` para ayudarte con la solución.

**Ejemplo de uso:**

```java
LocalDate ida = LocalDate.of(2024, 3, 10);
LocalDate vuelta = LocalDate.of(2024, 3, 20);
long dias = FechaUtil.calcularDiferenciaDias(ida, vuelta);
System.out.println("Días de diferencia: " + dias);
```

**Salida esperada:**

```bash
Días de diferencia: 10
```

<br>

## Ejercicio 2: Creación de un Menú con `switch`

Crea un programa que muestre un menú con cuatro opciones y un caso por defecto de salida. El usuario debe ingresar un número entre 1 y 4; 0 para finalizar la app.

### Requisitos:

- Utilizar un `switch` para manejar las opciones del menú.
- Las opciones pueden ser:
  1. Mostrar un mensaje de bienvenida.
  2. Mostrar la fecha actual.
  3. Mostrar un número aleatorio entre 1 y 100.
  4. Mostrar la tabla de multiplicar del 5.
- Si el usuario ingresa 0, debe salir del programa con un mensaje de despedida.
- Manejar entradas no válidas.

**Ejemplo de uso:**

```java
Ingrese una opción:
1 - Bienvenida
2 - Fecha actual
3 - Número aleatorio
4 - Tabla del 5
0 - Salir
```

**Posibles salidas:**

```bash
Bienvenido al sistema!
La fecha actual es: 2024-03-10
Número aleatorio: 42
5 x 1 = 5 ... 5 x 10 = 50
Saliendo del programa... Adiós!
```
