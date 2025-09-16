package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;
import org.los_buenos.gestionMultas.dominio.repository.InspectoresRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudInspectoresRepository;
import org.los_buenos.gestionMultas.persistence.entity.InspectoresEntity;
import org.los_buenos.gestionMultas.persistence.mapper.InspectoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InspectoresEntityRepository implements InspectoresRepository {
    private final CrudInspectoresRepository crudInspectoresRepository;
    private final InspectoresMapper inspectoresMapper;

    public InspectoresEntityRepository(CrudInspectoresRepository crudInspectoresRepository, InspectoresMapper inspectoresMapper) {
        this.crudInspectoresRepository = crudInspectoresRepository;
        this.inspectoresMapper = inspectoresMapper;
    }

    @Override
    public List<InspectoresDto> obtenerTodo(){
        return this.inspectoresMapper.toDto(this.crudInspectoresRepository.findAll());
    }

    @Override
    public InspectoresDto buscarPorId(Integer id){
        Optional<InspectoresEntity> inspectores = this.crudInspectoresRepository.findById(id);
        return inspectores.map(inspectoresMapper::toDto).orElse(null);
    }

    @Override
    public InspectoresDto guardar(InspectoresDto inspectoresDto){
        InspectoresEntity inspectores = this.inspectoresMapper.toEntity(inspectoresDto);
        return this.inspectoresMapper.toDto(this.crudInspectoresRepository.save(inspectores));
    }

    @Override
    public void eliminar(Integer id){
        this.crudInspectoresRepository.deleteById(id);
    }
}
