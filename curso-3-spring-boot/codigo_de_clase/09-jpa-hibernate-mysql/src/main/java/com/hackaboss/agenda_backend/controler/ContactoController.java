package com.hackaboss.agenda_backend.controler;

import com.hackaboss.agenda_backend.model.Contacto;
import com.hackaboss.agenda_backend.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {
    @Autowired
    private ContactoService service;

    @GetMapping
    public List<Contacto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Contacto getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    @PostMapping
    public Contacto create(@RequestBody Contacto contacto) {
        return service.create(contacto);
    }

    @PutMapping("/{id}")
    public Contacto update(@PathVariable Long id, @RequestBody Contacto contacto) {
        return service.update(id, contacto).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!service.delete(id)) throw new RuntimeException("Contacto no encontrado");
    }
}