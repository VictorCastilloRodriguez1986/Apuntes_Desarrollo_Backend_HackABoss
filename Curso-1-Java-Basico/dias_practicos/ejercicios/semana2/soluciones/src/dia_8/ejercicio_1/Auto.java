package dia_8.ejercicio_1;

public class Auto implements Vehiculo{

	@Override
	public void acelerar() {
		System.out.println("Acelerando");
	}

	@Override
	public void frenar() {
		System.out.println("Frenando");
	}
}
