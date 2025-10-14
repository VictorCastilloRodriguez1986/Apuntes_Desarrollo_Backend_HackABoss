package com.hackaboss.agenda_backend.repository;

import com.hackaboss.agenda_backend.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {}