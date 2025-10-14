package com.hackaboss.patron_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Plato {
    private String nombre;
    private double precio;
}