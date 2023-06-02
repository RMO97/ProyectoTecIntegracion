package com.adopcion.FormularioAdopcion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iAdopcion extends CrudRepository<Adopcion, Integer> {

    
}
