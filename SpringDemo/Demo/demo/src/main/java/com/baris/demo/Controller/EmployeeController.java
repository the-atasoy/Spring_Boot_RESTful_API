package com.baris.demo.Controller;

import com.baris.demo.Model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @GetMapping("/getEmployee")
    public String getEmployee() {
        return "You see list of all employees.";
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
