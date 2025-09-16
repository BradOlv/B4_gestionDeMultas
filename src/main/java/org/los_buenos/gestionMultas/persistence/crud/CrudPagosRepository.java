package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.PagosEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPagosRepository extends CrudRepository<PagosEntity, Integer> {
}
