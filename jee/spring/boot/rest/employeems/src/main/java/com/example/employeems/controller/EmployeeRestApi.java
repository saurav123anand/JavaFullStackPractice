package com.example.employeems.controller;

import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeDesignationRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApi {
    @Autowired
    private IEmployeeService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDetails addEmployee(@RequestBody AddEmployeeRequest requestData){
        EmployeeDetails response=service.addEmployee(requestData);
        return response;
    }
    @PutMapping("/update/designation/{id}")
    public EmployeeDetails updateEmployee(@PathVariable int id,@RequestBody ChangeDesignationRequest requestData) throws Exception{
        EmployeeDetails response=service.changeDesignation(id,requestData);
        return response;
    }

    @GetMapping("/findbyid/{id}")
    public EmployeeDetails findEmployeeById(@PathVariable int id) throws Exception{
        EmployeeDetails response=service.findEmployeeDetailsById(id);
        return response;
    }
    @GetMapping("/findbyname/{name}")
    public List<EmployeeDetails> findEmployeesByName(@PathVariable String name) throws Exception{
        List<EmployeeDetails> response=service.findByName(name);
        return response;
    }

    @GetMapping("/findall")
    public List<EmployeeDetails> findAllEmployees(){
        List<EmployeeDetails> response=service.findAll();
        return response;
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteEmployee(@PathVariable int id) throws Exception{
        String msg=service.deleteEmployee(id);
        return msg;
    }







}
