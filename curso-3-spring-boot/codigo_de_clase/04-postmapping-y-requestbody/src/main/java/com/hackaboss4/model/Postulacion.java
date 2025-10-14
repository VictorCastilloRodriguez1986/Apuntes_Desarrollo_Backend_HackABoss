package com.hackaboss4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Postulacion {
    private String nombrePersona;
    private int idAnimal;
    private String mensaje;
}