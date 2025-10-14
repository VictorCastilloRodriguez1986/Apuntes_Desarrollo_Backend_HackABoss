package dia_6.ejercicio_2;

public class Ejercicio_2 {
	public static void main(String[] args) {
		Persona[] personas = new Persona[5];

		Persona p1 = new Persona(1, "Juan", 22, "Calle X", "003455555");
		Persona p2 = new Persona(2, "Victor", 43, "Calle X", "003455555");
		Persona p3 = new Persona(3, "Cintia", 26, "Calle X", "003455555");
		Persona p4 = new Persona(4, "Lupe", 32, "Calle X", "003455555");
		Persona p5 = new Persona(5, "Pablo", 34, "Calle X", "003455555");

		personas[0] = p1;
		personas[1] = p2;
		personas[2] = p3;
		personas[3] = p4;
		personas[4] = p5;

		for(Persona persona: personas){
			System.out.println(persona.getNombre() + " " + persona.getEdad());
		}

		System.out.println("\n-----------------\n");
		System.out.println("La persona en la posició 0 es: " + personas[0].getNombre());
		System.out.println("La persona en la posició 1 es: " + personas[1].getNombre());
		personas[0].setNombre("Luis");
		personas[1].setNombre("David");
		System.out.println("La persona en la posició 0 es: " + personas[0].getNombre());
		System.out.println("La persona en la posició 1 es: " + personas[1].getNombre());

		System.out.println("\n-----------------\n");
		for (Persona p : personas) {
			if (p.getEdad() > 30) {
				System.out.println(p.getNombre() + " " + p.getEdad());
			}
		}
	}
}
