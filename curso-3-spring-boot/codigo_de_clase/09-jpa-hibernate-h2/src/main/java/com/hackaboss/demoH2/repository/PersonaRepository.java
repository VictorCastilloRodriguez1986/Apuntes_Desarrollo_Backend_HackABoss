package com.hackaboss.demoH2.repository;

import com.hackaboss.demoH2.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {}