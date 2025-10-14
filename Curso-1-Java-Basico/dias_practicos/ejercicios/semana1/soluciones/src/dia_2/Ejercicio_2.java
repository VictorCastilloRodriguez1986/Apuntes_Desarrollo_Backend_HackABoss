package dia_2;
/*
Ejercicio 2 - Tipos de Datos

a) Crea un programa que declare una variable para cada uno de los siguientes tipos de datos: int, double, boolean y String.
Asigna un valor a cada variable y muestra su contenido en la consola.

b) Ahora, asigna valores que no correspondan al tipo de dato.
Por ejemplo, un int en un String o un String en un double…

- ¿Qué sucede con el programa?
- ¿Se produce algún error?
- ¿En qué situaciones se genera error y en cuáles no?
- Justificar el por qué de cada caso.
*/
public class Ejercicio_2 {
	public static void main(String[] args) {
		// Declaración de variables
		int numeroEntero = 42;
		double numeroDecimal = 3.14;
		boolean esVerdadero = true;
		String texto = "Hola, Java";

		// Mostrar contenido de las variables
		System.out.println("Número Entero: " + numeroEntero);
		System.out.println("Número Decimal: " + numeroDecimal);
		System.out.println("Booleano: " + esVerdadero);
		System.out.println("Texto: " + texto);

		/// Ejemplos de valores incorrectos en la variable numeroEntero
		// numeroEntero = "Texto"; // Esto generaría un error de compilación, ya que no se puede asignar un String a un int.
		// numeroEntero = 3.14; // Esto también generaría un error de compilación, ya que no se puede asignar un double a un int.
		numeroEntero = (int) 3.14; // Esto no genera error, pero se pierde la parte decimal al convertir un double a int.
		System.out.println("Asignando 3.14 a numeroEntero: " + numeroEntero);
		numeroEntero = (int) 'A'; // Esto no genera error, pero convierte el carácter 'A' a su valor ASCII (65).
		System.out.println("Asignando (int)'A' a numeroEntero: " + numeroEntero);
		numeroEntero = (int) 2147483647L; // Esto no genera error, pero convierte un long a int, lo cual es seguro si el valor está dentro del rango de int. Si añadimos un valor mayor a 2,147,483,647, se perderá información y no obtendremos el valor esperado.
		System.out.println("Asignando (int)100L a numeroEntero: " + numeroEntero);

		/// Ejemplos de valores incorrectos en la variable numeroDecimal
		// numeroDecimal = true; // Esto generaría un error de compilación, ya que no se puede asignar un boolean a un double.
		numeroDecimal = 42; // Esto no genera error, pero convierte un int a double, lo cual es seguro y no pierde información.
		System.out.println("Asignando 42 a numeroDecimal: " + numeroDecimal);
		numeroDecimal = (double) 'A'; // Esto no genera error, pero convierte el carácter 'A' a su valor ASCII (65.0).
		System.out.println("Asignando (double)'A' a numeroDecimal: " + numeroDecimal);
		numeroDecimal = (double) 100L; // Esto no genera error, pero convierte un long a double, lo cual es seguro y no pierde información. Si añadimos un valor mayor a 2^53(9,223,372,036,854,775,807), se perderá información y no obtendremos el valor esperado.
		System.out.println("Asignando (double)100L a numeroDecimal: " + numeroDecimal);

		/// Ejemplos de valores incorrectos en la variable esVerdadero
		// esVerdadero = 42; // Esto generaría un error de compilación, ya que no se puede asignar un int a un boolean.
		// esVerdadero = (boolean) 1; // Esto generaría un error de compilación, ya que no se puede asignar un int a un boolean.
		// esVerdadero = "Texto"; // Esto generaría un error de compilación, ya que no se puede asignar un String a un boolean.
		esVerdadero = (1 > 0); // Esto no genera error, ya que se evalúa una expresión booleana.
		System.out.println("Asignando (1 > 0) a esVerdadero: " + esVerdadero);

		/// Ejemplos de valores incorrectos en la variable texto
		// texto = 42; // Esto generaría un error de compilación, ya que no se puede asignar un int a un String.
		// texto = 100L; // Esto generaría un error de compilación, ya que no se puede asignar un long a un String.
		texto = String.valueOf(42); // Esto no genera error, convierte un int a String.
		System.out.println("Asignando String.valueOf(42) a texto: " + texto);
		texto = String.valueOf(3.14); // Esto no genera error, convierte un double a String.
		System.out.println("Asignando String.valueOf(3.14) a texto: " + texto);
		texto = String.valueOf(true); // Esto no genera error, convierte un boolean a String.
		System.out.println("Asignando String.valueOf(true) a texto: " + texto);
		texto = String.valueOf('A'); // Esto no genera error, convierte un char a String.
		System.out.println("Asignando String.valueOf('A') a texto: " + texto);
		texto = String.valueOf(100L); // Esto no genera error, convierte un long a String.
		System.out.println("Asignando String.valueOf(100L) a texto: " + texto);

		// Resumen de errores
		// - Los errores de compilación ocurren cuando se intenta asignar un valor de un tipo incompatible a una variable.
		// - Los errores de ejecución ocurren cuando se intenta realizar una operación que no es válida para el tipo de dato, como convertir un tipo a otro incompatible.
		// - En algunos casos, como al convertir un double a int o un long a int, no se genera un error, pero se pierde información (como la parte decimal).
		// - En otros casos, como al convertir un char a int o double, no se genera un error y se obtiene el valor ASCII del carácter.
		// - En general, es importante asegurarse de que los tipos de datos sean compatibles al realizar asignaciones o conversiones para evitar errores y pérdida de información.

	}
}
