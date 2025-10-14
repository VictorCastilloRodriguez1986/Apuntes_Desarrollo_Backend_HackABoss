package com.hackaboss.hackflix.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pelicula {
    private String titulo;
    private String genero;
    private int anio;
    private String idioma;
}