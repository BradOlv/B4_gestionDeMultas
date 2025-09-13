package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import org.los_buenos.gestionMultas.dominio.repository.VehiculoRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudVehiculoRepository;
import org.los_buenos.gestionMultas.persistence.entity.VehiculoEntity;
import org.los_buenos.gestionMultas.persistence.mapper.VehiculoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoEntityRepository implements VehiculoRepository {
    private final CrudVehiculoRepository crudVehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    public VehiculoEntityRepository(CrudVehiculoRepository crudVehiculoRepository, VehiculoMapper vehiculoMapper) {
        this.crudVehiculoRepository = crudVehiculoRepository;
        this.vehiculoMapper = vehiculoMapper;
    }

    @Override
    public List<VehiculoDto> obtenerTodo() {
        return this.vehiculoMapper.toDto(this.crudVehiculoRepository.findAll());
    }

    @Override
    public VehiculoDto buscarPorId(Integer id) {
        Optional<VehiculoEntity> vehiculo = this.crudVehiculoRepository.findById(id);
        return vehiculo.map(vehiculoMapper::toDto).orElse(null);
    }

    @Override
    public VehiculoDto guardar(VehiculoDto vehiculoDto) {
        VehiculoEntity vehiculo = this.vehiculoMapper.toEntity(vehiculoDto);
        return this.vehiculoMapper.toDto(this.crudVehiculoRepository.save(vehiculo));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudVehiculoRepository.deleteById(id);
    }
}