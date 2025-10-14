package com.hackaboss.dto.controller;

import com.hackaboss.dto.dto.AsignacionPilotoDTO;
import com.hackaboss.dto.dto.PilotoDTO;
import com.hackaboss.dto.model.Equipo;
import com.hackaboss.dto.model.Piloto;
import com.hackaboss.dto.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarreraController {
    //DI
    @Autowired
    private CarreraService service;

    //Obtener equipos
    @GetMapping("equipos/traer")
    public List<Equipo> traerEquipos() {
        return service.traerEquipos();
    }

    //Obtener pilotos
    @GetMapping("pilotos/traer")
    public List<Piloto> traerPilotos() {
        return service.traerPilotos();
    }

    //Obtener equipo por nombre
    @GetMapping("equipos/traer/{nombre}")
    public Equipo traerEquipo(@PathVariable String nombre) {
        return service.traerEquipoPorNombre(nombre);
    }

    //Obtener pilotos por equipo
    @GetMapping("pilotos/traer/{nombreEquipo}")
    public List<PilotoDTO> traerPilotosPorEquipo(@PathVariable String nombreEquipo) {
        return service.traerPilotosPorEquipo(nombreEquipo);
    }

    //Agregar equipo
    @PostMapping("equipos/cargar")
    public ResponseEntity<String> cargarEquipo(@RequestBody Equipo equipo) {
        service.agregarEquipo(equipo);
        return ResponseEntity.ok("Equipo cargado correctamente");
    }

    //Agregar piloto
    @PostMapping("pilotos/cargar")
    public ResponseEntity<String> cargarPiloto(@RequestBody Piloto piloto) {
        service.agregarPiloto(piloto);
        return ResponseEntity.ok("Piloto cargado correctamente");
    }

    /**BONUS*/
    //Asignar piloto
    @PostMapping("equipos/asignar-piloto")
    public ResponseEntity<String> asignarPiloto(@RequestBody AsignacionPilotoDTO dto) {
        String resultado = service.asignarPilotoAEquipo(dto.getIdPiloto(), dto.getNombreEquipo());
        return ResponseEntity.ok(resultado);
    }
}