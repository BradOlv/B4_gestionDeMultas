package org.los_buenos.gestionMultas.dominio.repository;

import org.los_buenos.gestionMultas.dominio.dto.PagosDto;

import java.util.List;

public interface PagosRepository {
    List<PagosDto> obtenerTodo();
    PagosDto buscarPorId(Integer id);
    PagosDto guardar(PagosDto pago);
    void eliminar(Integer id);
}