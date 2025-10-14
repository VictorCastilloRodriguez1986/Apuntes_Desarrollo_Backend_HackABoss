package dia_9.ejercicio_1.clases;

public abstract class Vehiculo {
	// Atributos
	private int id;
	private String placa;
	private String marca;
	private String modelo;
	private int anio;
	private Double costo;

	// Constructores
	public Vehiculo() {
	}
	public Vehiculo(int id, String placa, String marca, String modelo, int anio, Double costo) {
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.costo = costo;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getAnio() {
		return anio;
	}
	public Double getCosto() {
		return costo;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	// Otros Métodos
	@Override
	public String toString() {
		return "Vehiculo{" +
						"id=" + id +
						", placa='" + placa + '\'' +
						", marca='" + marca + '\'' +
						", modelo='" + modelo + '\'' +
						", anio=" + anio +
						", costo=" + costo +
						'}';
	}

	public abstract String calcularAntiguedad();
}
