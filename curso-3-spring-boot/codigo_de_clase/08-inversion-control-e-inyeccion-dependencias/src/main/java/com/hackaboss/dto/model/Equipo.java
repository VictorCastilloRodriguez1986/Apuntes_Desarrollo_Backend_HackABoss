package com.hackaboss.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Equipo {
    private Long id;
    private String nombre;
    private String pais;
    private List<Piloto> pilotos = new ArrayList<>();
}