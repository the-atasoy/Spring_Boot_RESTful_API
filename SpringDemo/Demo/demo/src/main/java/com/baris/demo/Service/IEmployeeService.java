package com.baris.demo.Service;

import com.baris.demo.Model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService
{
    public List<Employee> getEmployee();
    public Optional<Employee> getEmployee(UUID id);
    public Employee updateEmployee(UUID id, Employee employee);
    public void deleteEmployee(UUID id);
    public Employee saveEmployee(Employee employee);
}
