package com.example.FLORERIA203140.services;

import com.example.FLORERIA203140.model.Pedido;
import com.example.FLORERIA203140.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PedidosServices {

    @Autowired
    PedidosRepository pedidosRepository;

    // Mostrar los pedidos en la base
    public ArrayList<Pedido> obtenerPedidos() {
        return (ArrayList<Pedido>) pedidosRepository.findAll();
    }

    // Guardar los pedidos en la base
    public Pedido guardarPedidos(Pedido pedido) {
        return pedidosRepository.save(pedido);
    }

    // Mostrar los pedidos por medio de su ID
    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    // Eliminar los pedidos por medio de ID
    public boolean eliminarPedidos(Long id) {
        try {
            pedidosRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    // Modificar un pedido por medio de su ID
    public Pedido modificarPedido(Long id, Pedido pedido) {
        Optional<Pedido> pedidoExistente = pedidosRepository.findById(id);

        if (pedidoExistente.isPresent()) {
            Pedido pedidoActualizado = pedidoExistente.get();
            // Aquí actualizamos los campos necesarios
            pedidoActualizado.setFlorRequerida(pedido.getFlorRequerida()); // Ejemplo de campo a actualizar
            pedidoActualizado.setFechaEntrega(pedido.getFechaEntrega()); // Otro campo a actualizar

            return pedidosRepository.save(pedidoActualizado);
        } else {
            return null;
        }
    }
}
