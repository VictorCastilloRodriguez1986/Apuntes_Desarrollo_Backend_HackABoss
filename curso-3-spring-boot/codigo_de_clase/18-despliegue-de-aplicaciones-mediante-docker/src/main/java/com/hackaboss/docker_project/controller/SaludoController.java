package com.hackaboss.docker_project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SaludoController {
    @GetMapping("/saludo/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "Hola " + nombre;
    }
}