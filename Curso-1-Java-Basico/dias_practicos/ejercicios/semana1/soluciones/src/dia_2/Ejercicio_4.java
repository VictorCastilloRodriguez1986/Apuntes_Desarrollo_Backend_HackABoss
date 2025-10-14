package dia_2;
/*
Ejercicio4 - Operaciones de Lectura

Crea un programa que pida al usuario que ingrese por teclado dos números enteros y realice las siguientes operaciones con ellos: suma, resta, multiplicación y división.

Muestra por pantalla/consola los resultados de cada operación con un mensaje amigable para el usuario.

Extra:
¿Qué sucede si como segundo número de una división se ingresa 0?
Con lo que sabes o has aprendido hasta ahora… ¿De qué manera tratarías de evitar esta situación?
 */
public class Ejercicio_4 {
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("Ingrese el primer número entero: ");
		int numero1 = scanner.nextInt();

		System.out.print("Ingrese el segundo número entero: ");
		int numero2 = scanner.nextInt();

		int suma = numero1 + numero2;
		int resta = numero1 - numero2;
		int multiplicacion = numero1 * numero2;

		System.out.println("Resultados:");
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
		System.out.println("Multiplicación: " + multiplicacion);

		if (numero2 != 0) {
			double division = (double) numero1 / numero2;
			System.out.println("División: " + division);
		} else {
			System.out.println("Error: No se puede dividir por cero.");
		}

		scanner.close();

		// Con funciones
		System.out.println("Resultados con funciones:");
		System.out.println("Sumando: " + sumar(numero1, numero2));
		System.out.println("Restando: " + restar(numero1, numero2));
		System.out.println("Multiplicando: " + multiplicar(numero1, numero2));
		if (numero2 != 0) {
			System.out.println("Dividiendo: " + dividir(numero1, numero2));
		} else {
			System.out.println("Error: No se puede dividir por cero.");
		}
	}

	public static int sumar(int a, int b) {
		return a + b;
	}
	public static int restar(int a, int b) {
		return a - b;
	}
	public static int multiplicar(int a, int b) {
		return a * b;
	}
	public static double dividir(int a, int b) {
		// Aquí se debería manejar la división por cero, pero aún no habéis dado excepciones por eso lo gestionamos en el main
		return (double) a / b;
	}
}
