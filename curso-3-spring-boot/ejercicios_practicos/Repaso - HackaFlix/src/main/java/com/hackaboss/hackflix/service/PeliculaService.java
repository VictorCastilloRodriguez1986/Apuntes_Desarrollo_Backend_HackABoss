package com.hackaboss.hackflix.service;

import com.hackaboss.hackflix.model.Pelicula;
import com.hackaboss.hackflix.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository repository;

    public List<Pelicula> filtrarPeliculas(String genero, Integer anio, String idioma) {
        return repository.obtenerTodas().stream()
                .filter(p -> genero == null || p.getGenero().equalsIgnoreCase(genero))
                .filter(p -> anio == null || p.getAnio() == anio)
                .filter(p -> idioma == null || p.getIdioma().equalsIgnoreCase(idioma))
                .toList();
    }
}