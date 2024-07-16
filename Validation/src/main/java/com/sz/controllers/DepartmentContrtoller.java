package com.sz.controllers;

import com.sz.advices.NotFoundException;
import com.sz.dto.DepartmentDTO;
import com.sz.entities.Department;
import com.sz.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentContrtoller {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create-department")
    public ResponseEntity<Department> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find-department/{id}")
    public ResponseEntity<Department> findDepartment(@PathVariable Long id){
        Optional<Department> department = departmentService.findDepartment(id);
        if (!department.isPresent()){
            throw new NotFoundException("No se encontro el departamento");
        }
        Department department1 = department.get();
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }
}


