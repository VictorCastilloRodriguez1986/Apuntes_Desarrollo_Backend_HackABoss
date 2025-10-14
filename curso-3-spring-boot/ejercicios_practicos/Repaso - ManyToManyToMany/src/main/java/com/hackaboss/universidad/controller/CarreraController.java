package com.hackaboss.universidad.controller;

import com.hackaboss.universidad.model.Carrera;
import com.hackaboss.universidad.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> listar() {
        return carreraService.listarTodas();
    }

    @PostMapping
    public Carrera crear(@RequestBody Carrera carrera) {
        return carreraService.guardar(carrera);
    }
}