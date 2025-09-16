package org.los_buenos.gestionMultas.web.controller;


import jakarta.validation.Valid;
import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;
import org.los_buenos.gestionMultas.dominio.service.InspectoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/inspectores")
public class InspectoresController {
    //Creacion de controller de Inspectores
    private final InspectoresService inspectoresService;

    public InspectoresController(InspectoresService inspectoresService) {
        this.inspectoresService = inspectoresService;
    }

    @GetMapping
    public ResponseEntity<List<InspectoresDto>> obtenerTodo(){
        return new ResponseEntity<>(inspectoresService.obtenertodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectoresDto> obtenerInspectorPorId(@PathVariable Integer id){
        InspectoresDto inspectores = inspectoresService.buscarPorId(id);
        return inspectores != null ?
                new ResponseEntity<>(inspectores, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<InspectoresDto> guardarInspector(@Valid @RequestBody InspectoresDto inspectoresDto){
        InspectoresDto nuevoInspector = inspectoresService.guardar(inspectoresDto);
        return new ResponseEntity<>(nuevoInspector, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspectoresDto> actualizarInspector(@PathVariable Integer id, @Valid @RequestBody InspectoresDto inspectoresDto){
        InspectoresDto inspectoresExistente = inspectoresService.buscarPorId(id);
        if (inspectoresExistente != null ){
            InspectoresDto inspectoresActualizado = inspectoresService.guardar(new InspectoresDto(id, inspectoresDto.nombreInspector(),inspectoresDto.numeroPlaca()));
            return new ResponseEntity<>(inspectoresActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInspector(@PathVariable Integer id){
        InspectoresDto inspectores = inspectoresService.buscarPorId(id);
        if (inspectores != null){
            inspectoresService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
