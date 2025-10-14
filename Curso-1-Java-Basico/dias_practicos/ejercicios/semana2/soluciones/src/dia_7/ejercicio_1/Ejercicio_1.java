package dia_7.ejercicio_1;

public class Ejercicio_1 {
	public static void main(String[] args) {
		Mamifero mamifero = new Mamifero();
		Ave ave = new Ave();
		Reptil reptil = new Reptil();

		mamifero.saludar();
		ave.saludar();
		reptil.saludar();

		Animal animal = mamifero;
		System.out.println(animal);

		System.out.println(mamifero.getNumeroPatas());
	}
}
