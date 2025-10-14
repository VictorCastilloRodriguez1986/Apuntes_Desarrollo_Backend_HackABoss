package com.hackaboss.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/saludo")
    public ResponseEntity<String> saludo(Authentication authentication) {
        return ResponseEntity.ok("¡Hola " + authentication.getName() + "!");
    }

    @GetMapping("/productos")
    public ResponseEntity<String> productos() {
        return ResponseEntity.ok("Productos");
    }
}