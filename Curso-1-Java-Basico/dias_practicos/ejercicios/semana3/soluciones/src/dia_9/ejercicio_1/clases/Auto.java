package dia_9.ejercicio_1.clases;

import dia_9.ejercicio_1.interfaces.Electrico;

import java.time.LocalDate;

public class Auto extends Vehiculo implements Electrico {
	// Atributos
	private int capacidadBateria;
	private int autonomia;

	// Constructores
	public Auto() {
		super();
	}
	public Auto(int id, String placa, String marca, String modelo, int anio, Double costo, int capacidadBateria, int autonomia) {
		super(id, placa, marca, modelo, anio, costo);
		this.capacidadBateria = capacidadBateria;
		this.autonomia = autonomia;
	}

	// Getters
	public int getCapacidadBateria() {
		return capacidadBateria;
	}
	public int getAutonomia() {
		return autonomia;
	}

	// Setters
	public void setCapacidadBateria(int capacidadBateria) {
		this.capacidadBateria = capacidadBateria;
	}
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}

	// Otros Métodos
	@Override
	public void cargarEnergia() {
		System.out.println("El auto carga energia eléctrica y tiene una capacidad de " + this.capacidadBateria + " kWh");
	}

	@Override
	public String calcularAntiguedad() {
		return "El Auto tiene " + (LocalDate.now().getYear() - this.getAnio()) + " años de antigüedad.";
	}
}
