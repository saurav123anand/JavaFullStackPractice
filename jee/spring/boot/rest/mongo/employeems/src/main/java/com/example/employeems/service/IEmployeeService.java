package com.example.employeems.service;

import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeSalaryRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import com.example.employeems.exception.EmployeeNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IEmployeeService {
    EmployeeDetails addEmployee(@Valid AddEmployeeRequest requestData);
    EmployeeDetails updateSalary(@Length(min = 4) String id, ChangeSalaryRequest requestData) throws EmployeeNotFoundException;
    Employee findById(@Length(min = 4) String id) throws EmployeeNotFoundException;
    EmployeeDetails findEmployeeById(@Length(min = 4) String id) throws EmployeeNotFoundException;
    List<EmployeeDetails> findAll() throws EmployeeNotFoundException;
    List<EmployeeDetails> findEmployeeByName(@Length(min = 3) String name);
    void deleteEmployee(@Length(min = 4) String id) throws EmployeeNotFoundException;
}
