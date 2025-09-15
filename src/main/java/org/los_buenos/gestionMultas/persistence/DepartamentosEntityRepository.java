package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;
import org.los_buenos.gestionMultas.dominio.repository.DepartamentosRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudDepartamentosRepository;
import org.los_buenos.gestionMultas.persistence.entity.DepartamentosEntity;
import org.los_buenos.gestionMultas.persistence.mapper.DepartamentosMapper;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentosEntityRepository implements DepartamentosRepository {
    private final CrudDepartamentosRepository crudDepartamentosRepository;
    private final DepartamentosMapper departamentosMapper;

    public DepartamentosEntityRepository(CrudDepartamentosRepository crudDepartamentosRepository, DepartamentosMapper departamentosMapper) {
        this.crudDepartamentosRepository = crudDepartamentosRepository;
        this.departamentosMapper = departamentosMapper;
    }
    @Override
    public List<DepartamentosDto> obtenerTodo() {
        return this.departamentosMapper.toDto(this.crudDepartamentosRepository.findAll());
    }

    @Override
    public DepartamentosDto buscarPorId(Integer id) {
        Optional<DepartamentosEntity> departamento = this.crudDepartamentosRepository.findById(id);
        return departamento.map(departamentosMapper::toDto).orElse(null);
    }

    @Override
    public DepartamentosDto guardar(DepartamentosDto departamentosDto) {
        DepartamentosEntity departamento = this.departamentosMapper.toEntity(departamentosDto);
        return this.departamentosMapper.toDto(this.crudDepartamentosRepository.save(departamento));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudDepartamentosRepository.deleteById(id);
    }
}
