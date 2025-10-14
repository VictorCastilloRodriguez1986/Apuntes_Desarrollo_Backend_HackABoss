package dia_7.ejercicio_2;

public class Camiseta extends Vestimenta {
	// Atributos
	private String manga;
	private String cuello;

	// Constructores
	public Camiseta() {
	}
	public Camiseta(String manga, String cuello, String codigo, String nombre, double precio, String marca, String talla, String color) {
		super(codigo, nombre, precio, marca, talla, color);
		this.manga = manga;
		this.cuello = cuello;
	}

	// Getters
	public String getManga() {
		return manga;
	}
	public String getCuello() {
		return cuello;
	}

	// Setters
	public void setManga(String manga) {
		this.manga = manga;
	}
	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	// Métodos
	@Override
	public void mostrarMensaje() {
		System.out.println("Esta camiseta es de manga: " + this.getManga());
	}
}
