package com.primerApi.persistence.impl;

import com.primerApi.entity.Producto;
import com.primerApi.persistence.IProductoDAO;
import com.primerApi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoImplement implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> buscarProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

}
