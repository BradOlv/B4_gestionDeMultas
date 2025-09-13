package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.VehiculoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudVehiculoRepository extends CrudRepository<VehiculoEntity, Integer> {
}