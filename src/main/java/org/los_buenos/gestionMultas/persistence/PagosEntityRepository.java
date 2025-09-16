package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.PagosDto;
import org.los_buenos.gestionMultas.dominio.repository.PagosRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudPagosRepository;
import org.los_buenos.gestionMultas.persistence.entity.PagosEntity;
import org.los_buenos.gestionMultas.persistence.mapper.PagosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PagosEntityRepository implements PagosRepository {
    private final CrudPagosRepository crudPagosRepository;
    private final PagosMapper pagosMapper;

    public PagosEntityRepository(CrudPagosRepository crudPagosRepository, PagosMapper pagosMapper) {
        this.crudPagosRepository = crudPagosRepository;
        this.pagosMapper = pagosMapper;
    }

    @Override
    public List<PagosDto> obtenerTodo() {
        return this.pagosMapper.toDto(this.crudPagosRepository.findAll());
    }

    @Override
    public PagosDto buscarPorId(Integer id) {
        Optional<PagosEntity> pago = this.crudPagosRepository.findById(id);
        return pago.map(pagosMapper::toDto).orElse(null);
    }

    @Override
    public PagosDto guardar(PagosDto pagosDto) {
        PagosEntity pago = this.pagosMapper.toEntity(pagosDto);
        return this.pagosMapper.toDto(this.crudPagosRepository.save(pago));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudPagosRepository.deleteById(id);
    }
}