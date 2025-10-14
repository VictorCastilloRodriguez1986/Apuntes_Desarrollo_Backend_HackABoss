package dia_3;
/*
Ejercicio 1: Suma de dos números

Crea una función llamada sumarNumeros que reciba dos números enteros como parámetros y retorne la suma de ambos.

- La función debe recibir dos parámetros enteros.

- Debe retornar un número entero.

- Imprime el resultado en la función main, llamando a sumarNumeros con diferentes valores.
 */
public class Ejercicio_1 {
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 10;

		int resultado = sumarNumeros(num1, num2);
		System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);

		// Llamada con otros valores
		System.out.println("La suma de 20 y 30 es: " + sumarNumeros(20, 30));
		System.out.println("La suma de -5 y 15 es: " + sumarNumeros(-5, 15));
	}
	public static int sumarNumeros(int a, int b) {
		return a + b;
	}
}
