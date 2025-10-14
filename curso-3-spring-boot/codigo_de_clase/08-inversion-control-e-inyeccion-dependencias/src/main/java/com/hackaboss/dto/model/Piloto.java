package com.hackaboss.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Piloto {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;
}