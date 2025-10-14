package com.hackaboss.universidad.service;

import com.hackaboss.universidad.model.Profesor;
import com.hackaboss.universidad.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> listarTodos() {
        return profesorRepository.findAll();
    }

    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor buscarPorId(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}