package com.hackaboss.hackflix.repository;

import com.hackaboss.hackflix.model.Pelicula;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class PeliculaRepository {
    private List<Pelicula> peliculas = Arrays.asList(
            new Pelicula("El escape", "Acción", 2023, "es"),
            new Pelicula("Amor eterno", "Drama", 2022, "en"),
            new Pelicula("Risas sin fin", "Comedia", 2021, "fr"),
            new Pelicula("La batalla final", "Acción", 2023, "en"),
            new Pelicula("Historias cruzadas", "Drama", 2021, "es")
    );

    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }
}