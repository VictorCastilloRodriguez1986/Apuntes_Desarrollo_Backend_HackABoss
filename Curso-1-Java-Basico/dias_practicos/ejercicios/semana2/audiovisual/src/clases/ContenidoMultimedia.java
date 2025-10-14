package clases;

public class ContenidoMultimedia {
	// Atributos
	private String titulo;
	private int duracion; // en segundos

	// Constructores
	public ContenidoMultimedia() {
		this.titulo = "Sin título";
		this.duracion = 0;
	}
	public ContenidoMultimedia(String titulo, int duracion) {
		this.titulo = titulo;
		this.duracion = duracion;
	}

	// Getters
	public String getTitulo() {
		return titulo;
	}
	public int getDuracion() {
		return duracion;
	}

	// Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	// Métodos
	public String duracionFormateadaHMS() {
		int horas = duracion / 3600;
		int minutos = (duracion % 3600) / 60;
		int segundos = duracion % 60;

		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}

	@Override
	public String toString() {
		return "ContenidoMultimedia{" +
						"titulo='" + titulo + '\'' +
						", duracion=" + duracion +
						'}';
	}
}
