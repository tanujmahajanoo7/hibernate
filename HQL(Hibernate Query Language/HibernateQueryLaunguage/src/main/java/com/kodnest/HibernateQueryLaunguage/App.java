package com.kodnest.HibernateQueryLaunguage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from Product where cost > 4000";
        Query<Product> query = session.createQuery(hql,Product.class);
        List<Product> productList = query.getResultList();	
        for(Product p : productList) {
        	System.out.println("Id: "+p.id + " ");
        	System.out.println("Name: "+p.name + " ");
        	System.out.println("Cost: "+p.cost + " ");
        	System.out.println();
        }
        transaction.commit();
        session.close();
        factory.close();
    }
}
