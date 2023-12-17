package com.baris.demo.Controller;

import com.baris.demo.DTO.Department.DepartmentRequestDTO;
import com.baris.demo.Model.Department;
import com.baris.demo.Model.Employee;
import com.baris.demo.Service.Department.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @GetMapping("/getDepartment")
    public List<Department> getDepartment() {
        return service.getDepartment();
    }

    @GetMapping("/getDepartment/{id}")
    public Optional<Department> getDepartment(@PathVariable UUID id){
        return service.getDepartment(id);
    }

    @DeleteMapping("/deleteDepartment")
    public void deleteDepartment(@RequestParam UUID id) {
        service.deleteDepartment(id);
    }

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody DepartmentRequestDTO dto){
        return service.saveDepartment(dto);
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable UUID id, @RequestBody DepartmentRequestDTO dto){
        return service.updateDepartment(id, dto);
    }
}
