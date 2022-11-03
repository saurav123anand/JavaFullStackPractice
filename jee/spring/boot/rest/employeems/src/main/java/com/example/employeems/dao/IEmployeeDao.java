package com.example.employeems.dao;

import com.example.employeems.entity.Employee;
import jdk.internal.net.http.LineSubscriberAdapter;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEmployeeDao {
    Employee save(Employee employee);
    Employee findById(int id);
    List<Employee> findByName(String name);
    List<Employee> findAll();
    void delete(Employee employee);

}
