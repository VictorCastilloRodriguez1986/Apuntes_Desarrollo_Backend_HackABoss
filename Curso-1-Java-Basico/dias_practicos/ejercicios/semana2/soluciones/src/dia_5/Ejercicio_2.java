package dia_5;

public class Ejercicio_2 {
	public static void main(String[] args) {
		System.out.println(esPar(4));
		System.out.println(esPar(7));
		System.out.println(esPar(99));
	}

	private static String esPar(int num) {
		// Verifica si el número es par o impar
		return "El número " + num + " es " + ((num % 2 == 0) ? "par" : "impar");
	}
}
