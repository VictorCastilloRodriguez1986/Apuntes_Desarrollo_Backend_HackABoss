package com.hackaboss.topsecret.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Archivo {
    private Long id;
    private String titulo;
    private String contenido;
    private boolean desclasificado;
}
