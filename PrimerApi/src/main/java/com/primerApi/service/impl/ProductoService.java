package com.primerApi.service.impl;

import com.primerApi.entity.Producto;
import com.primerApi.persistence.IProductoDAO;
import com.primerApi.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public void crearProducto(Producto producto) {
        productoDAO.crearProducto(producto);
    }

    @Override
    public List<Producto> buscarProductos() {
        return productoDAO.buscarProductos();
    }

    @Override
    public Optional<Producto> buscarProducto(Long id) {
        return productoDAO.buscarProducto(id);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDAO.eliminarProducto(id);
    }

}
