package com.primerApi.persistence.impl;

import com.primerApi.entity.Fabricante;
import com.primerApi.persistence.IFabricanteDAO;
import com.primerApi.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FabricanteImplement implements IFabricanteDAO {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public void crearFabricante(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
    }

    @Override
    public List<Fabricante> buscarFabricantes() {
        return (List<Fabricante>) fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> buscarFabricante(Long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public void eliminarFabricante(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
