package com.hackaboss.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class Plato {
    private Long id;
    private String nombre;
    private double precio;
    private List<Ingrediente> ingredientes;
}