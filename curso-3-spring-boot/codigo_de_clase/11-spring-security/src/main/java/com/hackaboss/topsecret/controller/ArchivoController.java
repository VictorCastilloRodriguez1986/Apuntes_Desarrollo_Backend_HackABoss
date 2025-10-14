package com.hackaboss.topsecret.controller;

import com.hackaboss.topsecret.model.Archivo;
import com.hackaboss.topsecret.service.ArchivoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/archivos")
public class ArchivoController {

    private final ArchivoService service;

    public ArchivoController(ArchivoService service) {
        this.service = service;
    }

    @GetMapping("/desclasificados")
    public List<Archivo> verDesclasificados() {
        return service.verDesclasificados();
    }

    @GetMapping("/clasificados")
    public List<Archivo> verClasificados() {
        return service.verClasificados();
    }

    @PostMapping
    public Archivo crear(@RequestBody Archivo archivo) {
        return service.crear(archivo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}