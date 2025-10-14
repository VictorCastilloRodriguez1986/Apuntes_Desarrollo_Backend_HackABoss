package com.hackaboss.pokedex.controller;

import com.hackaboss.pokedex.model.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    @GetMapping("/bulbasaur")
    public Pokemon getBulbasaur(){
        return new Pokemon("Bulbasaur", "Planta/Veneno",
                "Tiene una semilla en el lomo desde que nace. La semilla crece con él.", 5);
    }

    @GetMapping("/charmander")
    public Pokemon getCharmander(){
        return new Pokemon("Charmaner", "Fuego",
                "La llama de su cola indica su salud. Si está fuerte, está sano.", 5);
    }

    @GetMapping("/squirtle")
    public Pokemon getSquirtle(){
        return new Pokemon("Squirtle", "Agua",
                "Lanza agua a presión por la boca. Se oculta en su caparazón cuando se siente amenazado.", 5);
    }
}