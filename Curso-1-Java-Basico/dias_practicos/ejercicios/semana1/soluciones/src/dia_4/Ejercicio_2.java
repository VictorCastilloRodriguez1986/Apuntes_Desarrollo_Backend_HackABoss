package dia_4;

/*
Ejercicio 2 - Estructuras Repetitivas

Imagina que eres cajero en un supermercado.

- Crea un programa en Java que permita ingresar el precio de varios productos comprados por un cliente.
- Utiliza una estructura repetitiva (la que prefieras) para seguir solicitando precios hasta que el usuario decida finalizar. Luego, muestra el total de la compra que debe abonar.

Pista:
Recuerda que existen dos tipos de bucles:

- Los controlados por un contador (cuando sabes cuántos productos se van a ingresar)
- Los controlados por un centinela (cuando no sabes cuántos productos serán).
  En este caso debes aplicar un “centinela”.
   Por ejemplo, podrías finalizar el ingreso cuando se introduce un número negativo o 0 como monto del producto.
 */

public class Ejercicio_2 {
	public static void main(String[] args) {
		double totalCompra = 0.0;
		double precioProducto;

		do {
			// Solicitar el precio del producto
			System.out.println("Ingrese el precio del producto (o un número negativo para finalizar): ");
			precioProducto = new java.util.Scanner(System.in).nextDouble();

			// Si el precio es positivo, se suma al total
			if (precioProducto > 0) {
				totalCompra += precioProducto;
			}
		} while (precioProducto > 0); // Continuar hasta que se ingrese 0 o un número negativo

		// Mostrar el total de la compra
		// Usamos printf para formatear el número a dos decimales, se indica con %.2f
		// La variable totalCompra se muestra con dos decimales en la posición donde se indica el formato
		// Fijaros que he puesto una coma en vez de un +. De esta forma le estoy pasando 2 argumentos a printf
		System.out.printf("El total de la compra es: %.2f. Hasta la próxima", totalCompra);
	}
}
