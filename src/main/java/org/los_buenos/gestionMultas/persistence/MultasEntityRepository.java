package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.MultasDto;
import org.los_buenos.gestionMultas.dominio.repository.MultasRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudMultasRepository;
import org.los_buenos.gestionMultas.persistence.entity.MultasEntity;
import org.los_buenos.gestionMultas.persistence.mapper.MultasMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MultasEntityRepository implements MultasRepository {
    private final CrudMultasRepository crudMultasRepository;
    private final MultasMapper multasMapper;

    public MultasEntityRepository(CrudMultasRepository crudMultasRepository, MultasMapper multasMapper) {
        this.crudMultasRepository = crudMultasRepository;
        this.multasMapper = multasMapper;
    }

    @Override
    public List<MultasDto> obtenerTodo() {
        return this.multasMapper.toDto(this.crudMultasRepository.findAll());
    }

    @Override
    public MultasDto buscarPorId(Integer id) {
        Optional<MultasEntity> multa = this.crudMultasRepository.findById(id);
        return multa.map(multasMapper::toDto).orElse(null);
    }

    @Override
    public List<MultasDto> buscarPorIdVehiculo(Integer idVehiculo) {
        List<MultasEntity> multas = crudMultasRepository.findByVehiculo_IdVehiculo(idVehiculo);
        return multasMapper.toDto(multas);
    }

    @Override
    public List<MultasDto> buscarPorIdInfractor(Integer idInfractor) {
        List<MultasEntity> multas = crudMultasRepository.findByInfractor_IdInfractor(idInfractor);
        return multasMapper.toDto(multas);
    }

    @Override
    public MultasDto guardar(MultasDto multasDto) {
        MultasEntity multa = this.multasMapper.toEntity(multasDto);
        return this.multasMapper.toDto(this.crudMultasRepository.save(multa));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudMultasRepository.deleteById(id);
    }
}
