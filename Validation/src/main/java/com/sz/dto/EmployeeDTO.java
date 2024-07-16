package com.sz.dto;

import com.sz.entities.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotBlank
    @NotNull(message = "El campo 'nombre' no puede ser nulo")
    private String name;
    private byte age;
    private double height;
    private boolean married;
    private LocalDate dateofBirth;
    private DepartmentDTO departmentDTO;
}
