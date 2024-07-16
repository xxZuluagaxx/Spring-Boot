package com.primerApi.mapper;

import com.primerApi.dto.FabricanteDTO;
import com.primerApi.entity.Fabricante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ProductoMapper.class})
public interface FabricanteMapper {

    FabricanteMapper INSTANCE = Mappers.getMapper(FabricanteMapper.class);

    FabricanteDTO FABRICANTE_DTO(Fabricante fabricante);
    List<FabricanteDTO> FABRICANTE_DTO_LIST(List<Fabricante> listaFabricantes);

    Fabricante FABRICANTE(FabricanteDTO fabricanteDTO);
    List<Fabricante> FABRICANTE_LIST(List<FabricanteDTO> fabricanteDTOList);

    @Mapping(target = "listaProductos", ignore = true)
    @Mapping(target = "id", ignore = true)
    void FABRICANTE_UPDATE(FabricanteDTO fabricanteDTO, @MappingTarget Fabricante fabricante);
}
