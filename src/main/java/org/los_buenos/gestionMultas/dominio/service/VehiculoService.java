package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import org.los_buenos.gestionMultas.dominio.repository.VehiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoDto> obtenerTodo() {
        return this.vehiculoRepository.obtenerTodo();
    }

    public VehiculoDto buscarPorId(Integer id) {
        return this.vehiculoRepository.buscarPorId(id);
    }

    public VehiculoDto guardar(VehiculoDto vehiculoDto) {
        return this.vehiculoRepository.guardar(vehiculoDto);
    }

    public void eliminar(Integer id) {
        this.vehiculoRepository.eliminar(id);
    }
}
