package com.primerApi.controller;

import com.primerApi.dto.ProductoDTO;
import com.primerApi.entity.Producto;
import com.primerApi.mapper.ProductoMapper;
import com.primerApi.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long id){
        Optional<Producto> productoOptional = productoService.buscarProducto(id);
        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            ProductoDTO productoDTO = ProductoMapper.INSTANCE.PRODUCTO_DTO(producto);
            return  ResponseEntity.ok(productoDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaProductos(){
        List<Producto> listaProductos = productoService.buscarProductos();
        List<ProductoDTO> listaProductosDTO = ProductoMapper.INSTANCE.PRODUCTO_DTO_LIST(listaProductos);

        return  ResponseEntity.ok(listaProductosDTO);
    }

    @PostMapping("/crear")
    public  ResponseEntity<?> crearProducto(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if (productoDTO.getName().isBlank() || productoDTO.getPrice() == null || productoDTO.getFabricante() == null){
            return ResponseEntity.badRequest().build();
        }
        Producto producto = ProductoMapper.INSTANCE.PRODUCTO(productoDTO);

        productoService.crearProducto(producto);
        return ResponseEntity.ok("Se creo el producto exitosamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        if (id != null){
            productoService.eliminarProducto(id);

            return ResponseEntity.ok("Producto eliminado correctamente");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        Optional<Producto> productoOptional = productoService.buscarProducto(id);
        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            ProductoMapper.INSTANCE.PRODUCTO_UPDATE(productoDTO, producto);
            productoService.crearProducto(producto);
            return  ResponseEntity.ok("Se edito el producto correctamente");
        }else {
            return ResponseEntity.badRequest().build();
        }

    }

}
