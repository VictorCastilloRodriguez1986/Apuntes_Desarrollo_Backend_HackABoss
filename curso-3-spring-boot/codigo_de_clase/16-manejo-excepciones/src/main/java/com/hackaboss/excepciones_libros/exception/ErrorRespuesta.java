package com.hackaboss.excepciones_libros.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorRespuesta {
    private int status;
    private String mensaje;
    private long timestamp;
}