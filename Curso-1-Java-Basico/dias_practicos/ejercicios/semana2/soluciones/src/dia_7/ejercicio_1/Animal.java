package dia_7.ejercicio_1;

public class Animal {
	// Atributos
	private int id;
	private String nombre;
	private int edad;
	private String tipoDePiel;
	private String tipoAlimentacion;

	// Constructores
	public Animal() {
	}
	public Animal(int id, String nombre, int edad, String tipoDePiel, String tipoAlimentacion) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.tipoDePiel = tipoDePiel;
		this.tipoAlimentacion = tipoAlimentacion;
	}

	// Getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getTipoDePiel() {
		return tipoDePiel;
	}
	public String getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setTipoDePiel(String tipoDePiel) {
		this.tipoDePiel = tipoDePiel;
	}
	public void setTipoAlimentacion(String tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	public void saludar(){
		System.out.println("¡Hola soy un animal!");
	}

	@Override
	public String toString() {
		return "Animal{" +
						"id=" + id +
						", nombre='" + nombre + '\'' +
						", edad=" + edad +
						", tipoDePiel='" + tipoDePiel + '\'' +
						", tipoAlimentacion='" + tipoAlimentacion + '\'' +
						'}';
	}
}
