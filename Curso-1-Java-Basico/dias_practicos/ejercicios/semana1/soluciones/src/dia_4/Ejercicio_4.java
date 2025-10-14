package dia_4;

/*
Ejercicio Nº 4 - Matrices

Imagina que estás trabajando en un sistema de reservas de asientos para un teatro.

Crea un programa en Java que represente un mapa de asientos en una matriz de 5x5, y ten en cuenta lo siguiente:

- Los asientos pueden estar ocupados (representados por "X") o vacíos (representados por "O").
- Permite al usuario ingresar por teclado dónde desea sentarse, indicando la fila y el número de asiento (por ejemplo: "Fila 3, Asiento 2").
  El programa debe marcar como ocupado ese asiento solo si está vacío.

- Si el asiento elegido ya está ocupado, el sistema debe informar al usuario que elija otro diferente.
- A medida que se ocupen los asientos, el programa debe actualizar el mapa de asientos y mostrarlo por pantalla después de cada reserva.
- El sistema deberá seguir funcionando hasta que el encargado de realizar las reservas decida finalizar.

Pista:
En cada vuelta del bucle, puedes preguntar al encargado si ha sido la última reserva.
 */

import java.util.Scanner;

public class Ejercicio_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char [][] asientos = new char[5][5];

		boolean continuar = true;

		cargarAsientos(asientos);


		// Dar la bienvenida
		System.out.println("Bienvenido al sistema de reservas de asientos.");

		while(continuar) {

			// Mostrar asientos
			mostrarAsientos(asientos);

			// Pedir fila y asiento
			System.out.println("Ingresa una Fila 1-5");
			int fila = scanner.nextInt() - 1;
			// Validar fila
			while (fila < 0 || fila >= asientos.length) {
				System.out.println("Datos introducidos incorrectos. Ingrese valores entre 1 y 5.");
				fila = scanner.nextInt() - 1;
			}

			System.out.println("Ingresa un Asiento 1-5");
			int asiento = scanner.nextInt() - 1;
			// Validar asiento
      while (asiento < 0 || asiento >= asientos[fila].length) {
				System.out.println("Datos introducidos incorrectos. Ingrese valores entre 1 y 5.");
				asiento = scanner.nextInt() - 1;
			}
			System.out.println();

			/* if (fila >= 0 && fila < asientos.length && asiento >= 0 && asiento < asientos[fila].length ) { */
				if(asientos[fila][asiento] == '0'){
					asientos[fila][asiento] = 'X';
					System.out.println("Asiento reservado.");
				} else{
					System.out.println("Asiento ocupado, elija otro");
					continue;
				}
			/* } else {
				System.out.println("Datos introducidos incorrectos. Ingrese valores entre 1 y 5.");
				continue;
			} */

			// Preguntar si quiere reservar más asientos
			System.out.println("Desea reservar más asientos. s/n");
			char action = scanner.next().toLowerCase().charAt(0);

			if(action != 's'){
				continuar = false;
			}
		}

		mostrarAsientos(asientos);
		System.out.println("Reservas finalizadas.");
	}

	// Método para cargar los asientos con '0' (vacío)
	static void cargarAsientos(char[][] asientos) {
		for(char[] fila: asientos){
			for(int i = 0; i < fila.length; i++){
				fila[i] = '0';
			}
		}
	}

	// Método para mostrar los asientos
	static void mostrarAsientos(char[][] asientos) {
		System.out.println("  1 2 3 4 5");
		for(int i = 0; i < asientos.length; i++){
			String linea = (i + 1) + "";
			for(int j = 0; j < asientos[i].length; j++){
				linea += " " + asientos[i][j];
			}
			System.out.println(linea);
		}
	}
}
