package com.kodnest.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class KodStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String email;
	@Column
	int phone;
	@OneToMany(mappedBy = "kodstudent", cascade = CascadeType.ALL)
//	List<Course> al = new ArrayList<Course>();
	List<Course> al;
	
	public List<Course> getAl() {
		return al;
	}
	public void setAl(List<Course> al) {
		this.al = al;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
