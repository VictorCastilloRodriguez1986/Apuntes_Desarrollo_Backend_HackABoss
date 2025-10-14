package com.hackaboss.topsecret.service;

import com.hackaboss.topsecret.model.Archivo;
import com.hackaboss.topsecret.repository.ArchivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivoService {

    private final ArchivoRepository repository;

    public ArchivoService(ArchivoRepository repository) {
        this.repository = repository;
    }

    public List<Archivo> verDesclasificados() {
        return repository.obtenerDesclasificados();
    }

    public List<Archivo> verClasificados() {
        return repository.obtenerClasificados();
    }

    public Archivo crear(Archivo archivo) {
        return repository.guardar(archivo);
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}