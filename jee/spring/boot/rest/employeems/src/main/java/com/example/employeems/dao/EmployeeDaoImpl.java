package com.example.employeems.dao;

import com.example.employeems.dto.EmployeeDetails;
import com.example.employeems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Employee save(Employee employee) {
        Employee added=entityManager.merge(employee);
        return added;
    }

    @Override
    public Employee findById(int id) {
       Employee employee= entityManager.find(Employee.class,id);
       return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        String query="From Employee where name=:nameArg";
        TypedQuery<Employee> typedQuery= entityManager.createQuery(query,Employee.class);
        typedQuery.setParameter("nameArg",name);
        List<Employee> result=typedQuery.getResultList();
        return result;
    }

    @Override
    public List<Employee> findAll() {
        String query="From Employee";
        TypedQuery<Employee> typedQuery= entityManager.createQuery(query,Employee.class);
        List<Employee> result=typedQuery.getResultList();
        return result;
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
