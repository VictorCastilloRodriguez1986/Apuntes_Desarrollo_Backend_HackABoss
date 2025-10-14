package com.hackaboss4.controller;

import com.hackaboss4.model.Animal;
import com.hackaboss4.model.Postulacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/")
public class AdoptaController {

    private List<Animal> animales = new ArrayList<>();
    private List<Postulacion> postulaciones = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping("/animales")
    public ResponseEntity<List<Animal>> getAnimales() {
        return ResponseEntity.ok(animales);
    }

    @PostMapping("/animales")
    public ResponseEntity<String> agregarAnimal(@RequestBody Animal animal) {
        animal.setId(idCounter++);
        animales.add(animal);
        return ResponseEntity.ok("Animal agregado con ID: " + animal.getId());
    }

    @PostMapping("/adopciones")
    public ResponseEntity<String> postularAdopcion(@RequestBody Postulacion postulacion) {
        Optional<Animal> animalOpt = animales.stream()
                .filter(a -> a.getId() == postulacion.getIdAnimal())
                .findFirst();

        if (animalOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Animal no encontrado");
        }

        postulaciones.add(postulacion);
        return ResponseEntity.ok("¡Gracias " + postulacion.getNombrePersona() +
                "! Has postulado para adoptar a " + animalOpt.get().getNombre());
    }

    @GetMapping("/adopciones")
    public ResponseEntity<List<Postulacion>> getPostulaciones() {
        return ResponseEntity.ok(postulaciones);
    }

    //BONUS
    @GetMapping("/animales/random")
    public ResponseEntity<Animal> getAnimalAleatorio() {
        if (animales.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Random rand = new Random();
        Animal elegido = animales.get(rand.nextInt(animales.size()));
        return ResponseEntity.ok(elegido);
    }
}