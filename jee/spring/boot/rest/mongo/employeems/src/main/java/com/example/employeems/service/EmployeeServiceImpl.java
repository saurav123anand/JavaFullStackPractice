package com.example.employeems.service;

import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeSalaryRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import com.example.employeems.exception.EmployeeNotFoundException;
import com.example.employeems.repository.EmployeeRepository;
import com.example.employeems.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeUtil util;

    private Random random=new Random();

    public String generateId(){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<10;i++){
            int randomNum=random.nextInt(9);
            builder.append(randomNum);
        }
        String generateId=builder.toString();
        return generateId;
    }


    @Override
    public EmployeeDetails addEmployee(AddEmployeeRequest requestData) {
        Employee employee=new Employee(requestData.getName(), requestData.getSalary(),requestData.getCompany());
        employee.setId(generateId());
        Employee added=repository.save(employee);
        EmployeeDetails response= util.toEmployeeDetails(added);
        return response;

    }

    @Override
    public EmployeeDetails updateSalary(String id, ChangeSalaryRequest requestData) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        employee.setSalary(requestData.getSalary());
        Employee updated=repository.save(employee);
        EmployeeDetails response= util.toEmployeeDetails(updated);
        return response;
    }

    @Override
    public Employee findById(String id) throws EmployeeNotFoundException {
        Optional<Employee> employee=repository.findById(id);
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("employee not found for id "+id);
        }
        return employee.get();
    }

    @Override
    public EmployeeDetails findEmployeeById(String id) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        EmployeeDetails response= util.toEmployeeDetails(employee);
        return response;
    }

    @Override
    public List<EmployeeDetails> findAll() throws EmployeeNotFoundException {
        List<Employee> employees=repository.findAll();
        List<EmployeeDetails> response= util.toEmployeeDetails(employees);
        if(response.size()==0){
            throw new EmployeeNotFoundException("no employee found");
        }
        return response;
    }

    @Override
    public List<EmployeeDetails> findEmployeeByName(String name) {
        List<Employee> employees=repository.findByName(name);
        List<EmployeeDetails> response= util.toEmployeeDetails(employees);
        return response;
    }

    @Override
    public void deleteEmployee(String id) throws EmployeeNotFoundException {
        Employee employee=findById(id);
        repository.delete(employee);
    }
}
