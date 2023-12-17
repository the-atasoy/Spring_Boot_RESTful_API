package com.baris.demo.Service.Employee;

import com.baris.demo.DTO.Employee.EmployeeRequestDTO;
import com.baris.demo.Model.Department;
import com.baris.demo.Model.Employee;
import com.baris.demo.Repository.IDepartmentRepository;
import com.baris.demo.Repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
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
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IDepartmentRepository departmentRepository;
    @Override
    public List<Employee> getEmployee(int pageNumber, int pageSize) {
        PageRequest pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Optional<Employee> getEmployee(UUID id) {
        return Optional.ofNullable(employeeRepository.findById(id));
    }

    @Override
    public Employee updateEmployee(UUID id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id);
        Optional<Department> department = departmentRepository.findById(dto.getDepartmentId());
        if(dto.getDepartmentId() != null) employee.setDepartment(department);
        if(dto.getName() != null) employee.setName(dto.getName());
        if(dto.getAge() != null) employee.setAge(dto.getAge());
        if(dto.getLocation() != null) employee.setLocation(dto.getLocation());
        if(dto.getEmail() != null) employee.setEmail(dto.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee saveEmployee(EmployeeRequestDTO dto) {
        Optional<Department> department = departmentRepository.findById(dto.getDepartmentId());
        Employee employee = mapper.map(dto, Employee.class);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndAge(String name, Long age) {
        return employeeRepository.findByNameAndAge(name, age);
    }

    @Override
    public List<Employee> getEmployeeByNameContaining(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return employeeRepository.findByNameContaining(keyword, sort);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return employeeRepository.getByNameOrLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String name) {
        return employeeRepository.findByDepartmentName(name);
    }


}
