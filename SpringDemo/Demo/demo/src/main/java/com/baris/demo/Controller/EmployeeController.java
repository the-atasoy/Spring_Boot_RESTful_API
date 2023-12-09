package com.baris.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @GetMapping("/getEmployee")
    public String getEmployee() {
        return "You see list of all employees.";
    }

    // getting data from client to server with path variable
    @GetMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        return "You see the employee with id " + id + ".";
    }

    // getting data from client to server with request param
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Long id) {
        return "The employee with id " + id + " has been deleted.";
    }
}
