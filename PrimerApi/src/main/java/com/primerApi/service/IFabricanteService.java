package com.primerApi.service;

import com.primerApi.entity.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IFabricanteService {

    void crearFabricante(Fabricante fabricante);

    List<Fabricante> buscarFabricantes();

    Optional<Fabricante> buscarFabricante(Long id);

    void eliminarFabricante(Long id);
}
