package dia_6.ejercicio_3;

public class Ejercicio_3 {
	public static void main(String[] args) {
		Verdura[] verduras = {
			new Verdura(1, "Zanahoria", "Naranja", 10, false),
			new Verdura(2, "Pepino", "Verde", 20, false),
			new Verdura(3, "Lechuga", "Verde", 15, false),
			new Verdura(4, "Calabaza", "Naranja", 150, true),
			new Verdura(5, "Berenjena", "Viola", 100, true)
		};

		for(Verdura verdura: verduras){
			System.out.println(verdura.getNombre() + " " + verdura.getCalorias());
		}

		System.out.println("\n-----------------\n");

		verduras[3].setNombre("CalabazaX");
		verduras[3].setColor("VerdeX");
		verduras[3].setCalorias(100);
		verduras[3].setDebeCocinarse(false);

		verduras[4].setNombre("BerenjenaX");
		verduras[4].setColor("ViolaX");
		verduras[4].setCalorias(500);
		verduras[4].setDebeCocinarse(false);

		for(Verdura verdura: verduras){
			System.out.println(verdura);
		}

		System.out.println("\n-----------------\n");

		System.out.println("Verduras de color verde:");
		for(Verdura verdura: verduras){
			if (verdura.getColor().equalsIgnoreCase("verde")) {
				System.out.println(verdura);
			}
		}
	}
}
