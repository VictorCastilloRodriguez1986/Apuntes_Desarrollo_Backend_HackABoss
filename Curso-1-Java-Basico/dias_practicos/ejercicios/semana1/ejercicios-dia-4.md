# Ejercicios - Día 4

## Ejercicio Nº 1 - Estructuras Condicionales

Un concierto permite únicamente el ingreso de mayores de 18 años.

- Crea un programa que, a partir de la edad ingresada por el usuario, determine mediante un mensaje en pantalla si puede o no ingresar al evento.
- El programa debe mostrar, según cada caso, un mensaje informando la situación.

---

## Ejercicio Nº 2 - Estructuras Repetitivas

Imagina que eres cajero en un supermercado.

- Crea un programa en Java que permita ingresar el precio de varios productos comprados por un cliente.
- Utiliza una estructura repetitiva (la que prefieras) para seguir solicitando precios hasta que el usuario decida finalizar. Luego, muestra el total de la compra que debe abonar.

**Pista:**
_Recuerda que existen dos tipos de bucles:_

- _Los controlados por un **contador** (cuando sabes cuántos productos se van a ingresar)_
- _Los controlados por un **centinela** (cuando no sabes cuántos productos serán)._
  En este caso debes aplicar un “**centinela**”.  
   Por ejemplo, podrías finalizar el ingreso cuando se introduce un número negativo o 0 como monto del producto.

---

## Ejercicio Nº 3 - Arreglos: Vectores

Una web de meteorología necesita un programa que, al ingresar las 7 temperaturas máximas de la última semana, calcule la temperatura **promedio máxima** registrada.

- Para ello, deberás manejar un **vector** donde en cada posición se almacene la temperatura máxima correspondiente a cada día.
- Una vez almacenadas las temperaturas, deberás calcular el promedio recorriendo el vector y mostrando el resultado por pantalla.

---

## Ejercicio Nº 4 - Matrices

Imagina que estás trabajando en un sistema de reservas de asientos para un teatro.

Crea un programa en Java que represente un **mapa de asientos** en una matriz de 5x5, y ten en cuenta lo siguiente:

- Los asientos pueden estar ocupados (representados por `"X"`) o vacíos (representados por `"O"`).
- Permite al usuario ingresar por teclado dónde desea sentarse, indicando la fila y el número de asiento (por ejemplo: "Fila 3, Asiento 2").  
  El programa debe marcar como ocupado ese asiento **solo si está vacío**.

- Si el asiento elegido ya está ocupado, el sistema debe informar al usuario que elija otro diferente.
- A medida que se ocupen los asientos, el programa debe actualizar el mapa de asientos y mostrarlo por pantalla después de cada reserva.
- El sistema deberá seguir funcionando hasta que el encargado de realizar las reservas decida finalizar.

**Pista:**
En cada vueltas del bucle, puedes preguntar al encargado si ha sido la última reserva.
