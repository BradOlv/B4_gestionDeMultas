package org.los_buenos.gestionMultas.persistence.crud;

import org.los_buenos.gestionMultas.persistence.entity.MultasEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudMultasRepository extends CrudRepository<MultasEntity, Integer> {
    List<MultasEntity> findByVehiculo_IdVehiculo(Integer idVehiculo);
    List<MultasEntity> findByInfractor_IdInfractor(Integer idInfractor);

}
