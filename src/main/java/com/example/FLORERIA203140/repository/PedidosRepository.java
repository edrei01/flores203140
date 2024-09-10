package com.example.FLORERIA203140.repository;

import com.example.FLORERIA203140.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends CrudRepository<Pedido, Long> {
}