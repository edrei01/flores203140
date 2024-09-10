package com.example.FLORERIA203140.repository;

import com.example.FLORERIA203140.model.Catalogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends CrudRepository<Catalogo, Long>{
}
