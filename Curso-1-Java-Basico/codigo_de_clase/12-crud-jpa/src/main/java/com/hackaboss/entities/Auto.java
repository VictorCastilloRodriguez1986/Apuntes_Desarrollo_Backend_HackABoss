package com.hackaboss.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    public Auto() {}

    public Auto(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "[" + id + "] " + descripcion;
    }
}