package org.los_buenos.gestionMultas.dominio.repository;

import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;

import java.util.List;

public interface DepartamentosRepository {
    List<DepartamentosDto> obtenerTodo();
    DepartamentosDto buscarPorId(Integer id);
    DepartamentosDto guardar(DepartamentosDto departamento);
    void eliminar(Integer id);
}
