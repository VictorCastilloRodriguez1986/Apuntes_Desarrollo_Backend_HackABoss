package com.hackaboss.universidad.service;

import com.hackaboss.universidad.model.Asignatura;
import com.hackaboss.universidad.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> listarTodas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura buscarPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}