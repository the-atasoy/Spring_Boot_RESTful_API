package com.baris.demo.Service;

import com.baris.demo.Model.Employee;
import com.baris.demo.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository repository;
    @Override
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Employee updateEmployee(UUID id, Employee employee) {
        employee.setId(id);
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }


}
