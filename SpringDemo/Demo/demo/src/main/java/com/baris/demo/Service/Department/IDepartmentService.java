package com.baris.demo.Service.Department;

import com.baris.demo.DTO.Department.DepartmentRequestDTO;
import com.baris.demo.Model.Department;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentService {
    List<Department> getDepartment();
    Optional<Department> getDepartment(UUID id);
    Optional<Department> updateDepartment(UUID id, DepartmentRequestDTO dto);
    void deleteDepartment(UUID id);
    Department saveDepartment(DepartmentRequestDTO dto);
}
