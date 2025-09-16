package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.PagosDto;
import org.los_buenos.gestionMultas.dominio.repository.PagosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PagosService {
    private final PagosRepository pagosRepository;

    public List<PagosDto> obtenerTodo() {
        return this.pagosRepository.obtenerTodo();
    }

    public PagosDto buscarPorId(Integer id) {
        return this.pagosRepository.buscarPorId(id);
    }

    public PagosDto guardar(PagosDto pago) {
        return this.pagosRepository.guardar(pago);
    }

    public void eliminar(Integer id) {
        this.pagosRepository.eliminar(id);
    }
}