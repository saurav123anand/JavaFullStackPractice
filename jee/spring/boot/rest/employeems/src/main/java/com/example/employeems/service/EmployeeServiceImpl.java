package com.example.employeems.service;

import com.example.employeems.dao.IEmployeeDao;
import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeDesignationRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import com.example.employeems.exception.EmployeeNotFoundException;
import com.example.employeems.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDao dao;
    @Autowired
    private EmployeeUtil util;

    @Override
    public EmployeeDetails addEmployee(AddEmployeeRequest requestData) {
        Employee employee=new Employee(requestData.getName(),requestData.getSalary(),requestData.getDesignation());
        employee=dao.save(employee);
        EmployeeDetails employeeDetails=util.toEmployeeDetails(employee);
        return employeeDetails;
    }

    @Override
    public EmployeeDetails changeDesignation(int id, ChangeDesignationRequest requestData) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        employee.setDesignation(requestData.getDesignation());
        Employee updatedEmployee=dao.save(employee);
        EmployeeDetails employeeDetails=util.toEmployeeDetails(updatedEmployee);
        return employeeDetails;
    }

    @Override
    public Employee findById(int id) throws EmployeeNotFoundException {
        Employee employee=dao.findById(id);
        if(employee==null){
            throw new EmployeeNotFoundException("Employee not found for id "+id);
        }
        return employee;
    }

    @Override
    public EmployeeDetails findEmployeeDetailsById(int id) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        EmployeeDetails employeeDetails=util.toEmployeeDetails(employee);
        return employeeDetails;
    }

    @Override
    public List<EmployeeDetails> findByName(String name) {
        List<Employee> employees=dao.findByName(name);
        List<EmployeeDetails> employeeDetails=util.toEmployeeDetails(employees);
        return employeeDetails;

    }

    @Override
    public List<EmployeeDetails> findAll() {
        List<Employee> employees=dao.findAll();
        List<EmployeeDetails> employeeDetails=util.toEmployeeDetails(employees);
        return employeeDetails;
    }

    @Override
    public String deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        dao.delete(employee);
        return "Employee with id "+id+" has been deleted";
    }

}
