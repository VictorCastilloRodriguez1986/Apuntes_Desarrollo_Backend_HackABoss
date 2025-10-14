package com.hackaboss.agenda_backend.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
