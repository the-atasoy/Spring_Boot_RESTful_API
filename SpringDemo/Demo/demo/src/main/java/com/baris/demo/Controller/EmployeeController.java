package com.baris.demo.Controller;

import com.baris.demo.Model.Employee;
import com.baris.demo.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/getEmployee")
    public List<Employee> getEmployee() {
        return service.getEmployee();
    }

    // getting data from client to server with path variable
    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable UUID id) {
        return service.getEmployee(id);
    }

    // getting data from client to server with request param
    // this is delete request also, by this way anybody cannot access data using only browser
    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@RequestParam UUID id) {
        service.deleteEmployee(id);
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        // ResponseEntity should be used to specify HTTP status.
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable UUID id, @RequestBody Employee employee){
        return service.updateEmployee(id, employee);
    }
}
