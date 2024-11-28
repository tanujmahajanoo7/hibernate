package com.kodnest.ManyToOneMapping;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Department department = new Department();
        department.setName("IT");
        
        Employee employee = new Employee();
        employee.setName("Ramesh");
        employee.setSalary(5000);
        employee.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setName("Sagar");
        employee2.setSalary(10000);
        employee2.setDepartment(department);
        
        ArrayList<Employee> al = new ArrayList<>();
        al.add(employee);
        al.add(employee2);
        department.setAl(al);
        
        session.persist(department);
        transaction.commit();
        
        session.close();
        factory.close();
    }
}
