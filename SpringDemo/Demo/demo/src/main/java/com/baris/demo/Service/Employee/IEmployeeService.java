package com.baris.demo.Service.Employee;

import com.baris.demo.DTO.Employee.EmployeeRequestDTO;
import com.baris.demo.Model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService
{
    public List<Employee> getEmployee(int pageNumber, int pageSize);
    public Optional<Employee> getEmployee(UUID id);
    public Employee updateEmployee(UUID id, EmployeeRequestDTO dto);
    public void deleteEmployee(UUID id);
    public Employee saveEmployee(EmployeeRequestDTO dto);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByNameAndAge(String name, Long age);
    List<Employee> getEmployeeByNameContaining(String keyword);
    List<Employee> getEmployeeByNameOrLocation(String name, String location);
    List<Employee> getEmployeeByDepartment(String name);
}
