package com.kodnest.hibernate.UpdateObject;

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
    	Student obj = session.get(Student.class,1);
    	if(obj!=null) {
    		obj.setName("Ravi");
    		obj.setMarks(99);
    		session.update(obj);
    	}
    	else {
    		System.out.println("Update not possible as entry not found");
    	}
    	transaction.commit();
    	session.close();
    	factory.close();
    }
}
