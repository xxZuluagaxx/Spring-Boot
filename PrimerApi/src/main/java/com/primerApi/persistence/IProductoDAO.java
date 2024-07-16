package com.primerApi.persistence;

import com.primerApi.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoDAO {

    void crearProducto(Producto producto);

    List<Producto> buscarProductos();

    Optional<Producto> buscarProducto(Long id);

    void eliminarProducto(Long id);

}
