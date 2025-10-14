package com.hackaboss.universidad.repository;

import com.hackaboss.universidad.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> { }