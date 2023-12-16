package com.baris.demo.Service.Employee;

import com.baris.demo.Model.Employee;
import com.baris.demo.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository repository;
    @Override
    public List<Employee> getEmployee(int pageNumber, int pageSize) {
        PageRequest pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        return repository.findAll(pages).getContent();
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

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndAge(String name, Long age) {
        return repository.findByNameAndAge(name, age);
    }

    @Override
    public List<Employee> getEmployeeByNameContaining(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return repository.findByNameContaining(keyword, sort);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return repository.getByNameOrLocation(name, location);
    }


}
