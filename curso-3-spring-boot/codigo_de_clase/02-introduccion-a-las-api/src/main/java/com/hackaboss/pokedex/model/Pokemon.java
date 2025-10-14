package com.hackaboss.pokedex.model;

public class Pokemon {
    private String nombre;
    private String tipo;
    private String descripcion;
    private int nivel;

    //Constructor
    public Pokemon(String nombre, String tipo, String descripcion, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivel() {
        return nivel;
    }
}
