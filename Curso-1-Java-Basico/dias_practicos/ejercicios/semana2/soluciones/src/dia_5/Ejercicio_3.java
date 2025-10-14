package dia_5;

public class Ejercicio_3 {
	public static void main(String[] args) {
		String[] nombres = {"Carlos", "Ana", "Luis"};
		mostrarNombres(nombres);
	}

	private static void mostrarNombres(String[] nombres) {
		for(String nombre : nombres){
			System.out.println(nombre);
		}
	}
}
