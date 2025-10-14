package dia_3;

/*
Ejercicio 3: Concatenación con distinción de mayúsculas y minúsculas

Crea una función en Java que reciba dos cadenas como parámetros: una en mayúsculas y otra en minúsculas, y las concatene en un orden específico.

- Escribe una función en Java llamada concatenarCadenas que reciba dos parámetros de tipo String: cadenaMayusculas y cadenaMinusculas.

- La función debe concatenar las dos cadenas de la siguiente manera: primero la cadena en minúsculas, seguida de un espacio, y luego la cadena en mayúsculas.

- La función debe retornar la cadena resultante de la concatenación.

- En el método main, llama a la función concatenarCadenas con dos cadenas de ejemplo: una en mayúsculas y otra en minúsculas.

- Imprime el resultado de la concatenación en la consola.
 */

public class Ejercicio_3 {
	public static void main(String[] args) {
		String cadenaMayusculas = "HOLA";
		String cadenaMinusculas = "mundo";

		String resultado = concatenarCadenas(cadenaMayusculas, cadenaMinusculas);
		System.out.println("Resultado de la concatenación: " + resultado);

		// Llamada a la función transformarConcatenarCadenas
		String resultadoTransformado = transformarConcatenarCadenas(cadenaMayusculas, cadenaMinusculas);
		System.out.println("Resultado de la transformación y concatenación: " + resultadoTransformado);
	}
	public static String concatenarCadenas(String cadenaMayusculas, String cadenaMinusculas) {
		return cadenaMinusculas + " " + cadenaMayusculas;
	}
	public static String transformarConcatenarCadenas(String cadenaMayusculas, String cadenaMinusculas) {
		return cadenaMinusculas.toUpperCase() + " " + cadenaMayusculas.toLowerCase();
	}
}
