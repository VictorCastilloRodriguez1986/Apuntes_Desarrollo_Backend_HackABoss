package com.hackaboss.c6.controller;


import com.hackaboss.c6.model.AspiranteVillano;
import com.hackaboss.c6.service.VillanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/villanos")
public class VillanoController {
    private final VillanoService service;
    public VillanoController(VillanoService service) {
        this.service = service;
    }

    //Registrar nuevo aspirante
    @PostMapping
    public ResponseEntity<String> crear(@RequestBody AspiranteVillano villano) {
        service.registrar(villano);
        return ResponseEntity.ok("Villano registrado");
    }

    //Listar todos los aspirantes
    @GetMapping
    public List<AspiranteVillano> listar() {
        return service.listar();
    }

    //Buscar por ID

    //Actualizar datos del aspirante

    //Eliminar (expulsar del sindicato)

    /** BONUS */
    //Proximamente...
}