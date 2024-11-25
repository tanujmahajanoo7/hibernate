package com.kodnest.hibernate.DeleteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student obj = session.get(Student.class,3);
        if(obj!=null) {
        	session.remove(obj);
        } 
        else {
        	System.out.println("Student data not present");
        }
        transaction.commit();
        session.close();
        factory.close();
    }
}
