package clases;

import interfaces.Compartible;
import interfaces.Descargable;
import interfaces.Reproducible;

public class Video extends ContenidoMultimedia implements Reproducible, Descargable, Compartible {
	// Atributos
	private String calidad;
	private boolean descargado;

	// Constructor
	public Video(){
		super();
		this.calidad = "Unknown";
		this.descargado = false;
	}
	public Video(String titulo, int duracion, String calidad) {
		super(titulo, duracion);
		this.calidad = calidad;
		this.descargado = false;
	}

	// Getters
	public String getCalidad() {
		return calidad;
	}

	// Setters
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	public void setDescargado(boolean descargado) {
		this.descargado = descargado;
	}

	// Métodos
	@Override
	public void reproducir() {
		System.out.println("▶ Reproduciendo video: " + getTitulo() + " " + calidad + " (" + duracionFormateadaHMS() + ")");
	}

	@Override
	public void descargar() {
		if (!descargado) {
			System.out.println("\uD83D\uDCE5 Descargando video: " + getTitulo());
			descargado = true;
		} else {
			System.out.println("✓ Video ya descargado: " + getTitulo());
		}
	}

	@Override
	public boolean estaDescargado() {
		return descargado;
	}

	@Override
	public void compartir(String plataforma) {
		System.out.println("📤 Compartiendo video '" + getTitulo() + "' en " + plataforma);
	}

	@Override
	public String obtenerEnlace() {
		return "https://reproductor.com/video/" + getTitulo().toLowerCase().replace(" ", "-");
	}

	@Override
	public String toString() {
		return "Video{" +
				"titulo='" + getTitulo() + '\'' +
				", duracion=" + getDuracion() +
				", calidad='" + calidad + '\'' +
				", descargado=" + descargado +
				"} " + super.toString();
	}
}
