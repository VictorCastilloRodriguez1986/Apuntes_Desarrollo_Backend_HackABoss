package dia_3;
/*
Ejercicio 2: Mostrar un mensaje personalizado

Crea una función llamada mostrarMensaje que reciba un nombre como parámetro y muestre en pantalla un saludo personalizado. Esta función no debe retornar ningún valor.

- La función debe recibir un parámetro de tipo String.

- Debe imprimir un mensaje en consola con el siguiente formato:
  "Hola, [nombre], bienvenido a Java!"
 */
public class Ejercicio_2 {
	public static void main(String[] args) {
		String nombre = "Juan";
		mostrarMensaje(nombre);

		// Llamada con otro nombre
		mostrarMensaje("María");
	}
	public static void mostrarMensaje(String nombre) {
		System.out.println("Hola, " + nombre + ", bienvenido a Java!");
	}
}
