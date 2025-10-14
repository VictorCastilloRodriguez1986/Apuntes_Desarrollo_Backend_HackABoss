package dia_6.ejercicio_1;

public class Ejercicio_1 {
	public static void main(String[] args) {
		Electrodomestico e1 = new Electrodomestico(1,"Samsung", "Nevera A1", 1000, "Gris");
		Electrodomestico e2 = new Electrodomestico(2,"Electrolux", "Horno ABX", 2000, "Negro");
		Electrodomestico e3 = new Electrodomestico(3,"Indesit", "Microondas XX", 1500, "Blanco");
		Electrodomestico e4 = new Electrodomestico();

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4.getMarca());
	}
}
