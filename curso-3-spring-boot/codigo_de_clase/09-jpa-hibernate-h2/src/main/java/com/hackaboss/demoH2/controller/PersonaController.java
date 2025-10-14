package com.hackaboss.demoH2.controller;

import com.hackaboss.demoH2.model.Persona;
import com.hackaboss.demoH2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaRepository repo;

    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Persona crear(@RequestBody Persona persona){
        return repo.save(persona);
    }
}
