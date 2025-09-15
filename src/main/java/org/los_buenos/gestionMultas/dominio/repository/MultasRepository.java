package org.los_buenos.gestionMultas.dominio.repository;

import org.los_buenos.gestionMultas.dominio.dto.MultasDto;

import java.util.List;

public interface MultasRepository {
    List<MultasDto> obtenerTodo();
    MultasDto buscarPorId(Integer id);
    MultasDto guardar(MultasDto multa);
    void eliminar(Integer id);
}
