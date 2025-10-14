package dia_7.ejercicio_2;

public class Sombrero extends Vestimenta {
	// Atributos
	private String tipo;
	private String tamaño;

	// Constructores
	public Sombrero() {
	}
	public Sombrero(String tipo, String tamaño, String codigo, String nombre, double precio, String marca, String talla, String color) {
		super(codigo, nombre, precio, marca, talla, color);
		this.tipo = tipo;
		this.tamaño = tamaño;
	}

	// Getters
	public String getTipo() {
		return tipo;
	}
	public String getTamaño() {
		return tamaño;
	}

	// Setters
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	// Métodos
	@Override
	public void mostrarMensaje() {
		System.out.println("Este sombrero/gorro es de tipo: " + this.getTipo());
	}
}
