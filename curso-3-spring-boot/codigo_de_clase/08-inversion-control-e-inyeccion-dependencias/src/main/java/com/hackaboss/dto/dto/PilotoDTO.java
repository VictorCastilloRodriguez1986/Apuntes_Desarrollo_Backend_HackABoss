package com.hackaboss.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PilotoDTO {
    private String nombre;
    private String apellido;
    private String equipo;
}