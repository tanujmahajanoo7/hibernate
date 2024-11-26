package com.kodnest.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	Address address = new Address();
    	address.setCity("Bengluru");
    	address.setStreet("BTM LAYOUT");
    	
    	Student student = new Student();
    	student.setId(1);
    	student.setName("Kamlesh");
    	student.setEmail("Kamlesh@gmail.com");
    	student.setPhone(7383);
    	student.setAddress(address);
    	
    	session.persist(student);
    	transaction.commit();
    	
    	session.close();
    	factory.close();
    	
    }
}
