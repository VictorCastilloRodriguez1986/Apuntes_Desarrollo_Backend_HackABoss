package com.hackaboss.c6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AspiranteVillano {
    private int id;
    private String alias;
    private int nivelDeMaldad;
    private String especialidad;
    private boolean enProbatoria;
}