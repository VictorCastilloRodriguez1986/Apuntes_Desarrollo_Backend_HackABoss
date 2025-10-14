package dia_7.ejercicio_1;

public class Mamifero extends Animal{
	//Atributos
	private int numeroPatas;
	private String tipoReproducion;
	private String colorPelaje;
	private String habitat;

	//Constructores
	public Mamifero() {
	}
	public Mamifero(int id, String nombre, int edad, String tipoDePiel, String tipoAlimentacion, int numeroPatas, String habitat, String colorPelaje, String tipoReproducion) {
		super(id, nombre, edad, tipoDePiel, tipoAlimentacion);
		this.numeroPatas = numeroPatas;
		this.habitat = habitat;
		this.colorPelaje = colorPelaje;
		this.tipoReproducion = tipoReproducion;
	}

	//Getters
	public int getNumeroPatas() {
		return numeroPatas;
	}
	public String getTipoReproducion() {
		return tipoReproducion;
	}
	public String getColorPelaje() {
		return colorPelaje;
	}
	public String getHabitat() {
		return habitat;
	}

	//Setters
	public void setNumeroPatas(int numeroPatas) {
		this.numeroPatas = numeroPatas;
	}
	public void setTipoReproducion(String tipoReproducion) {
		this.tipoReproducion = tipoReproducion;
	}
	public void setColorPelaje(String colorPelaje) {
		this.colorPelaje = colorPelaje;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	//Métodos
	@Override
	public void saludar(){
		System.out.println("¡Hola soy un mamifero!");
	}

	@Override
	public String toString() {
		return "Mamifero{" +
						"numeroPatas=" + numeroPatas +
						", tipoReproducion='" + tipoReproducion + '\'' +
						", colorPelaje='" + colorPelaje + '\'' +
						", habitat='" + habitat + '\'' +
						'}';
	}
}
