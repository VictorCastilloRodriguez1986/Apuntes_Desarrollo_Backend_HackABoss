package dia_6.ejercicio_1;

public class Electrodomestico {
	// Atributos
	private int cod;
	private String marca;
	private String modelo;
	private int consumo;
	private String color;

	// Constructores
	public Electrodomestico() {
	}
	public Electrodomestico(int cod, String marca, String modelo, int consumo, String color) {
		this.cod = cod;
		this.marca = marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.color = color;
	}

	// Getters
	public int getCod() {
		return cod;
	}
	public String getColor() {
		return color;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getConsumo() {
		return consumo;
	}

	// Setters
	public void setCod(int cod) {
		this.cod = cod;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Electrodomestico = " + "marca='" + marca + '\'' +
						", modelo='" + modelo + '\'' +
						", consumo=" + consumo;

	}
}
