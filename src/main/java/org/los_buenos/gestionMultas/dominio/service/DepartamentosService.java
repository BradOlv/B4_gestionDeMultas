package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;
import org.los_buenos.gestionMultas.dominio.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DepartamentosService {
    private DepartamentosRepository departamentosRepository;
    public List<DepartamentosDto> obtenerTodo(){return this.departamentosRepository.obtenerTodo();}
    public DepartamentosDto buscarPorId(Integer id){return this.departamentosRepository.buscarPorId(id);}
    public DepartamentosDto guardar(DepartamentosDto departamentosDto){return this.departamentosRepository.guardar(departamentosDto);}
    public void eliminar(Integer id){this.departamentosRepository.eliminar(id);}
}
