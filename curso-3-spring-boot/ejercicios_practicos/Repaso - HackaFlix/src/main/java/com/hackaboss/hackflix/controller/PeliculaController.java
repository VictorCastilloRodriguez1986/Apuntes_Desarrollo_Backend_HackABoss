package com.hackaboss.hackflix.controller;

import com.hackaboss.hackflix.model.Pelicula;
import com.hackaboss.hackflix.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public List<Pelicula> obtenerPeliculas(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) String idioma
    ) {
        return service.filtrarPeliculas(genero, anio, idioma);
    }
}
