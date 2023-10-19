package com.nt.beans;

import java.util.List;

public class Employee 
{
	private String eId, eName;
	private double sal;
	private List<Long> mobile;
	private Address address;

	public Employee(String eId, String eName, double sal, List<Long> mobile, Address address) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.sal = sal;
		this.mobile = mobile;
		this.address = address;
	}//constructor


	//default constructor
	public Employee() {}
	
	
	public List<Long> getMobile() {
		return mobile;
	}

	public void setMobile(List<Long> mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
}//class
