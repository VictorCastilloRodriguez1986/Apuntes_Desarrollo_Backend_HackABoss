package clases;

import interfaces.Descargable;
import interfaces.Reproducible;

public class AudioLibro extends ContenidoMultimedia implements Reproducible, Descargable {
	// Atributos
	private String autor;
	private String narrador;
	private String capitulo;
	private boolean descargado;

	// Constructores
	public AudioLibro() {
		super();
		this.autor = "Sin Autor";
		this.narrador = "Sin Narrador";
		this.capitulo = "Sin Capítulo";
		this.descargado = false;
	}
	public AudioLibro(String titulo, int duracion, String autor, String narrador, String capitulo) {
		super(titulo, duracion);
		this.autor = autor;
		this.narrador = narrador;
		this.capitulo = capitulo;
		this.descargado = false;
	}

	// Getters
	public String getAutor() { return autor; }
	public String getNarrador() { return narrador; }
	public String getCapitulo() { return capitulo; }

	// Setters
	public void setAutor(String autor) { this.autor = autor; }
	public void setNarrador(String narrador) { this.narrador = narrador; }
	public void setCapitulo(String capitulo) { this.capitulo = capitulo; }
	public void setDescargado(boolean descargado) { this.descargado = descargado; }

	// Métodos
	@Override
	public void reproducir() {
		System.out.println("\uD83C\uDFA7 Reproduciendo audiolibro: " + getTitulo() + " - " + autor
						+ ", Narrador " + narrador + ")" + " (" + duracionFormateadaHMS() + ")");
	}
	@Override
	public void descargar() {
		if (!descargado) {
			System.out.println("\uD83D\uDCE5 Descargando audiolibro: " + getTitulo());
			descargado = true;
		} else {
			System.out.println("✓ Audiolibro ya descargado: " + getTitulo());
		}
	}

	@Override
	public boolean estaDescargado() {
		return descargado;
	}

	@Override
	public String toString() {
		return "AudioLibro{" +
				"titulo='" + getTitulo() + '\'' +
				", duracion=" + getDuracion() +
				", autor='" + autor + '\'' +
				", narrador='" + narrador + '\'' +
				", capitulo=" + capitulo +
				"} " + super.toString();
	}
}
