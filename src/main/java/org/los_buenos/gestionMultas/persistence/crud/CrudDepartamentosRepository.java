package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.DepartamentosEntity;
import org.springframework.data.repository.CrudRepository;


public interface CrudDepartamentosRepository extends CrudRepository<DepartamentosEntity, Integer> {
}
