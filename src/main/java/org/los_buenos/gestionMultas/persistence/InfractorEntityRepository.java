package org.los_buenos.gestionMultas.persistence;

import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import org.los_buenos.gestionMultas.dominio.repository.InfractorRepository;
import org.los_buenos.gestionMultas.persistence.crud.CrudInfractorRepository;
import org.los_buenos.gestionMultas.persistence.entity.InfractorEntity;
import org.los_buenos.gestionMultas.persistence.mapper.InfractorMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class InfractorEntityRepository implements InfractorRepository {
    private final CrudInfractorRepository crudInfractorRepository;
    private final InfractorMapper infractorMapper;

    public InfractorEntityRepository(CrudInfractorRepository crudInfractorRepository, InfractorMapper infractorMapper) {
        this.crudInfractorRepository = crudInfractorRepository;
        this.infractorMapper = infractorMapper;
    }

    @Override
    public List<InfractorDto> obtenerTodo() {
        return this.infractorMapper.toDto(this.crudInfractorRepository.findAll());
    }

    @Override
    public InfractorDto buscarPorId(Integer id) {
        Optional<InfractorEntity> infractor = this.crudInfractorRepository.findById(id);
        return infractor.map(infractorMapper::toDto).orElse(null);
    }

    @Override
    public InfractorDto guardar(InfractorDto infractorDto) {
        InfractorEntity infractor = this.infractorMapper.toEntity(infractorDto);
        return this.infractorMapper.toDto(this.crudInfractorRepository.save(infractor));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudInfractorRepository.deleteById(id);
    }
}