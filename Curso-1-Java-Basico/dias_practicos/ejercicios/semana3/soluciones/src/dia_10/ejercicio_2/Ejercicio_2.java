package dia_10.ejercicio_2;

/* Crea un programa que muestre un menú con cuatro opciones y un caso por defecto de salida. El usuario debe ingresar un número entre 1 y 4; 0 para finalizar la app.

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
``` */

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer opcion = 0;


		do {
			imprimirMenu();

			try {
				opcion = input.nextInt();
			} catch (Exception e){
				System.err.println("Operación no valida, no insertaste un número");
				input.next();
				continue;
			}

			switch (opcion) {
				case 0:
					System.out.println("Adiós");
					break;
				case 1:
					imprimirBienvenida();
					break;
				case 2:
					imprimirFechaActual();
					break;
				case 3:
					numeroAleatorio();
					break;
				case 4:
					imprimirTablaMultiplicar5();
					break;
				default:
					System.out.println("Operación no valida");
			}
		}while (opcion != 0);

		input.close();

	}

	private static void imprimirBienvenida() {
		System.out.println("¡Bienvenido a mi super programa en JAVA!");
	}

	private static void imprimirFechaActual() {
		System.out.println("Hoy es " + LocalDate.now());
	}

	private static void numeroAleatorio() {
		Random numeroRandom = new Random();
		System.out.println("Número aleatorio (1-100): " + (numeroRandom.nextInt(100)+1));
	}

	private static void imprimirTablaMultiplicar5() {
		for (int i = 1; i <= 10 ; i++) {
			System.out.println("5 x " + i + " = " + 5*i);
		}
	}

	public static void imprimirMenu() {
		System.out.println();
		System.out.println("Ingrese una opción:");
		System.out.println("1 - Bienvenida");
		System.out.println("2 - Fecha actual");
		System.out.println("3 - Número aleatorio");
		System.out.println("4 - Tabla del 5");
		System.out.println("0 - Salir");
	}
}
