package org.los_buenos.gestionMultas.dominio.repository;


import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;

import java.util.List;

public interface InspectoresRepository {
    List<InspectoresDto> obtenerTodo();
    InspectoresDto buscarPorId(Integer id);
    InspectoresDto guardar(InspectoresDto inspector);
    void eliminar(Integer id);
}
