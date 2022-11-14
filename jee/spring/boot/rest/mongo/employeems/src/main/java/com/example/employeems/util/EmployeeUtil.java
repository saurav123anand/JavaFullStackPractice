package com.example.employeems.util;

import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeUtil {
    public EmployeeDetails toEmployeeDetails(Employee employee){
        EmployeeDetails employeeDetails=new EmployeeDetails();
        employeeDetails.setId(employee.getId());
        employeeDetails.setName(employee.getName());
        employeeDetails.setSalary(employee.getSalary());
        employeeDetails.setCompany(employee.getCompany());
        return employeeDetails;
    }
    public List<EmployeeDetails> toEmployeeDetails(List<Employee> employees){
        List<EmployeeDetails> employeeDetailsList=new ArrayList<>();
        for(Employee employee:employees){
            EmployeeDetails employeeDetails=toEmployeeDetails(employee);
            employeeDetailsList.add(employeeDetails);
        }

        return employeeDetailsList;
    }
}
