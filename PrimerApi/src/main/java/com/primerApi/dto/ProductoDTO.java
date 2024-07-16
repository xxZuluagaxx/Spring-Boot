package com.primerApi.dto;

import com.primerApi.entity.Fabricante;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Fabricante fabricante;
}
