package com.example.employeems.service;

import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeDesignationRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import com.example.employeems.exception.EmployeeNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IEmployeeService {
    EmployeeDetails addEmployee(@Valid AddEmployeeRequest requestData);
    EmployeeDetails changeDesignation(@Min(1) int id,@Valid ChangeDesignationRequest requestData) throws EmployeeNotFoundException;
    Employee findById(@Min(value = 1,message = "id shouldn't be less than 1") int id) throws EmployeeNotFoundException;
    EmployeeDetails findEmployeeDetailsById(@Min(value = 1,message = "id shouldn't be less than 1") int id) throws EmployeeNotFoundException;
    List<EmployeeDetails> findByName(@NotNull @Length(min = 2) String name);
    List<EmployeeDetails> findAll();
    String deleteEmployee(@Min(1) int id) throws EmployeeNotFoundException;


}
