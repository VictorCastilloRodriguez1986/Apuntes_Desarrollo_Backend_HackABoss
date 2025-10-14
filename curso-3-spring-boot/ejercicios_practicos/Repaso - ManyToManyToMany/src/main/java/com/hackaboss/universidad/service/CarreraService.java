package com.hackaboss.universidad.service;

import com.hackaboss.universidad.model.Carrera;
import com.hackaboss.universidad.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> listarTodas() {
        return carreraRepository.findAll();
    }

    public Carrera guardar(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public Carrera buscarPorId(Long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        carreraRepository.deleteById(id);
    }
}