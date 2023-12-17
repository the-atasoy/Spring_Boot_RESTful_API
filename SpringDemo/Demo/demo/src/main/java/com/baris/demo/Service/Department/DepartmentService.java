package com.baris.demo.Service.Department;

import com.baris.demo.DTO.Department.DepartmentRequestDTO;
import com.baris.demo.Model.Department;
import com.baris.demo.Repository.IDepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public List<Department> getDepartment() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> getDepartment(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Department> updateDepartment(UUID id, DepartmentRequestDTO dto) {
        Optional<Department> departmentOptional = repository.findById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            if (dto.getName() != null) department.setName(Optional.of(dto.getName()));
            return Optional.of(repository.save(department));
        } else return Optional.empty();
    }


    @Override
    public void deleteDepartment(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Department saveDepartment(DepartmentRequestDTO dto) {
        Department department = mapper.map(dto, Department.class);
        return repository.save(department);
    }
}
