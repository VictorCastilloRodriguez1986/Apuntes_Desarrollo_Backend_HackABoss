package com.hackaboss4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal {
    private int id;
    private String nombre;
    private String tipo;
    private int edad;
    private String descripcion;
}