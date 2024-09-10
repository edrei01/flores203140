package com.example.FLORERIA203140.controllers;

import com.example.FLORERIA203140.model.Pedido;
import com.example.FLORERIA203140.services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    PedidosServices pedidosServices;

    // Aca podemos ver la lista de los duenos
    @GetMapping()
    public ArrayList<Pedido> obtenerPedidos() {
        return pedidosServices.obtenerPedidos();
    }

    // Aca podemos guardar los pedidos en este caso agregamos con el postman
    @CrossOrigin(origins = "http://localhost:3002/")
    @PostMapping()
    public Pedido guardarPedidos(@RequestBody Pedido pedido) {
        return this.pedidosServices.guardarPedidos(pedido);
    }

    // Aca buscamos el pedido por medio del ID
    @GetMapping(path = "/{id}")
    public Optional<Pedido> obtenerPedidosPorId(@PathVariable("id") Long id) {
        return this.pedidosServices.obtenerPorId(id);
    }

    // Aca eliminamos el pedido por medio del ID
    @CrossOrigin(origins = "http://localhost:3002/")
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.pedidosServices.eliminarPedidos(id);
        if (ok) {
            return "Se eliminó el usuario con id: " + id;
        } else {
            return "No pudo eliminar el usuario con id: " + id;
        }
    }

    // Aca modificamos un pedido por medio del ID
    @CrossOrigin(origins = "http://localhost:3002/")
    @PutMapping(path = "/{id}")
    public Pedido modificarPedido(@PathVariable("id") Long id, @RequestBody Pedido pedido) {
        return pedidosServices.modificarPedido(id, pedido);
    }
}
