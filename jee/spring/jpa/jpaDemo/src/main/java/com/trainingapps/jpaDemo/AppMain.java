package com.trainingapps.jpaDemo;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppMain {
    public static void main(String[] args) {
        AppMain appMain=new AppMain();
        appMain.runApp();
    }void runApp(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("demoms");
        EntityManager em1=emf.createEntityManager();
        EntityTransaction transaction=em1.getTransaction();
        Employee employee1=new Employee("Surya",21000);
        Employee employee2=new Employee("Guchhu",48000);
        Employee employee3=new Employee("chappagadda",42000);
        transaction.begin();
        //inserting the data into the database
        em1.persist(employee1);
        em1.persist(employee2);
        em1.persist(employee3);
        transaction.commit();
        em1.close();

        // reading from the database
        int id= employee2.getId();
        EntityManager em2=emf.createEntityManager();
        Employee found=em2.find(Employee.class,id);
        System.out.println("finding employee by id "+id);
        display(found);
        em2.close();

        //updating
        EntityManager em3=emf.createEntityManager();
        EntityTransaction transaction2= em3.getTransaction();
        transaction2.begin();
        employee1.setSalary(23000);
        em3.merge(employee1);
        transaction2.commit();
        em3.close();

        // reading from the database after updating
        System.out.println("after updating");
        EntityManager em4=emf.createEntityManager();
        Employee found2=em4.find(Employee.class,id);
        System.out.println("finding employee by id "+id);
        display(found2);
        em4.close();

        // deleting row from the database
        EntityManager em5=emf.createEntityManager();
        EntityTransaction transaction3= em5.getTransaction();
        int getId= employee1.getId();
        Employee foundEmployee=em5.find(Employee.class,getId);
        transaction3.begin();
        em5.remove(foundEmployee);
        transaction3.commit();
        em5.close();

        emf.close();
    }
    void display(Employee employee){
        System.out.println("employee is - "+employee.getId()+" "+employee.getName()+" "+employee.getSalary());
    }
}
