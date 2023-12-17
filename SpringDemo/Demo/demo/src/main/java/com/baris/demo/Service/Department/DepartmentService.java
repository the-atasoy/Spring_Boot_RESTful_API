package com.baris.demo.Service.Department;

import com.baris.demo.DTO.Department.DepartmentRequestDTO;
import com.baris.demo.Model.Department;
import com.baris.demo.Repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository repository;
    @Override
    public List<Department> getDepartment() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> getDepartment(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Department updateDepartment(UUID id, DepartmentRequestDTO dto) {
        Department department = new Department(id, dto.getName());
        return repository.save(department);
    }

    @Override
    public void deleteDepartment(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Department saveDepartment(DepartmentRequestDTO dto) {
        Department department = new Department(dto.getName());
        return repository.save(department);
    }
}
