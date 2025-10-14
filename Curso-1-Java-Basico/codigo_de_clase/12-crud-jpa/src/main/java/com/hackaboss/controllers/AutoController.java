package com.hackaboss.controllers;

import com.hackaboss.entities.Auto;
import com.hackaboss.persistence.AutoJPA;
import java.util.List;

public class AutoController {
    AutoJPA autoJPA = new AutoJPA();

    public void agregarAuto(String descripcion) {
        autoJPA.agregarAuto(descripcion);
    }

    public List<Auto> listarAutos() {
        return autoJPA.listarAutos();
    }

    public Auto consultarAuto(Long id) {
        return autoJPA.consultarAuto(id);
    }

    public boolean actualizarAuto(Long id, String descripcion) {
        return autoJPA.actualizarAuto(id, descripcion);
    }

    public boolean eliminarAuto(Long id) {
        return autoJPA.eliminarAuto(id);
    }
}