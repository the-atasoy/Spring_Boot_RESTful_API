package com.baris.demo.Controller;

import com.baris.demo.Model.Employee;
import com.baris.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getEmployee")
    public List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    // getting data from client to server with path variable
    @GetMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable Long id) {
        return "You see the employee with id " + id + ".";
    }

    // getting data from client to server with request param
    // this is delete request also, by this way anybody cannot access data using only browser
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long id) {
        return "The employee with id " + id + " has been deleted.";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        return employee.toString() + " has been saved.";
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("The employee with id " + id + " has been updated to " + employee.toString());
        return employee;
    }
}
