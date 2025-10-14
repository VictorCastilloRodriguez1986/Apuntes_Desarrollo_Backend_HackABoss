package dia_9.ejercicio_1.clases;

import dia_9.ejercicio_1.interfaces.Combustion;

public class Moto extends Vehiculo implements Combustion {
	// Atributos
	private int cilindrada;
	private String tipoMotor;

	// Constructores
	public Moto() {
		super();
	}
	public Moto(int id, String placa, String marca, String modelo, int anio, Double costo, int cilindrada, String tipoMotor) {
		super(id, placa, marca, modelo, anio, costo);
		this.cilindrada = cilindrada;
		this.tipoMotor = tipoMotor;
	}

	// Getters
	public int getCilindrada() {
		return cilindrada;
	}
	public String getTipoMotor() {
		return tipoMotor;
	}

	// Setters
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	// Otros Métodos
	@Override
	public void recargarCombustible() {
		System.out.println("La Moto recarga combustible y tiene una cilindrada de " + this.cilindrada + " cc.");
	}

	@Override
	public String calcularAntiguedad() {
		return "La Moto tiene " + (java.time.LocalDate.now().getYear() - this.getAnio()) + " años de antigüedad.";
	}
}
