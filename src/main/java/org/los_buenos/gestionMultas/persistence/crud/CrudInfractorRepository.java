package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.InfractorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudInfractorRepository extends CrudRepository<InfractorEntity, Integer> {
}