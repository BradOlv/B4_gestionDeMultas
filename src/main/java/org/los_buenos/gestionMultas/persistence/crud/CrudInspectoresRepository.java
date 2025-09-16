package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.InspectoresEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudInspectoresRepository extends CrudRepository<InspectoresEntity, Integer> {
}
