package com.sz.services;

import com.sz.dto.EmployeeDTO;
import com.sz.entities.Department;
import com.sz.entities.Employee;
import com.sz.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .age(employeeDTO.getAge())
                .height(employeeDTO.getHeight())
                .married(employeeDTO.isMarried())
                .dateofBirth(employeeDTO.getDateofBirth())
                .department(Department.builder()
                        .name(employeeDTO.getDepartmentDTO().getName())
                        .city(employeeDTO.getDepartmentDTO().getCity())
                        .build())
                .build();
        return employeeRepository.save(employee);
    }
}
