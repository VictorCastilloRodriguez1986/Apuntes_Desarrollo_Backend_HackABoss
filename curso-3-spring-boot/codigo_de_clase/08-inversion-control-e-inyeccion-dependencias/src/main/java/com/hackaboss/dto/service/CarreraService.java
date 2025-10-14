package com.hackaboss.dto.service;

import com.hackaboss.dto.dto.PilotoDTO;
import com.hackaboss.dto.model.Equipo;
import com.hackaboss.dto.model.Piloto;
import com.hackaboss.dto.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreraService {
    //DI
    @Autowired
    private CarreraRepository repository;

    //Obtener equipos
    public List<Equipo> traerEquipos() {
        return repository.getEquipos();
    }

    //Obtener pilotos
    public List<Piloto> traerPilotos() {
        return repository.getPilotos();
    }

    //Obtener equipo por nombre
    public Equipo traerEquipoPorNombre(String nombre) {
        return repository.getEquipos().stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    //Obtener pilotos por equipo
    public List<PilotoDTO> traerPilotosPorEquipo(String nombreEquipo) {
        Equipo equipo = traerEquipoPorNombre(nombreEquipo);
        if (equipo == null) return Collections.emptyList();

        return equipo.getPilotos().stream()
                .map(p -> new PilotoDTO(p.getNombre(), p.getApellido(), equipo.getNombre()))
                .collect(Collectors.toList());
    }

    //Agregar equipo
    public void agregarEquipo(Equipo equipo) {
        repository.agregarEquipo(equipo);
    }

    //Agregar piloto
    public void agregarPiloto(Piloto piloto) {
        repository.agregarPiloto(piloto);
    }

    /**BONUS*/
    //Asignar piloto
    public String asignarPilotoAEquipo(Long idPiloto, String nombreEquipo) {
        Piloto piloto = repository.getPilotos().stream()
                .filter(p -> p.getId().equals(idPiloto))
                .findFirst()
                .orElse(null);


        Equipo equipo = traerEquipoPorNombre(nombreEquipo);
        if (piloto == null || equipo == null) {
            return "Piloto o equipo no encontrado";
        }

        if (!piloto.getNacionalidad().equalsIgnoreCase(equipo.getPais())) {
            return "No se puede asignar: nacionalidad del piloto y país del equipo no coinciden";
        }

        equipo.getPilotos().add(piloto);
        return "Piloto asignado correctamente al equipo";
    }
}