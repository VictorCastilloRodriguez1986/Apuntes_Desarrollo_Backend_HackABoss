package com.hackaboss.demo_sec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class PostDTO {
    private String contenido;
    private LocalDateTime fechaCreacion;
    private String autorUsername;
}