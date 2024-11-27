package com.kodnest.ManyToManyMapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="stu_id", referencedColumnName = "id")
	KodStudent kodstudent;
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
	public KodStudent getKodstudent() {
		return kodstudent;
	}
	public void setKodstudent(KodStudent kodstudent) {
		this.kodstudent = kodstudent;
	}
	
}
