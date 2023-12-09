package com.baris.demo.Service;

import com.baris.demo.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private static final List<Employee> employees = new ArrayList<>();
    static{
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        e1.setAge(21L);
        e1.setName("Baris Atasoy");
        e1.setEmail("barisatasoy2917@gmail.com");
        e1.setDepartment("Software Development");
        e1.setLocation("Eskisehir");
        employees.add(e1);
        e2.setAge(20L);
        e2.setName("Sevde Secer");
        e2.setEmail("sevdeeseceer@gmail.com");
        e2.setDepartment("Software Development");
        e2.setLocation("Eskisehir");
        employees.add(e2);
        e3.setAge(30L);
        e3.setName("Ali Veli");
        e3.setEmail("aliveli@outlook.com");
        e3.setDepartment("Accounting");
        e3.setLocation("London");
        employees.add(e3    );
    }
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}
