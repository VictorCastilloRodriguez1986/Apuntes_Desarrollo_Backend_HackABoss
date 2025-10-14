package dia_4;

/*
Ejercicio 1 - Estructuras Condicionales

Un concierto permite únicamente el ingreso de mayores de 18 años.

- Crea un programa que, a partir de la edad ingresada por el usuario, determine mediante un mensaje en pantalla si puede o no ingresar al evento.
- El programa debe mostrar, según cada caso, un mensaje informando la situación.
 */

public class Ejercicio_1 {
	public static void main(String[] args) {
		int edad = 20; // Puedes cambiar este valor para probar diferentes casos

		// Uso print par que me lo muestre en la misma línea
		System.out.print("Tienes " + edad + " años. ");
		if (edad > 17) {
			System.out.print("Puedes entrar.");
		} else {
			System.out.print("No puedes entrar.");
		}

		System.out.println();

		// Otra forma de hacerlo
		String mensaje = (edad > 17) ? "Puedes entrar." : "No puedes entrar.";
		System.out.print("Tienes " + edad + " años. ");
		System.out.println(mensaje);
	}
}
