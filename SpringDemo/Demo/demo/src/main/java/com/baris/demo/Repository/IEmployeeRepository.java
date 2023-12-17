package com.baris.demo.Repository;

import com.baris.demo.Model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, UUID> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndAge(String name, Long age);

    List<Employee> findByNameContaining(String keyword, Sort sort);
    
    Employee findById(UUID id);

    Employee save(Employee employee);

    void deleteById(UUID id);

    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getByNameOrLocation(String name, String location);

    List<Employee> findByDepartmentName(String name);
}
