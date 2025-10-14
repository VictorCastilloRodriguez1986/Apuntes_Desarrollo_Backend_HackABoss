package com.hackaboss.demo_sec.controller;

import com.hackaboss.demo_sec.entity.Usuario;
import com.hackaboss.demo_sec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<String> registrar(@RequestBody Usuario usuario) {
        usuarioService.registrar(usuario.getUsername(), usuario.getPassword());
        return ResponseEntity.ok("Usuario registrado");
    }
}