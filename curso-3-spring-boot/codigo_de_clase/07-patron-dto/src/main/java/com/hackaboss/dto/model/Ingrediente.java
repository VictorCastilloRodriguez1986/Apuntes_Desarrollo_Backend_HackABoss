package com.hackaboss.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ingrediente {
    private Long id;
    private String nombre;
    private boolean aptoCeliaco;
}