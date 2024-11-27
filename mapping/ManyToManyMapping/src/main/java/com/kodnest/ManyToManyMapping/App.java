package com.kodnest.ManyToManyMapping;

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
        
        Course course1 = new Course();
        course1.setName("Java");
        
        Course course2 = new Course();
        course2.setName("Python");
        
        KodStudent kodstudent = new KodStudent();
        kodstudent.setName("Karan");
        kodstudent.setEmail("karan@gmail.com");
        kodstudent.setPhone(9989);
//        kodstudent.al.add(course1);
//        kodstudent.al.add(course2);
        
        ArrayList<Course> al = new ArrayList<Course>();
        al.add(course1);
        al.add(course2);
        kodstudent.setAl(al);
        
        course1.setKodstudent(kodstudent);
        course2.setKodstudent(kodstudent);
        
        session.persist(kodstudent);
        
        session.close();
        factory.close();
        
    }
}
