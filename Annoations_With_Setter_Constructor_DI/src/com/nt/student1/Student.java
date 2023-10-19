package com.nt.student1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name;
	private int id;
	
	
	//Field Injection
	@Autowired
	private Address address;

	//0-Parameterized
	public Student() 
	{
		System.out.println("Student Object");
	}

	@Autowired
	public Student(Address address) 
	{
		this.address = address;
	}//constructor injection with Annotation in fields

	public Address getAddress() {
		return address;
	}
    //@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}//class