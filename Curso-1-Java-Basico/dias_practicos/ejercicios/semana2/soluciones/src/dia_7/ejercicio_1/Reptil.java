package dia_7.ejercicio_1;

public class Reptil extends Animal {
	//Atributos
	private int longitud;
	private String tiposDeEscamas;
	private String tipoDeVeneno;
	private String habitat;

	//Constructores
	public Reptil() {
	}
	public Reptil(int id, String nombre, int edad, String tipoDePiel, String tipoAlimentacion, int longitud, String tiposDeEscamas, String tipoDeVeneno, String habitat) {
		super(id, nombre, edad, tipoDePiel, tipoAlimentacion);
		this.longitud = longitud;
		this.tiposDeEscamas = tiposDeEscamas;
		this.tipoDeVeneno = tipoDeVeneno;
		this.habitat = habitat;
	}

	//Getters
	public int getId() {
		return super.getId();
	}
	public String getNombre() {
		return super.getNombre();
	}
	public int getEdad() {
		return super.getEdad();
	}
	public String getTipoDePiel() {
		return super.getTipoDePiel();
	}
	public String getTipoAlimentacion() {
		return super.getTipoAlimentacion();
	}

	//Setters
	public void setId(int id) {
		super.setId(id);
	}
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}
	public void setEdad(int edad) {
		super.setEdad(edad);
	}
	public void setTipoDePiel(String tipoDePiel) {
		super.setTipoDePiel(tipoDePiel);
	}
	public void setTipoAlimentacion(String tipoAlimentacion) {
		super.setTipoAlimentacion(tipoAlimentacion);
	}

	//Métodos
	@Override
	public void saludar(){
		System.out.println("¡Hola soy un reptil!");
	}

	@Override
	public String toString() {
		return "Reptil{" +
						"longitud=" + longitud +
						", tiposDeEscamas='" + tiposDeEscamas + '\'' +
						", tipoDeVeneno='" + tipoDeVeneno + '\'' +
						", habitat='" + habitat + '\'' +
						'}';
	}
}
