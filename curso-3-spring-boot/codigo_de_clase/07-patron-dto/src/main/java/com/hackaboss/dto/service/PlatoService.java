package com.hackaboss.dto.service;

import com.hackaboss.dto.dto.PlatoDTO;
import com.hackaboss.dto.model.Ingrediente;
import com.hackaboss.dto.model.Plato;
import com.hackaboss.dto.repository.PlatoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatoService {
    //DI
    private final PlatoRepository platoRepository;
    public PlatoService(PlatoRepository platoRepository) {this.platoRepository = platoRepository;}

    //Guardar
    public Plato guardarPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    //Obtener
    public PlatoDTO obtenerPlatoDTO(Long id) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));


        boolean esApto = plato.getIngredientes().stream()
                .allMatch(Ingrediente::isAptoCeliaco);

        return new PlatoDTO(plato.getNombre(), esApto);
    }
}