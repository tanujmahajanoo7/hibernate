package com.kodnest.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Student s1 = new Student();	
        s1.setName("Ramesh");
        
        Student s2 = new Student();
        s2.setName("Bhaskar");
        
        Course c1 = new Course();
        c1.setName("Java");
        
        Course c2 = new Course();
        c2.setName("Python");
        
        List<Course> courses = new ArrayList<Course>();
        courses.add(c1);
        courses.add(c2);
        
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        
//      Associating courses to all students
        s1.setCourses(courses);
        s2.setCourses(courses);
        
//      Associating all students to courses
        c1.setStudents(students);
        c2.setStudents(students);
        
        session.persist(s1);
        session.persist(s2);
        session.persist(c1);
        session.persist(c2);
        
        transaction.commit();
        session.close();
        factory.close();
    }
}
