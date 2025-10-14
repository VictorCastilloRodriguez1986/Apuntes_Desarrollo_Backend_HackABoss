package dia_5;

public class Ejercicio_1 {
	public static void main(String[] args) {
		verificarNumero(3);
		verificarNumero(-3);
		verificarNumero(0);

	}

	private static void verificarNumero(int numero) {
		if(numero > 0)
			System.out.println("El número es positivo");
		else if (numero < 0)
			System.out.println("El número es negativo");
		else
			System.out.println("El número es 0");
	}
}
