package dia_9.ejercicio_2;

public class Producto {
	// Atributos
	private int codigo;
	private String nombre;
	private String marca;
	private String tipo;
	private Double precioCosto;
	private Double precioVenta;
	private int cantidadEnStock;

	// Constructores
	public Producto() {
		this.codigo = 0;
		this.nombre = "";
		this.marca = "";
		this.tipo = "";
		this.precioCosto = 0.0;
		this.precioVenta = 0.0;
		this.cantidadEnStock = 0;
	}
	public Producto(int codigo, String nombre, String marca, String tipo, Double precioCosto, Double precioVenta, int cantidadEnStock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.cantidadEnStock = cantidadEnStock;
	}

	// Getters
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getMarca() {
		return marca;
	}
	public String getTipo() {
		return tipo;
	}
	public Double getPrecioCosto() {
		return precioCosto;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public int getCantidadEnStock() {
		return cantidadEnStock;
	}
	
	// Setters
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setPrecioCosto(Double precioCosto) {
		this.precioCosto = precioCosto;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
}
