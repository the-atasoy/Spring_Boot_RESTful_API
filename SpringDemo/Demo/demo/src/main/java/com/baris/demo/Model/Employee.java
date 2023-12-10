package com.baris.demo.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
    @Email(message = "e-mail cannot be null!")
    private String email;
    @Column
    private String department;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column
    private Date updatedAt;
}
