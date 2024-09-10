package com.example.FLORERIA203140.controllers;

import com.example.FLORERIA203140.model.Catalogo;
import com.example.FLORERIA203140.services.CatalogoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    CatalogoServices catalogoServices;

    // Aca podemos ver la lista de los duenos
    @GetMapping()
    public ArrayList<Catalogo> obtenerCatalogo() {
        return catalogoServices.obtenerCatalogo();
    }

    // Aca podemos guardar los pedidos en este caso agregamos con el postman
    @CrossOrigin(origins = "http://localhost:3002/")
    @PostMapping()
    public Catalogo guardarCatalogo(@RequestBody Catalogo catalogo) {
        return this.catalogoServices.guardarCatalogo(catalogo);
    }

    // Aca buscamos el pedido por medio del ID
    @GetMapping(path = "/{id}")
    public Optional<Catalogo> obtenerCatalogoPorId(@PathVariable("id") Long id) {
        return this.catalogoServices.obtenerPorId(id);
    }

    // Aca eliminamos el pedido por medio del ID
    @CrossOrigin(origins = "http://localhost:3002/")
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.catalogoServices.eliminarCatalogo(id);
        if (ok) {
            return "Se eliminó el usuario con id: " + id;
        } else {
            return "No pudo eliminar el usuario con id: " + id;
        }
    }

    // Aca modificamos un pedido por medio del ID
    @CrossOrigin(origins = "http://localhost:3002/")
    @PutMapping(path = "/{id}")
    public Catalogo modificarCatalogo(@PathVariable("id") Long id, @RequestBody Catalogo catalogo) {
        return catalogoServices.modificarCatalogo(id, catalogo);
    }
}
