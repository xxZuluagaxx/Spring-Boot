package com.primerApi.persistence;

import com.primerApi.entity.Fabricante;

import java.util.List;
import java.util.Optional;

public interface IFabricanteDAO {
    void crearFabricante(Fabricante fabricante);

    List<Fabricante> buscarFabricantes();

    Optional<Fabricante> buscarFabricante(Long id);

    void eliminarFabricante(Long id);
}
