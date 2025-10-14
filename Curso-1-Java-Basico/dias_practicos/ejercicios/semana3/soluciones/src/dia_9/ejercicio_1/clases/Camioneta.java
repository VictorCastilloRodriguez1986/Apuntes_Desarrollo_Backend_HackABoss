package dia_9.ejercicio_1.clases;

import dia_9.ejercicio_1.interfaces.Combustion;

public class Camioneta extends Vehiculo implements Combustion {
	// Atributos
	private int capacidadTanque;
	private Double consumoCombustible;

	// Constructores
	public Camioneta() {
		super();
	}
	public Camioneta(int id, String placa, String marca, String modelo, int anio, Double costo, int capacidadTanque, Double consumoCombustible) {
		super(id, placa, marca, modelo, anio, costo);
		this.capacidadTanque = capacidadTanque;
		this.consumoCombustible = consumoCombustible;
	}

	// Getters
	public int getCapacidadTanque() {
		return capacidadTanque;
	}
	public Double getConsumoCombustible() {
		return consumoCombustible;
	}

	// Setters
	public void setCapacidadTanque(int capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}
	public void setConsumoCombustible(Double consumoCombustible) {
		this.consumoCombustible = consumoCombustible;
	}

	// Otros Métodos
	@Override
	public void recargarCombustible() {
		System.out.println("la camioneta recargarga combustible y tiene una capacidad de " + this.capacidadTanque + " litros.");
	}

	@Override
	public String calcularAntiguedad() {
		return "La Camioneta tiene " + (java.time.LocalDate.now().getYear() - this.getAnio()) + " años de antigüedad.";
	}
}
