package com.hackaboss.dto.controller;

import com.hackaboss.dto.dto.PlatoDTO;
import com.hackaboss.dto.model.Plato;
import com.hackaboss.dto.service.PlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    //DI
    private final PlatoService platoService;
    public PlatoController(PlatoService platoService) {this.platoService = platoService;}

    @PostMapping
    public ResponseEntity<Plato> crearPlato(@RequestBody Plato plato) {
        return ResponseEntity.ok(platoService.guardarPlato(plato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDTO> obtenerPlato(@PathVariable Long id) {
        return ResponseEntity.ok(platoService.obtenerPlatoDTO(id));
    }
}