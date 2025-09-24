package org.los_buenos.gestionMultas.dominio.service;

import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.*;
import org.los_buenos.gestionMultas.dominio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class MultasService {
    private final MultasRepository multasRepository;
    private final InfractorRepository infractorRepository;
    private final InspectoresRepository inspectorRepository;
    private final DepartamentosRepository departamentoRepository;
    private final VehiculoRepository vehiculoRepository;

    public List<MultasDto>  obtenerTodo() { return this.multasRepository.obtenerTodo();}
    public MultasDto buscarPorId(Integer id) { return this.multasRepository.buscarPorId(id);}
    public MultasDto guardar(MultasDto multa) { return this.multasRepository.guardar(multa);}
    public void eliminar(Integer id) {this.multasRepository.eliminar(id);}

    public List<InfractorDto> obtenerInfractores() { return infractorRepository.obtenerTodo(); }
    public List<InspectoresDto> obtenerInspectores() { return inspectorRepository.obtenerTodo(); }
    public List<DepartamentosDto> obtenerDepartamentos() { return departamentoRepository.obtenerTodo(); }
    public List<VehiculoDto> obtenerVehiculos() { return vehiculoRepository.obtenerTodo(); }
    public List<MultasDto> buscarPorIdVehiculo(Integer idVehiculo) {return multasRepository.buscarPorIdVehiculo(idVehiculo);}
    public List<MultasDto> buscarPorIdInfractor(Integer idInfractor) {return multasRepository.buscarPorIdInfractor(idInfractor);}
}
