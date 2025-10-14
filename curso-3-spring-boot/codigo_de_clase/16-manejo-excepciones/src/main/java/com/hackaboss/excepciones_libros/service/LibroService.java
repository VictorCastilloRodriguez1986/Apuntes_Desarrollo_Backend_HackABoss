package com.hackaboss.excepciones_libros.service;

import com.hackaboss.excepciones_libros.exception.LibroNoEncontradoException;
import com.hackaboss.excepciones_libros.model.Libro;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class LibroService {
    private final Map<Integer, Libro> libros = Map.of(
            1, new Libro(1, "El Quijote"),
            2, new Libro(2, "Cien años de soledad")
    );

    public Libro obtenerPorId(int id) {
        if (!libros.containsKey(id)) {
            throw new LibroNoEncontradoException("Libro con ID " + id + " no encontrado.");
        }
        return libros.get(id);
    }
}