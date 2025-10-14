package com.hackaboss.universidad.controller;

import com.hackaboss.universidad.model.Asignatura;
import com.hackaboss.universidad.model.Profesor;
import com.hackaboss.universidad.service.AsignaturaService;
import com.hackaboss.universidad.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<Profesor> listar() {
        return profesorService.listarTodos();
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return profesorService.guardar(profesor);
    }

    @PostMapping("/{profesorId}/asignaturas/{asignaturaId}")
    public Profesor asignarAsignatura(@PathVariable Long profesorId, @PathVariable Long asignaturaId) {
        Profesor profesor = profesorService.buscarPorId(profesorId);
        Asignatura asignatura = asignaturaService.buscarPorId(asignaturaId);
        profesor.getAsignaturas().add(asignatura);
        return profesorService.guardar(profesor);
    }
}