package com.example.employeems.repository;

import com.example.employeems.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee>findByName(String name);
    List<Employee> findByNameOrSalary(String name,double salary);
}
