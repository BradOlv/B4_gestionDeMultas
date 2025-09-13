package org.los_buenos.gestionMultas.dominio.repository;

import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import java.util.List;

public interface VehiculoRepository {
    List<VehiculoDto> obtenerTodo();
    VehiculoDto buscarPorId(Integer id);
    VehiculoDto guardar(VehiculoDto vehiculo);
    void eliminar(Integer id);
}