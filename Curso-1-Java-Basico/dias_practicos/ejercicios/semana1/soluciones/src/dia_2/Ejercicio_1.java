package dia_2;

/*
Ejercicio 1 - Sintaxis básica

a) Escribe un programa en Java que muestre por pantalla un mensaje de bienvenida a un usuario. Por ejemplo: “Hola, bienvenido al sistema”.

b) Una vez lograda esta primera parte, permite que se almacene el nombre del usuario en una variable y se muestre el mismo en el mensaje.
Por ejemplo: “Hola Eduardo, bienvenido al sistema”.
*/

public class Ejercicio_1 {
	public static void main(String[] args) {
		System.out.println("Hola, bienvenido al sistema");

		String nombreUsuario = "Eduardo";
		System.out.println("Hola " + nombreUsuario + ", bienvenido al sistema");
	}
}
