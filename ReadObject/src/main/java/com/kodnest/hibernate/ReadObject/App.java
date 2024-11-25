package com.kodnest.hibernate.ReadObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Student obj = session.get(Student.class, 2);
        if(obj!=null) {
        	System.out.println("ID: " + obj.getId());
        	System.out.println("Name: " + obj.getName());
        	System.out.println("Marks: " + obj.getMarks());
        	System.out.println("Gender: " + obj.getGender());
        	System.out.println("Email: " + obj.getEmail());
        	System.out.println("Phone no: " + obj.getPhone());
        }
        else {
        	System.out.println("Student with id is not present");
        }
        transaction.commit();
        session.close();
        factory.close();
    }
}
