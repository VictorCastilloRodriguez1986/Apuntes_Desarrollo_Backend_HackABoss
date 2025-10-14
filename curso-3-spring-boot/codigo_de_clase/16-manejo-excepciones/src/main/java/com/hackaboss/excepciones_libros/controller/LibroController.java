package com.hackaboss.excepciones_libros.controller;

import com.hackaboss.excepciones_libros.model.Libro;
import com.hackaboss.excepciones_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService servicio;

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }
}