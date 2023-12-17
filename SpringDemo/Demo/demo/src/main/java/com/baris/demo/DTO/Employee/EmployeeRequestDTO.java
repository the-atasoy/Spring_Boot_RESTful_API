package com.baris.demo.DTO.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class EmployeeRequestDTO {
    private String name;
    private Long age;
    private String location;
    private String email;
    private UUID departmentId;
}
