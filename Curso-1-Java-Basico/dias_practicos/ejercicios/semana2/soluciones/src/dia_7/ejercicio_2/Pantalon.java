package dia_7.ejercicio_2;

public class Pantalon extends Vestimenta {
	// Atributos
	private String estilo;
	private String tipoTejido;

	// Constructores
	public Pantalon() {
	}
	public Pantalon(String estilo, String tipoTejido, String codigo, String nombre, double precio, String marca, String talla, String color) {
		super(codigo, nombre, precio, marca, talla, color);
		this.estilo = estilo;
		this.tipoTejido = tipoTejido;
	}

	// Getters
	public String getEstilo() {
		return estilo;
	}
	public String getTipoTejido() {
		return tipoTejido;
	}

	// Setters
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public void setTipoTejido(String tipoTejido) {
		this.tipoTejido = tipoTejido;
	}

	// Métodos

	@Override
	public void mostrarMensaje() {
		System.out.println("Este pantalón es de estilo: " + this.getEstilo());
	}



}
