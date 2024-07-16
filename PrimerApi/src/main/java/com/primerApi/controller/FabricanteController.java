package com.primerApi.controller;

import com.primerApi.dto.FabricanteDTO;

import com.primerApi.entity.Fabricante;

import com.primerApi.mapper.FabricanteMapper;

import com.primerApi.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    @Autowired
    private IFabricanteService fabricanteService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarFabricante(@PathVariable Long id) {
        Optional<Fabricante> fabricanteOptional = fabricanteService.buscarFabricante(id);
        if (fabricanteOptional.isPresent()) {
            Fabricante fabricante = fabricanteOptional.get();
            FabricanteDTO fabricanteDTO = FabricanteMapper.INSTANCE.FABRICANTE_DTO(fabricante);
            return ResponseEntity.ok(fabricanteDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaFabricantes() {
        List<Fabricante> fabricanteList = fabricanteService.buscarFabricantes();
        List<FabricanteDTO> fabricanteDTOList = FabricanteMapper.INSTANCE.FABRICANTE_DTO_LIST(fabricanteList);

        return ResponseEntity.ok(fabricanteDTOList);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearFabricante(@RequestBody FabricanteDTO fabricanteDTO) throws URISyntaxException {
        if (fabricanteDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Fabricante fabricante = FabricanteMapper.INSTANCE.FABRICANTE(fabricanteDTO);

        fabricanteService.crearFabricante(fabricante);
        return ResponseEntity.ok("Se creo el fabricante exitosamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarFabricante(@PathVariable Long id) {
        if (id != null) {
            fabricanteService.eliminarFabricante(id);

            return ResponseEntity.ok("Fabricante eliminado correctamente");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        Optional<Fabricante> fabricanteOptional = fabricanteService.buscarFabricante(id);
        if (fabricanteOptional.isPresent()) {
            Fabricante fabricante = fabricanteOptional.get();
            FabricanteMapper.INSTANCE.FABRICANTE_UPDATE(fabricanteDTO, fabricante);
            fabricanteService.crearFabricante(fabricante);
            return ResponseEntity.ok("Se edito el fabricante correctamente");
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}

