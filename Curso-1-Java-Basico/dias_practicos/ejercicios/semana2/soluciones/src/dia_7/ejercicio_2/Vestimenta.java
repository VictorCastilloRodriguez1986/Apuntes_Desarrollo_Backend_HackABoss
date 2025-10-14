package dia_7.ejercicio_2;

public class Vestimenta {
	// Atributos
	private String codigo;
	private String nombre;
	private double precio;
	private String marca;
	private String talla;
	private String color;

	// Constructores
	public Vestimenta() {
	}
	public Vestimenta(String codigo, String nombre, double precio, String marca, String talla, String color) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.talla = talla;
		this.color = color;
	}

	// Getters
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public String getMarca() {
		return marca;
	}
	public String getTalla() {
		return talla;
	}
	public String getColor() {
		return color;
	}

	// Setters
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public void setColor(String color) {
		this.color = color;
	}

	// Métodos
	public void mostrarMensaje() {
		System.out.println("Soy vestimenta y mi marca es: " + this.getMarca());
	}

}
