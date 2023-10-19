package com.nt.student1;

import org.springframework.stereotype.Component;

@Component("address")
public class Address {
	private String street, city, state;

	public Address() {
		System.out.println("Address Object");
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}//class