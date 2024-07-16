package com.primerApi.service.impl;

import com.primerApi.entity.Fabricante;
import com.primerApi.persistence.IFabricanteDAO;
import com.primerApi.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService implements IFabricanteService {

    @Autowired
    private IFabricanteDAO fabricanteDAO;

    @Override
    public void crearFabricante(Fabricante fabricante) {
        fabricanteDAO.crearFabricante(fabricante);
    }

    @Override
    public List<Fabricante> buscarFabricantes() {
        return fabricanteDAO.buscarFabricantes();
    }

    @Override
    public Optional<Fabricante> buscarFabricante(Long id) {
        return fabricanteDAO.buscarFabricante(id);
    }

    @Override
    public void eliminarFabricante(Long id) {
        fabricanteDAO.eliminarFabricante(id);
    }
}
