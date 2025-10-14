package dia_2;

/*
Ejercicio 3 - Variables y Operadores

Escribe un programa que permita calcular el área de un triángulo y luego muestre el resultado por pantalla.

Recuerda que la fórmula para calcular esto es:
`(base * altura) / 2` (base por altura dividido dos).

Pista: Debes declarar variables para la base y la altura del triángulo, asignarles valores y luego calcular el área utilizando la fórmula.
*/

public class Ejercicio_3 {
	public static void main(String[] args) {
		// Declaración de variables para la base y la altura del triángulo
		double base = 5.0; // Puedes cambiar el valor de la base
		double altura = 10.0; // Puedes cambiar el valor de la altura

		// Cálculo del área del triángulo utilizando la fórmula (base * altura) / 2
		double area = (base * altura) / 2;

		// Mostrar el resultado por pantalla
		System.out.println("El área del triángulo con base " + base + " y altura " + altura + " es: " + area);

		// Con una función
		double areaTriangulo = calcularAreaTriangulo(base, altura);
		System.out.println("El área del triángulo con base " + base + " y altura " + altura + " es: " + areaTriangulo);
	}
	public static double calcularAreaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}
}
