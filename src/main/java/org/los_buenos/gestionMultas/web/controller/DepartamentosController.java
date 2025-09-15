package org.los_buenos.gestionMultas.web.controller;

import jakarta.validation.Valid;
import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;
import org.los_buenos.gestionMultas.dominio.service.DepartamentosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/departamentos")
public class DepartamentosController {
    private final DepartamentosService departamentosService;

    public DepartamentosController(DepartamentosService departamentosService) {
        this.departamentosService = departamentosService;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentosDto>> obtenerTodos(){
        return new ResponseEntity<>(departamentosService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentosDto> obtenerDepartamentoPorId(@PathVariable Integer id){
        DepartamentosDto departamento = departamentosService.buscarPorId(id);
        return departamento != null ?
                new ResponseEntity<>(departamento, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DepartamentosDto> guardarDepartamento(@RequestBody @Valid DepartamentosDto departamentosDto){
        DepartamentosDto nuevoDepartamento = departamentosService.guardar(departamentosDto);
        return new ResponseEntity<>(nuevoDepartamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentosDto> actualizarDepartamento(@PathVariable Integer id, @Valid @RequestBody DepartamentosDto departamentosDto){
        DepartamentosDto departamentoExistente = departamentosService.buscarPorId(id);
        if(departamentoExistente != null){
            DepartamentosDto departamentoActualizado = departamentosService.guardar(new DepartamentosDto(id, departamentosDto.nombreDepartamento(), departamentosDto.municipio(), departamentosDto.direccionOficinas()));
            return new ResponseEntity<>(departamentoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Integer id){
        DepartamentosDto departamento =  departamentosService.buscarPorId(id);
        if(departamento != null){
            departamentosService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
