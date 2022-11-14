package com.example.employeems.controller;

import com.example.employeems.dto.AddEmployeeRequest;
import com.example.employeems.dto.ChangeSalaryRequest;
import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addemployee")
    public EmployeeDetails addEmployee(@RequestBody AddEmployeeRequest requestData) {
        EmployeeDetails response = service.addEmployee(requestData);
        return response;
    }

    @GetMapping("/findbyid/{id}")
    public EmployeeDetails findEmployeeDetailsById(@PathVariable String id) throws Exception {
        EmployeeDetails response = service.findEmployeeById(id);
        return response;
    }

    @GetMapping("/findall")
    public List<EmployeeDetails> findAllEmployee() throws Exception {
        List<EmployeeDetails> response = service.findAll();
        return response;
    }
    @GetMapping("/findbyname/{name}")
    public List<EmployeeDetails> findAllEmployeeByName(@PathVariable String name ){
        List<EmployeeDetails> response = service.findEmployeeByName(name);
        return response;
    }

    @PutMapping("/update/salary/{id}")
    public EmployeeDetails updateEmployeeSalary(@PathVariable String id, @RequestBody ChangeSalaryRequest requestData) throws Exception {
        EmployeeDetails response = service.updateSalary(id, requestData);
        return response;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deletebyid/{id}")
    public void deleteEmployee(@PathVariable String id) throws Exception {
        service.deleteEmployee(id);
    }

}
