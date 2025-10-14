package com.hackaboss.c6.service;

import com.hackaboss.c6.model.AspiranteVillano;
import com.hackaboss.c6.repository.VillanoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VillanoService {
    private final VillanoRepository repo;
    public VillanoService(VillanoRepository repo) {
        this.repo = repo;
    }

    //Registrar nuevo aspirante
    public void registrar(AspiranteVillano villano) {
        if (villano.getAlias().isBlank())
            throw new IllegalArgumentException("Alias no puede estar vacío");
        if (repo.aliasExiste(villano.getAlias()))
            throw new IllegalArgumentException("Alias ya existe");
        if (villano.getNivelDeMaldad() < 0 || villano.getNivelDeMaldad() > 10)
            throw new IllegalArgumentException("Nivel de maldad debe estar entre 0 y 10");
        repo.guardar(villano);
    }

    //Listar todos los aspirantes
    public List<AspiranteVillano> listar() {
        return repo.listarTodos();
    }

    //Buscar por ID

    //Actualizar datos del aspirante

    //Eliminar (expulsar del sindicato)

    /** BONUS */
    // Proximamente
}