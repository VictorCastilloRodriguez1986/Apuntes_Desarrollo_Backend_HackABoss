package com.hackaboss.integration.repository;

import com.hackaboss.integration.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}