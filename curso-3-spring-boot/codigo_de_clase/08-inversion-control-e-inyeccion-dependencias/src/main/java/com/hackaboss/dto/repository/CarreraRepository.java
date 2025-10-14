package com.hackaboss.dto.repository;

import com.hackaboss.dto.model.Equipo;
import com.hackaboss.dto.model.Piloto;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarreraRepository {
    private final List<Equipo> equipos = new ArrayList<>();
    private final List<Piloto> pilotos = new ArrayList<>();

    //Obtener equipos
    public List<Equipo> getEquipos() {
        return equipos;
    }

    //Obtener pilotos   
    public List<Piloto> getPilotos() {
        return pilotos;
    }

    //Agregar equipo
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    //Agregar piloto
    public void agregarPiloto(Piloto piloto) {
        pilotos.add(piloto);
    }
}