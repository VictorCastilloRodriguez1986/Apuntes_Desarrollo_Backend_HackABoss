package clases;

import interfaces.Compartible;
import interfaces.Descargable;
import interfaces.Reproducible;

public class Podcast extends ContenidoMultimedia implements Reproducible, Descargable {
	// Atributos
	private String presentador;
	private int episodio;
	private boolean descargado;

	// Constructor
	public Podcast() {
		super();
		this.presentador = "Sin presentador";
		this.episodio = 0;
		this.descargado = false;
	}
	public Podcast(String titulo, int duracion, String presentador, int episodio) {
		super(titulo, duracion);
		this.presentador = presentador;
		this.episodio = episodio;
		this.descargado = false;
	}

	// Getters
	public String getPresentador() {
		return presentador;
	}
	public int getEpisodio() {
		return episodio;
	}

	// Setters
	public void setPresentador(String presentador) {
		this.presentador = presentador;
	}
	public void setEpisodio(int episodio) {
		this.episodio = episodio;
	}
	public void setDescargado(boolean descargado) {
		this.descargado = descargado;
	}

	// Métodos
	@Override
	public void reproducir() {
		System.out.println("🎙 Reproduciendo podcast: " + getTitulo() + " - " + presentador + ", Episodio " + episodio + ")" + " (" + duracionFormateadaHMS());
	}

	@Override
	public void descargar() {
		if (!descargado) {
			System.out.println("\uD83D\uDCE5 Descargando podcast: " + getTitulo());
			descargado = true;
		} else {
			System.out.println("✓ Podcast ya descargado: " + getTitulo());
		}
	}

	@Override
	public boolean estaDescargado() {
		return descargado;
	}

	@Override
	public String toString() {
		return "Podcast{" +
				"titulo='" + getTitulo() + '\'' +
				", duracion=" + getDuracion() +
				", presentador='" + presentador + '\'' +
				", episodio=" + episodio +
				"} " + super.toString();
	}
}
