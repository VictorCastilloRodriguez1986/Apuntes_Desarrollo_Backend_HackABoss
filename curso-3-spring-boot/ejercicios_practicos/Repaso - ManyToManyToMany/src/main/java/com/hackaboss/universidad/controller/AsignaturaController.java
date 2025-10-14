package com.hackaboss.universidad.controller;

import com.hackaboss.universidad.model.Asignatura;
import com.hackaboss.universidad.model.Carrera;
import com.hackaboss.universidad.service.AsignaturaService;
import com.hackaboss.universidad.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Asignatura> listar() {
        return asignaturaService.listarTodas();
    }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura asignatura) {
        return asignaturaService.guardar(asignatura);
    }

    @PostMapping("/{asignaturaId}/carreras/{carreraId}")
    public Asignatura asignarCarrera(@PathVariable Long asignaturaId, @PathVariable Long carreraId) {
        Asignatura asignatura = asignaturaService.buscarPorId(asignaturaId);
        Carrera carrera = carreraService.buscarPorId(carreraId);
        asignatura.getCarreras().add(carrera);
        return asignaturaService.guardar(asignatura);
    }
}