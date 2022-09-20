package com.trainingapps.jpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppMain2 {
    private EntityManager em;
    public static void main(String[] args) {
        AppMain2 appMain=new AppMain2();
        appMain.runApp();
    }
    void runApp(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("demoms");
        em=emf.createEntityManager();
        Employee employee1=add("fatima",48000);
        Employee employee2=add("Rahul",38000);
        System.out.println("getting added employee");
        display(employee1);
        display(employee2);

        int id =employee2.getId();
        System.out.println("getting employee after adding with id "+id);
        Employee found=findById(id);
        display(found);

        System.out.println("updating");
        employee1.setSalary(50000);
        Employee updated=update(employee1);
        display(updated);

        System.out.println("deleting employee");
        int getId= employee2.getId();
        String msg=delete(getId);
        System.out.println(msg);

        em.close();
        emf.close();
    }
    Employee add(String name,double  salary){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        Employee employee=new Employee(name,salary);
        em.persist(employee);
        transaction.commit();
        return employee;
    }
    Employee findById(int id){
        Employee found=em.find(Employee.class,id);
        return found;
    }
    Employee update(Employee employee){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.merge(employee);
        transaction.commit();
        return employee;
    }
    String delete(int id){
        EntityTransaction transaction= em.getTransaction();
        Employee foundEmployee=em.find(Employee.class,id);
        transaction.begin();
        em.remove(foundEmployee);
        transaction.commit();
        return "row has been deleted with id "+id;
    }
    void display(Employee employee){
        System.out.println("employee is - "+employee.getId()+" "+employee.getName()+" "+employee.getSalary());
    }
}
