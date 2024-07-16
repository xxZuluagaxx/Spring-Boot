package com.primerApi.dto;

import com.primerApi.entity.Producto;
import jakarta.persistence.GeneratedValue;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FabricanteDTO {

    private Long id;

    private String name;

    private List<Producto> listaProductos = new ArrayList<>();
}
