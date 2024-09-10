package com.example.FLORERIA203140.services;

import com.example.FLORERIA203140.model.Catalogo;
import com.example.FLORERIA203140.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class CatalogoServices {

    @Autowired
    CatalogoRepository catalogoRepository;

    // Mostrar los pedidos en la base
    public ArrayList<Catalogo> obtenerCatalogo() {
        return (ArrayList<Catalogo>) catalogoRepository.findAll();
    }

    // Guardar los pedidos en la base
    public Catalogo guardarCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    // Mostrar los pedidos por medio de su ID
    public Optional<Catalogo> obtenerPorId(Long id) {
        return catalogoRepository.findById(id);
    }

    // Eliminar los pedidos por medio de ID
    public boolean eliminarCatalogo(Long id) {
        try {
            catalogoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    // Modificar un pedido por medio de su ID
    public Catalogo modificarCatalogo(Long id, Catalogo catalogo) {
        Optional<Catalogo> catalogoExistente = catalogoRepository.findById(id);

        if (catalogoExistente.isPresent()) {
            Catalogo catalogoActualizado = catalogoExistente.get();
            // Aquí actualizamos los campos necesarios
            catalogoActualizado.setPrecio(catalogo.getPrecio());
            catalogoActualizado.setImagenUrl(catalogo.getImagenUrl());
            catalogoActualizado.setUnidades(catalogo.getUnidades());

            return catalogoRepository.save(catalogoActualizado);
        } else {
            return null;
        }
    }
}
