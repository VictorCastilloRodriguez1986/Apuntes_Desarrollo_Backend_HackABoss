package dia_6.ejercicio_3;

public class Verdura {
	// Atributos
	private int id;
	private String nombre;
	private String color;
	private int calorias;
	private boolean debeCocinarse;

	// Constructores
	public Verdura() {
	}
	public Verdura(int id, String nombre, String color, int calorias, boolean debeCocinarse) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.calorias = calorias;
		this.debeCocinarse = debeCocinarse;
	}

	// Getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getColor() {
		return color;
	}
	public int getCalorias() {
		return calorias;
	}
	public boolean isDebeCocinarse() {
		return debeCocinarse;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public void setDebeCocinarse(boolean debeCocinarse) {
		this.debeCocinarse = debeCocinarse;
	}

	@Override
	public String toString() {
		return "Verdura{" +
						"id=" + id +
						", nombre='" + nombre + '\'' +
						", color='" + color + '\'' +
						", calorias=" + calorias +
						", debeCocinarse=" + debeCocinarse +
						'}';
	}
}
