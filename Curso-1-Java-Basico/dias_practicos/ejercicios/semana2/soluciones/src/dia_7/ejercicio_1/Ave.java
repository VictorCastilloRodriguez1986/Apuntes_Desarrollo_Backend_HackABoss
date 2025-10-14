package dia_7.ejercicio_1;

public class Ave extends Animal{
	//Atributos
	private String envergaduraDeAlas;
	private String tipoDeVuelo;
	private String colorDePlumaje;
	private String tipoDePico;

	//Constructores
	public Ave() {
	}
	public Ave(int id, String nombre, int edad, String tipoDePiel, String tipoAlimentacion, String envergaduraDeAlas, String tipoDeVuelo, String colorDePlumaje, String tipoDePico) {
		super(id, nombre, edad, tipoDePiel, tipoAlimentacion);
		this.envergaduraDeAlas = envergaduraDeAlas;
		this.tipoDeVuelo = tipoDeVuelo;
		this.colorDePlumaje = colorDePlumaje;
		this.tipoDePico = tipoDePico;
	}

	//Getters
	public String getEnvergaduraDeAlas() {
		return envergaduraDeAlas;
	}
	public String getTipoDeVuelo() {
		return tipoDeVuelo;
	}
	public String getColorDePlumaje() {
		return colorDePlumaje;
	}
	public String getTipoDePico() {
		return tipoDePico;
	}

	//Setters
	public void setEnvergaduraDeAlas(String envergaduraDeAlas) {
		this.envergaduraDeAlas = envergaduraDeAlas;
	}
	public void setTipoDeVuelo(String tipoDeVuelo) {
		this.tipoDeVuelo = tipoDeVuelo;
	}
	public void setColorDePlumaje(String colorDePlumaje) {
		this.colorDePlumaje = colorDePlumaje;
	}
	public void setTipoDePico(String tipoDePico) {
		this.tipoDePico = tipoDePico;
	}

	//Métodos
	@Override
	public void saludar(){
		System.out.println("¡Hola soy un ave!");
	}

	@Override
	public String toString() {
		return "Ave{" +
						"envergaduraDeAlas='" + envergaduraDeAlas + '\'' +
						", tipoDeVuelo='" + tipoDeVuelo + '\'' +
						", colorDePlumaje='" + colorDePlumaje + '\'' +
						", tipoDePico='" + tipoDePico + '\'' +
						'}';
	}
}
