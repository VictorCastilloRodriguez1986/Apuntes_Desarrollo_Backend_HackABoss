package com.hackaboss.patron_mvc.controller;

import com.hackaboss.patron_mvc.model.Pedido;
import com.hackaboss.patron_mvc.model.Plato;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/api")
    public class McDController {

        private List<Plato> menu = new ArrayList<>();
        private Map<Integer, Pedido> pedidos = new HashMap<>();
        private int pedidoIdCounter = 1;

        // 1. GET /menu
        @GetMapping("/menu")
        public List<Plato> obtenerMenu() {
            return menu;
        }

        // 2. GET /pedidos/{id}
        @GetMapping("/pedidos/{id}")
        public Object obtenerPedido(@PathVariable int id) {
            Pedido pedido = pedidos.get(id);
            if (pedido == null) {
                return "Pedido no encontrado";
            }
            return pedido;
        }

        // 3. POST /pedidos
        @PostMapping("/pedidos")
        public Pedido crearPedido(@RequestBody Pedido nuevoPedido) {
            nuevoPedido.setId(pedidoIdCounter);
            pedidos.put(pedidoIdCounter, nuevoPedido);
            pedidoIdCounter++;
            return nuevoPedido;
        }

        // 4. POST /menu
        @PostMapping("/menu")
        public Plato agregarPlato(@RequestBody Plato nuevoPlato) {
            menu.add(nuevoPlato);
            return nuevoPlato;
        }
}