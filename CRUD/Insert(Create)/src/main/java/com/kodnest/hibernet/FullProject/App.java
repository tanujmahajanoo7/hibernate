package com.kodnest.hibernet.FullProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
//      1. Load Configuration and Build SessionFactory
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	
//    	2. Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//      3. Open Session
        Session session = sessionFactory.openSession();

//      4. Begin Transaction
        Transaction transaction = session.beginTransaction();
        
//      5. Execute Persist/Perform Operation
        Student student = new Student();
        student.setName("Rahul");
        student.setMarks(99);
        student.setGender("Male");
        student.setEmail("rahul@gmail.com");
        student.setPhone("8574839484");

        session.persist(student);

//      6. Commit Transaction
        transaction.commit();

//      7. Print Confirmation
        System.out.println("Student saved successfully!");

//      8. Close Session and SessionFactory
        session.close();
        sessionFactory.close();
    }
}


//CREATE DATABASE KodnestDb;
//
//USE KodnestDb;
//
//CREATE TABLE student (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    name VARCHAR(50) NOT NULL,
//    marks DOUBLE NOT NULL,
//    gender VARCHAR(10) NOT NULL,
//    email VARCHAR(50),
//    phone VARCHAR(15)
//);