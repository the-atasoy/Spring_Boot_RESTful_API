package com.baris.demo.Controller;

import com.baris.demo.DTO.Employee.EmployeeRequestDTO;
import com.baris.demo.Model.Employee;
import com.baris.demo.Service.Employee.EmployeeService;
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
    public List<Employee> getEmployee(@RequestParam int pageNumber, int pageSize) {
        return service.getEmployee(pageNumber, pageSize);
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
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequestDTO dto){
        // ResponseEntity should be used to specify HTTP status.
        return new ResponseEntity<>(service.saveEmployee(dto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable UUID id, @RequestBody EmployeeRequestDTO dto){
        return service.updateEmployee(id, dto);
    }

    @GetMapping("/getEmployeeByName")
    public List<Employee> getEmployeeByName(@RequestParam String name){
        return service.getEmployeeByName(name);

    }@GetMapping("/getEmployeeByNameAndAge")
    public List<Employee> getEmployeeByName(@RequestParam String name, Long age){
        return service.getEmployeeByNameAndAge(name, age);

    }

    @GetMapping("/getEmployeeByNameContaining")
    public List<Employee> getEmployeeByNameContaining(@RequestParam String keyword){
        return service.getEmployeeByNameContaining(keyword);
    }

    @GetMapping("/getEmployeeByNameOrLocation/{name}/{location}")
    public List<Employee> getEmployeeByNameOrLocation(@PathVariable String name, @PathVariable String location){
        return service.getEmployeeByNameOrLocation(name, location);
    }

    @GetMapping("/getEmployeeByDepartment")
    public List<Employee> getEmployeeByDepartment(@RequestParam String name){
        return service.getEmployeeByDepartment(name);
    }
}
