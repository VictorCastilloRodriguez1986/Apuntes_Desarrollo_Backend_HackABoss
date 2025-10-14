package com.hackaboss.c5.repository;

import com.hackaboss.c5.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository() {
        usuarios.add(new Usuario(1L, "Luis"));
        usuarios.add(new Usuario(2L, "Juan"));
        usuarios.add(new Usuario(3L, "Pablo"));
    }

    // Devolver todos los usuarios
    public List<Usuario> findAll() {
        return usuarios;
    }

    // Buscar usuario por id
    public Optional<Usuario> findById(Long id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}