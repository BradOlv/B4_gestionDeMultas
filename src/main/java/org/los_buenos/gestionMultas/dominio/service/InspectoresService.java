package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;
import org.los_buenos.gestionMultas.dominio.repository.InspectoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data

public class InspectoresService {
    private final InspectoresRepository inspectoresRepository;

    public List<InspectoresDto> obtenertodo(){
        return this.inspectoresRepository.obtenerTodo();
    }

    public InspectoresDto buscarPorId(Integer id){
        return this.inspectoresRepository.buscarPorId(id);
    }

    public InspectoresDto guardar(InspectoresDto inspectoresDto){
        return this.inspectoresRepository.guardar(inspectoresDto);
    }

    public void eliminar(Integer id){
        this.inspectoresRepository.eliminar(id);
    }

}
