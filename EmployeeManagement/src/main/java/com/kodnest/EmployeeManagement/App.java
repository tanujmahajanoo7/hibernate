package com.kodnest.EmployeeManagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	static Scanner sc = new Scanner(System.in);
	static SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session session = null;
	static Transaction transaction = null;
	
    public static void main(String[] args) {
    	System.out.println("Employee Management System");
    	while(true) {
    		System.out.println("Press 1 to read employee");
    		System.out.println("Press 2 to add employee");
    		System.out.println("Press 3 to remove employee");
    		System.out.println("Press 4 to update employee");
    		System.out.println("Press any other number to stop");
    		
    		int choice = sc.nextInt();
    		
    		switch(choice) {
	    		case 1->readEmployee();
	    		case 2->addEmployee();
	    		case 3->removeEmployee();
	    		case 4->updateEmployee();
	    		default -> {
	    			System.out.println("Program stopped");		
//	    	    	factory.close();
	    			return;
	    		}
    		}
    	}
    }
    
    public static void readEmployee() {
    	System.out.println("Enter id to read");
    	int input_id = sc.nextInt();
        session = factory.openSession();
        transaction = session.beginTransaction();
        Employee obj = session.get(Employee.class, input_id);
        if(obj!=null) {
        	System.out.println("ID: " + obj.getId());
        	System.out.println("Name: " + obj.getName());
        	System.out.println("Salary: " + obj.getSalary());
        	System.out.println("Phone number: " + obj.getPhoneno());
        	System.out.println("Email: " + obj.getEmail());
        	System.out.println("Type: " + obj.getType());
        }
        else {
        	System.out.println("Student with id is not present");
        }
        transaction.commit();
        session.close();
    }
    
    public static void addEmployee() {
        session = factory.openSession();
        transaction = session.beginTransaction();
        Employee emp = new Employee();
//        System.out.print("Enter id: ");
//        emp.setId(sc.nextInt());
//        System.out.println();
        System.out.print("Enter name: ");
        emp.setName(sc.next());
        System.out.println();
        System.out.print("Enter salary: ");
        emp.setSalary(sc.nextInt());
        System.out.println();
        System.out.print("Enter phone: ");
        emp.setPhoneno(sc.nextInt());
        System.out.println();
        System.out.print("Enter email: ");
        emp.setEmail(sc.next());
        System.out.println();
        System.out.print("Enter type: ");
        emp.setType(sc.next());
        System.out.println();
        session.persist(emp);
        transaction.commit();
        System.out.println("Employee details saved successfully!");
        session.close();
    }
    public static void removeEmployee() {
    	System.out.println("Enter id to delete: ");
    	int id = sc.nextInt();
    	session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee obj = session.get(Employee.class,id);
        if(obj!=null) {
        	session.remove(obj);
        } 
        else {
        	System.out.println("Student data not present");
        }
        transaction.commit();
        session.close();
    }
    @SuppressWarnings({ "deprecation" })
	public static void updateEmployee() {
		session = factory.openSession();
	    transaction = session.beginTransaction();
    	System.out.print("Enter id to update details: ");
    	int id = sc.nextInt();
    	Employee obj = session.get(Employee.class,id);
    	if(obj!=null) {
    		System.out.println("Choose to update");
    		System.out.println("1:name, 2:salary, 3:phone, 4:email, 5:type");
    		int option = sc.nextInt();
    		switch (option) {
    		case 1:
    			System.out.println("Enter new name");
    			String name = sc.next();
    			obj.setName(name);
    			break;
    		case 2:
    			System.out.println("Enter new salary");
    			int salary= sc.nextInt();
    			obj.setSalary(salary);
    			break;
    		case 3:
    			System.out.println("Enter new phone");
    			int phone= sc.nextInt();
    			obj.setPhoneno(phone);
    			break;
    		case 4:
    			System.out.println("Enter new email");
    			String email = sc.next();
    			obj.setEmail(email);
    			break;
    		default:
    			System.out.println("Enter new name");
    			String type = sc.next();
    			obj.setType(type);
    			break;    		
    		}
    		session.update(obj);
    	}
    	else {
    		System.out.println("Update not possible as entry not found");
    	}
    	transaction.commit();
    	session.close();
    }
}
