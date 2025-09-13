package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import org.los_buenos.gestionMultas.dominio.repository.InfractorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
public class InfractorService {
    private final InfractorRepository infractorRepository;

    public List<InfractorDto> obtenerTodo() {
        return this.infractorRepository.obtenerTodo();
    }

    public InfractorDto buscarPorId(Integer id) {
        return this.infractorRepository.buscarPorId(id);
    }

    public InfractorDto guardar(InfractorDto infractorDto) {
        return this.infractorRepository.guardar(infractorDto);
    }

    public void eliminar(Integer id) {
        this.infractorRepository.eliminar(id);
    }
}