package com.baris.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column
    @NotNull(message = "name cannot be null!")
    private String name;

    @Column
    private Long age = 0L;

    @Column
    private String location;

    @Column
    @Email(message = "invalid e-mail!")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column
    private Date updatedAt;

    public Employee(String name, Long age, String location, String email, Department department) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.email = email;
        this.department = department;
    }

    public Employee() {

    }

    public void setDepartment(Optional<Department> department){
        // Set the entity's department
        // Set the entity's department to null
        this.department = department.orElse(null);
    }
}
