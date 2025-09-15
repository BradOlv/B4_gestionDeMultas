package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.MultasDto;
import org.los_buenos.gestionMultas.dominio.repository.MultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class MultasService {
    private final MultasRepository multasRepository;
    public List<MultasDto>  obtenerTodo() { return this.multasRepository.obtenerTodo();}
    public MultasDto buscarPorId(Integer id) { return this.multasRepository.buscarPorId(id);}
    public MultasDto guardar(MultasDto multa) { return this.multasRepository.guardar(multa);}
    public void eliminar(Integer id) {this.multasRepository.eliminar(id);}
}
