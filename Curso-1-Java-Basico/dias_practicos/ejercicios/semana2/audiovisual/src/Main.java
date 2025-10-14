import clases.*;
import interfaces.Reproducible;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List <Reproducible> listaReproduccion = new ArrayList<>();
		// Agregar diferentes tipos de contenidos a la lista de reproducción
		listaReproduccion.add(new Musica("Bohemian Rhapsody", 360, "Queen", "Rock")); // ♪ Reproduciendo música: Bohemian Rhapsody - Queen (00:06:00)
		listaReproduccion.add(new Video("Video de ejemplo", 5400, "1080p")); // ▶ Reproduciendo video: Video de ejemplo 1080p (01:30:00)
		listaReproduccion.add(new Podcast("Podcast de Tecnología", 1800, "Juan Pérez", 5)); // 🎙 Reproduciendo podcast: Podcast de Tecnología - Juan Pérez, Episodio 5 (00:30:00)
		listaReproduccion.add(new AudioLibro("El Alquimista", 36000, "Paulo Coelho", "Siri", "Melquisedec")); // 🎧 Reproduciendo audiolibro: El Alquimista - Paulo Coelho (300 min)

		ReproductorApp reproductor = new ReproductorApp(listaReproduccion);

		// Reproducir una lista independientemente del tipo de contenido
		reproductor.reproducirTodo();  // Reproduce todos los contenidos de la lista
		reproductor.descargarTodo();   // Descarga solo los contenidos que implementan la interfaz Descargable
		reproductor.compartirTodo("Twitter"); // Comparte solo los contenidos que implementan la interfaz Compartible

		// Eliminar un contenido específico de la lista
		reproductor.eliminar("Video de ejemplo");
		reproductor.eliminar("Podcast de Tecnología", 5);
		reproductor.eliminar("El Alquimista", "Melquisede");
		//  Agregar un nuevo contenido a la lista
		reproductor.agregar(new Video("Nuevo Video", 1200, "720p")); // ▶ Reproduciendo video: Nuevo Video 720p (00:20:00)

		reproductor.reproducirTodo();
	}
}