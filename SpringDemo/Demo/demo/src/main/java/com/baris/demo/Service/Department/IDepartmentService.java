package com.baris.demo.Service.Department;

import com.baris.demo.Model.Department;
import com.baris.demo.Model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentService {
    public List<Department> getDepartment();
    public Optional<Department> getDepartment(UUID id);
    public Department updateDepartment(UUID id, Department department);
    public void deleteDepartment(UUID id);
    public Department saveDepartment(Department department);
}
