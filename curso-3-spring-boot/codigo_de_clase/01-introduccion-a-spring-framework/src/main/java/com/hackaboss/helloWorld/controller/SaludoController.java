package com.hackaboss.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @GetMapping
    public String decirHola(){
        return "Hola mundo!";
    }
}