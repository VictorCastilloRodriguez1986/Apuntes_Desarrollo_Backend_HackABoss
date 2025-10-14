package com.hackaboss.c5.model;

import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private boolean eliminado;

    public Usuario(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}