package com.baris.demo.Service.Employee;

import com.baris.demo.DTO.Employee.EmployeeRequestDTO;
import com.baris.demo.Model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService
{
    List<Employee> getEmployee(int pageNumber, int pageSize);
    Optional<Employee> getEmployee(UUID id);
    Employee updateEmployee(UUID id, EmployeeRequestDTO dto);
    void deleteEmployee(UUID id);
    Employee saveEmployee(EmployeeRequestDTO dto);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByNameAndAge(String name, Long age);
    List<Employee> getEmployeeByNameContaining(String keyword);
    List<Employee> getEmployeeByNameOrLocation(String name, String location);
    List<Employee> getEmployeeByDepartment(String name);
}
