package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.MultasEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMultasRepository extends CrudRepository<MultasEntity, Integer> {
}
