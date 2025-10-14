package com.hackaboss.c5.controller;

import com.hackaboss.c5.model.Usuario;
import com.hackaboss.c5.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Listar Usuarios Activos
    @GetMapping
    public List<Usuario> listarActivos() {
        return service.listarActivos();
    }

    // Borrado Lógico
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Actualizar nombre
    @PutMapping("/{id}/nombre/{nuevoNombre}")
    public void cambiarNombre(@PathVariable Long id, @PathVariable String nuevoNombre) {
        service.cambiarNombre(id, nuevoNombre);
    }

    // Restaurar un Usuario eliminado
    @PatchMapping("/restaurar/{id}")
    public void restaurar(@PathVariable Long id) {
        service.restaurar(id);
    }
}