package com.sz.services;

import com.sz.dto.DepartmentDTO;
import com.sz.entities.Department;
import com.sz.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentDTO departmentDTO){
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .city(departmentDTO.getCity())
                .build();
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartment(Long id){
       return departmentRepository.findById(id);
    }
}

