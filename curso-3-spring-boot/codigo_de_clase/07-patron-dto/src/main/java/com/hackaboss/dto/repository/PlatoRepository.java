package com.hackaboss.dto.repository;

import com.hackaboss.dto.model.Plato;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PlatoRepository {
    private final Map<Long, Plato> platos = new HashMap<>();
    private long idCounter = 1;

    //Save
    public Plato save(Plato plato) {
        plato.setId(idCounter++);
        platos.put(plato.getId(), plato);
        return plato;
    }

    //FindById
    public Optional<Plato> findById(Long id) {
        return Optional.ofNullable(platos.get(id));
    }
}