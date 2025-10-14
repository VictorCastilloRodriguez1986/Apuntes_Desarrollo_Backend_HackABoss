package clases;

import interfaces.Compartible;
import interfaces.Descargable;
import interfaces.Reproducible;

public class Musica extends ContenidoMultimedia implements Reproducible {
	// Atributos
	private String artista;
	private String genero; // Opcional, si se desea agregar género musical

	// Constructor
	public Musica(){
		super();
		this.artista = "Sin artista";
		this.genero = "Sin género";
	}

	public Musica(String titulo, int duracion, String artista, String genero) {
		super(titulo, duracion);
		this.artista = artista;
		this.genero = genero;
	}

	// Getters
	public String getArtista() {
		return artista;
	}
	public String getGenero() {
		return genero;
	}

	// Setters
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	// Métodos
	@Override
	public void reproducir() {
		System.out.println("♪ Reproduciendo música: " + getTitulo() + " - " + artista + " (" + duracionFormateadaHMS() + ")");
	}

	@Override
	public String toString() {
		return "Musica{" +
						"titulo='" + getTitulo() + '\'' +
						", duracion=" + getDuracion() +
						"artista='" + artista + '\'' +
						", genero='" + genero + '\'' +
						"} " + super.toString();
	}
}
