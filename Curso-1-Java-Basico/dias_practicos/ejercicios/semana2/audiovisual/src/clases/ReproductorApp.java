package clases;

import interfaces.Compartible;
import interfaces.Descargable;
import interfaces.Reproducible;

import java.util.ArrayList;
import java.util.List;

public class ReproductorApp {
	// Depende de la interfaz, NO de clases concretas
	private List<Reproducible> playlist = new ArrayList<>();

	// Constructores
	public ReproductorApp() {
	}
	/* public ReproductorApp(Reproducible[] playlist) {
		this.playlist = playlist;
	} */
	public ReproductorApp(List<Reproducible> playlist) {
		this.playlist = playlist;
	}

	// Getters y Setters
	public List<Reproducible> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<Reproducible> playlist) {
		this.playlist = playlist;
	}

	// Bajo acoplamiento
	// No le importa si es Música, Video o Podcast
	public void reproducirTodo() {
		// \n para saltar una línea
		System.out.println("🎵 INICIANDO REPRODUCCIÓN DE PLAYLIST:");
		System.out.println("==========================================");
		for(Reproducible item : playlist) {
			item.reproducir();  // Mismo código, diferentes comportamientos
		}
		System.out.println("==========================================");
		System.out.println("✓ Playlist completada\n");
	}
	// Método para descargar solo el contenido descargable
	public void descargarTodo() {
		System.out.println("\uD83D\uDCE5 DESCARGANDO CONTENIDO DISPONIBLE:");
		System.out.println("=====================================");
		for (Reproducible item : playlist) {
			if (item instanceof Descargable) {
				// Si el item es una instancia de Descargable, lo convertimos a Descargable
				((Descargable) item).descargar();
			}
		}
		System.out.println("=====================================");
		System.out.println("✓ Descargas completadas\n");
	}

	// Método para compartir solo el contenido compartible
	public void compartirTodo(String plataforma) {
		System.out.println("📤 COMPARTIENDO EN " + plataforma.toUpperCase() + ":");
		System.out.println("===============================");
		for (Reproducible item : playlist) {
			if (item instanceof Compartible) {
				// Si el item es una instancia de Descargable, lo convertimos a Descargable
				((Compartible) item).compartir("Twitter");
				System.out.println("Enlace: " + ((Compartible) item).obtenerEnlace());
			}
		}
		System.out.println("===============================");
		System.out.println("✓ Comparticiones completadas\n");
	}

	// Método para agregar un contenido a la lista de reproducción
	public void agregar(Reproducible contenido) {
		if (contenido != null) {
			playlist.add(contenido);
			System.out.println("➕ Contenido añadido a la playlist: " + contenido);
		} else {
			System.out.println("✗ Error: Contenido no válido.");
		}
	}

	public void eliminar(String titulo) {
		boolean encontrado = false;
		for (Reproducible item : playlist) {
			if (!(item instanceof Podcast) && !(item instanceof AudioLibro)) {
				ContenidoMultimedia contenido = (ContenidoMultimedia) item; // casteo necesario
				if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
					playlist.remove(item);
					System.out.println("➖ Contenido eliminado de la playlist: " + titulo);
					encontrado = true;
					break;
				}
			}
		}
		if (!encontrado) {
			System.out.println("✗ Error: Contenido no encontrado en la playlist.");
		}
	}

	public void eliminar(String titulo, int episodio) {
		boolean encontrado = false;
		for (Reproducible item : playlist) {
			if (item instanceof Podcast && ((Podcast) item).getTitulo().equalsIgnoreCase(titulo) && ((Podcast) item).getEpisodio() == episodio) {
				playlist.remove(item);
				System.out.println("➖ Episodio eliminado de la playlist: " + titulo + " - Episodio " + episodio);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("✗ Error: Episodio no encontrado en la playlist.");
		}
	}

	public void eliminar(String titulo, String capitulo) {
		boolean encontrado = false;
		for (Reproducible item : playlist) {
			if (item instanceof AudioLibro && ((AudioLibro) item).getTitulo().equalsIgnoreCase(titulo) && ((AudioLibro) item).getCapitulo().equalsIgnoreCase(capitulo)) {
				playlist.remove(item);
				System.out.println("➖ Capítulo eliminado de la playlist: " + titulo + " - Capítulo " + capitulo);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("✗ Error: Capítulo no encontrado en la playlist.");
		}
	}

}
