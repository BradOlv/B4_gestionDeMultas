package org.los_buenos.gestionMultas.dominio.repository;

import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import java.util.List;

public interface InfractorRepository {
    List<InfractorDto> obtenerTodo();
    InfractorDto buscarPorId(Integer id);
    InfractorDto guardar(InfractorDto infractor);
    void eliminar(Integer id);
}