package com.primerApi.mapper;

import com.primerApi.dto.ProductoDTO;
import com.primerApi.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FabricanteMapper.class})
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO PRODUCTO_DTO(Producto producto);
    List<ProductoDTO> PRODUCTO_DTO_LIST(List<Producto> listaProductos);

    Producto PRODUCTO(ProductoDTO productoDTO);
    List<Producto> PRODUCTO_LIST(List<ProductoDTO> listaProductosDTO);

    @Mapping(target = "id", ignore = true)
    void PRODUCTO_UPDATE(ProductoDTO productoDTO, @MappingTarget Producto producto);

}
