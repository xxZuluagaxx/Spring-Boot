package com.sz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @NotBlank
    @NotNull
    private String name;
    @NotNull(message = "El campo ciudad no puede ser nulo")
    private String city;
    private List<EmployeeDTO> employeeDTOList;
}
