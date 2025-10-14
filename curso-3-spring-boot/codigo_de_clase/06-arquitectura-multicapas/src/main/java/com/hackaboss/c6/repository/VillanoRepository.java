package com.hackaboss.c6.repository;

import com.hackaboss.c6.model.AspiranteVillano;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class VillanoRepository {
    private final Map<Integer, AspiranteVillano> base = new HashMap<>();

    //Registrar nuevo aspirante
    public void guardar(AspiranteVillano villano) {
        base.put(villano.getId(), villano);
    }

    //Listar todos los aspirantes
    public List<AspiranteVillano> listarTodos() {
        return new ArrayList<>(base.values());
    }

    //Buscar por ID

    //Actualizar datos del aspirante

    //Eliminar (expulsar del sindicato)

    /** BONUS */
    // Proximamente

    public boolean aliasExiste(String alias) {
        return base.values().stream().anyMatch(v -> v.getAlias().equalsIgnoreCase(alias));
    }
}