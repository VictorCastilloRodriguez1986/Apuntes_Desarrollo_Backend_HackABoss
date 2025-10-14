package com.hackaboss.c5.service;

import com.hackaboss.c5.model.Usuario;
import com.hackaboss.c5.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // listarActivos
    public List<Usuario> listarActivos() {
        return repository.findAll().stream()
                .filter(u -> !u.isEliminado())
                .collect(Collectors.toList());
    }

    // eliminar
    public void eliminar(Long id) {
        repository.findById(id).ifPresent(u -> {
            u.setEliminado(true);
        });
    }

    // cambiarNombre
    public void cambiarNombre(Long id, String nuevoNombre) {
        repository.findById(id).ifPresent(u -> {
            u.setNombre(nuevoNombre);
        });
    }

    // restaurar
    public void restaurar(Long id) {
        repository.findById(id).ifPresent(u -> {
            u.setEliminado(false);
        });
    }
}